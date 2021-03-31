package com.wemakeprice.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MixStringUtilTest {

    @ParameterizedTest
    @MethodSource("sampleDataList")
    @DisplayName("제대로 섞였는지 테스트")
    void mixString(String alphabet, String numbers, String mixStringResult) {
        List<Character> sortingAlphabet = SortingUtil.sortingAlphabet(alphabet);
        List<Character> sortingNumber = SortingUtil.sortingNumber(numbers);
        String mixString = MixStringUtil.mixString(sortingAlphabet, sortingNumber);

        assertEquals(mixString, mixStringResult);
    }

    private static Stream<Arguments> sampleDataList() {
        return Stream.of(
                Arguments.of( "BbAaaDdEeg", "987654321", "A1a2a3B4b5D6d7E8e9g"),
                Arguments.of( "AAaaBb", "12345", "A1A2a3a4B5b"),
                Arguments.of("AAaa", "123456", "A1A2a3a456"),
                Arguments.of("BbCc", "12", "B1b2Cc")
        );
    }
}