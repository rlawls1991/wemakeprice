package com.wemakeprice.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wemakeprice.common.RestDocsConfiguration;
import com.wemakeprice.dto.ParsingParamDto;
import com.wemakeprice.dto.ParsingResultDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@Import(RestDocsConfiguration.class)
public class ParsingUrlApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private static final String TEST_URL = "https://github.com/rlawls1991/wemakeprice";

    @Test
    @DisplayName("정상적으로 parsing 된 결과를 받는 경우 테스트")
    void parsingUrl() throws Exception {
        // Given
        ParsingParamDto parsingParamDto = ParsingParamDto.builder()
                .url(TEST_URL)
                .printStatus("TEXT")
                .bundle(10)
                .build();

        // When
        ResultActions perform = mockMvc.perform(get("/api/parse")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(this.objectMapper.writeValueAsString(parsingParamDto)))
                .andDo(print());

        // Then
        perform.andExpect(status().isOk())
                .andExpect(jsonPath("quotient").exists())
                .andExpect(jsonPath("remainder").exists())
                .andDo(document("parsing_success"))
                .andDo(print())
        ;
    }

    @Test
    @DisplayName("입력받을 수 없는 값을 사용한 경우에 에러가 발생하는 테스트")
    void parsingUrl_Bad_Request() throws Exception {
        // Given
        ParsingResultDto ParsingResultDto = new ParsingResultDto("123", "2222");

        // When
        ResultActions perform = mockMvc.perform(get("/api/parse")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(this.objectMapper.writeValueAsString(ParsingResultDto)))
                .andDo(print());

        // Then
        perform.andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("printStatus가 TEXT 또는 REMOVE가 아닌 경우 발생하는 테스트")
    void parsingUrl_Bad_Request_Wrong_Input_PrintStatus() throws Exception {
        // Given
        ParsingParamDto parsingParamDto = ParsingParamDto.builder()
                .url(TEST_URL)
                .printStatus("123")
                .bundle(10)
                .build();

        // When
        ResultActions perform = mockMvc.perform(get("/api/parse")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(this.objectMapper.writeValueAsString(parsingParamDto)))
                .andDo(print());

        // Then
        perform.andExpect(status().isBadRequest())
            .andExpect(jsonPath("message").value("printStatus을 확인해주세요"))
            .andExpect(jsonPath("errorMessage").value("printStatus은 TEXT 또는 REMOVE 만 가능합니다."))
        ;
    }

    @Test
    @DisplayName("bundle의 값이 잘못 들어갔을 때 발생되는 에러")
    void parsingUrl_Bad_Request_Wrong_Input_bundle() throws Exception {
        // Given
        ParsingParamDto parsingParamDto = ParsingParamDto.builder()
                .url(TEST_URL)
                .printStatus("TEXT")
                .bundle(-10)
                .build();

        // When
        ResultActions perform = mockMvc.perform(get("/api/parse")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(this.objectMapper.writeValueAsString(parsingParamDto)))
                .andDo(print());

        // Then
        perform.andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Url 값이 잘못 들어갔을 때 발생되는 에러")
    void parsingUrl_Bad_Request_Wrong_Input_Url() throws Exception {
        // Given
        ParsingParamDto parsingParamDto = ParsingParamDto.builder()
                .url("test")
                .printStatus("TEXT")
                .bundle(10)
                .build();

        // When
        ResultActions perform = mockMvc.perform(get("/api/parse")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .content(this.objectMapper.writeValueAsString(parsingParamDto)))
                .andDo(print());

        // Then
        perform.andExpect(status().isBadRequest());
    }
}