package com.wemakeprice.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateUtilTest {

    @ParameterizedTest
    @MethodSource("sampleQuotientList")
    @DisplayName("몫이 제대로 나왔는지")
    void calculateQuotient(String text, int bundle, String quotientResult) {
        String quotient = CalculateUtil.calculateQuotient(text, bundle);

        // 몫과 결과가 같은지
        assertEquals(quotient, quotientResult);
        // (문자길이 / 묶음단위) = (몫 길이 / 묶음단위)
        assertEquals(text.length() / bundle, quotient.length() / bundle);
    }

    @ParameterizedTest
    @MethodSource("sampleRemainderList")
    @DisplayName("나머지가 제대로 나왔는지")
    void calculateRemainder(String text, int bundle, String remainderResult) {
        String remainder = CalculateUtil.calculateRemainder(text, bundle);
        String quotient = CalculateUtil.calculateQuotient(text, bundle);

        // 나머지와 결과가 같은지
        assertEquals(remainder, remainderResult);
        // (문자길이 - 몫 길이) = 나머지 길이
        assertEquals((text.length() - quotient.length()), remainder.length());
    }

    private static Stream<Arguments> sampleRemainderList() {
        return Stream.of(
                Arguments.of("A1a2a3B4b5D6d7E83e9g1", 5 , "1"),
                Arguments.of("A1A2a3a4B5bffd", 10, "bffd"),
                Arguments.of("A1A2a3a4567", 4, "567"),
                Arguments.of("B1b2Ccd", 2, "d")
        );
    }

    private static Stream<Arguments> sampleQuotientList() {
        return Stream.of(
                Arguments.of("A1a2a3B4b5D6d7E83e9g1", 5 , "A1a2a3B4b5D6d7E83e9g"),
                Arguments.of("A1A2a3a4B5b", 10, "A1A2a3a4B5"),
                Arguments.of("A1A2a3a456", 4, "A1A2a3a4"),
                Arguments.of("B1b2Cc", 2, "B1b2Cc")
        );
    }
}