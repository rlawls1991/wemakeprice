package com.wemakeprice.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SortingUtilTest {

    @ParameterizedTest
    @MethodSource("sampleNumberList")
    @DisplayName("오름차순으로 정렬된 숫자 리스트가 제대로 정렬되어 있는지 테스트")
    void sortingNumber(String text) {
        List<Character> sortNumber = SortingUtil.sortingNumber(text);
        boolean checkSort = true;

        for (int i = 0; i < sortNumber.size() - 1; i++) {
            checkSort = compareNumber(sortNumber.get(i), sortNumber.get(i + 1));

            if (!checkSort) {
                break;
            }
        }

        assertEquals(checkSort, true);
    }

    @ParameterizedTest
    @MethodSource("sampleAlphabetList")
    @DisplayName("오름차순으로 정렬된 숫자 리스트가 제대로 정렬되어 있는지 테스트")
    void sortingAlphabet(String text) {
        List<Character> sortAlphabet = SortingUtil.sortingAlphabet(text);
        boolean checkSort = true;

        for (int i = 0; i < sortAlphabet.size() - 1; i++) {
            checkSort = compareAlphabet(sortAlphabet.get(i), sortAlphabet.get(i + 1));

            if (!checkSort) {
                break;
            }
        }

        assertEquals(checkSort, true);
    }

    /**
     * 알파벳 두개 값을 비교 <br/>
     * first가 클경우 false <br/>
     * second가 클경우 true <br/>
     *
     * @param first
     * @param second
     * @return boolean
     */
    private boolean compareAlphabet(Character first, Character second) {
        char firstChar = Character.toLowerCase(first);
        char secondChar = Character.toLowerCase(second);

        return ((secondChar - firstChar) >= 0) ? true : false;
    }

    /**
     * 숫자의 두개 값을 비교 <br/>
     * first가 클경우 false <br/>
     * second가 클경우 true <br/>
     *
     * @param first
     * @param second
     * @return boolean
     */
    private boolean compareNumber(Character first, Character second) {
        int firstNumber = (int) first;
        int secondNumber = (int) second;

        return (first <= second) ? true : false;
    }

    private static Stream<Arguments> sampleNumberList() {
        return Stream.of(
                Arguments.of("3214578899123"),
                Arguments.of("1223121548793"),
                Arguments.of("1230105457812"),
                Arguments.of("125454988783"),
                Arguments.of("365454545123")
        );
    }

    private static Stream<Arguments> sampleAlphabetList() {
        return Stream.of(
                Arguments.of("aAaaaBBBBcccDDdeeeTYTYU"),
                Arguments.of("dpofDickgfFDAAAjedkfjgaaadkdi"),
                Arguments.of("gggldDogikelDDDDdocuib"),
                Arguments.of("dfcjFkFFfgieiwnd"),
                Arguments.of("dkfikgHHDFiDGDGDgjtj")
        );
    }
}