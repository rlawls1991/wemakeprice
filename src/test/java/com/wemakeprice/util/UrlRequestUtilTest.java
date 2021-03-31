package com.wemakeprice.util;

import com.wemakeprice.exception.UrlNullPointException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.*;

public class UrlRequestUtilTest {

    private final String TEST_URL_TRUE = "https://rlawls1991.tistory.com/";
    private final String TEST_URL_FALSE = "https://testtestets.com/";

    @Test
    @DisplayName("URL을 입력받아 html 형태로 데이터를 받았는지")
    public void urlRequestTest_True() throws Exception {
        String urlRequest = UrlRequestUtil.httpRequest(TEST_URL_TRUE);

        // html 태그가 포함되어있는지
        assertTrue(urlRequest.contains("<html"));
        assertTrue(urlRequest.contains("</html>"));

        // head 태그가 포함되어있는지
        assertTrue(urlRequest.contains("<head"));
        assertTrue(urlRequest.contains("</head>"));

        // body 태그가 포함되어있는지
        assertTrue(urlRequest.contains("<body"));
        assertTrue(urlRequest.contains("</body>"));
    }

    @Test
    @DisplayName("URL을 잘못 입력되었을 때 발생되는 에러 테스트")
    public void urlRequestTest_False() throws Exception {
        UnknownHostException exception = assertThrows(UnknownHostException.class,
                () -> UrlRequestUtil.httpRequest(TEST_URL_FALSE));

        String errorMessage = exception.getMessage();

        assertEquals(errorMessage, "URL을 잘못 입력했습니다.");
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("URL을 null 또는 Empty로 넘겼을 때 발생되는 에러 테스트")
    public void urlRequestTest_Null_Or_Empty_Check(String url) throws Exception {
        UrlNullPointException exception = assertThrows(UrlNullPointException.class,
                () -> UrlRequestUtil.httpRequest(url));

        String errorMessage = exception.getMessage();

        assertEquals(errorMessage, "Url이 null이거나 비어있습니다.");
    }
}