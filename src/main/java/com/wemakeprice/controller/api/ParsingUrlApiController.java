package com.wemakeprice.controller.api;

import com.wemakeprice.dto.ParsingParamDto;
import com.wemakeprice.error.ApiResponseMessage;
import com.wemakeprice.error.ErrorsResource;
import com.wemakeprice.service.ParsingUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/parse", consumes = MediaType.APPLICATION_JSON_VALUE)
public class ParsingUrlApiController {

    private final ParsingUrlService parsingUrlService;

    @PostMapping
    public ResponseEntity parsingUrl(@RequestBody @Valid ParsingParamDto parsingParamDto, Errors errors) {
        if (errors.hasErrors()) {
            return new ResponseEntity<>(new ErrorsResource(errors), HttpStatus.BAD_REQUEST);
        }

        if (!("TEXT".equals(parsingParamDto.getPrintStatus()) || "REMOVE".equals(parsingParamDto.getPrintStatus()))) {
            ApiResponseMessage apiResponseMessage = new ApiResponseMessage("printStatus을 확인해주세요", "printStatus은 TEXT 또는 REMOVE 만 가능합니다.");
            return new ResponseEntity<>(apiResponseMessage, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(parsingUrlService.getParsingResult(parsingParamDto), HttpStatus.OK);
    }
}
