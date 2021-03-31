package com.wemakeprice.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ReplaceUtilTest {

    @ParameterizedTest
    @MethodSource("sampleDataList")
    @DisplayName("기본적인 개행문자가 제거 되었는지 테스트")
    void replaceBasic(String param) {
        String removeText = ReplaceUtil.replaceBasic(param);

        assertEquals(removeText.equals("\n"), false);
        assertEquals(removeText.equals("\r"), false);
    }

    @ParameterizedTest
    @MethodSource("sampleDataList")
    @DisplayName("해당값이 숫자로만 존재하는지 테스트")
    void returnNumber(String param) {
        String removeText = ReplaceUtil.returnNumber(param);

        assertEquals(removeText.matches("[+-]?\\d*(\\.\\d+)?"), true);
    }

    @ParameterizedTest
    @MethodSource("sampleDataList")
    @DisplayName("해당값이 알파벳으로만 존재하는지 테스트")
    void returnAlphabet(String param) {
        String removeText = ReplaceUtil.returnAlphabet(param);

        assertEquals(removeText.matches("[a-zA-Z]+"), true);
    }

    @ParameterizedTest
    @MethodSource("sampleRemoveTagList")
    @DisplayName("태그 삭제가 되는지 테스트")
    void removeTag(String param){
        String removeTag = ReplaceUtil.removeTag(param);

        assertEquals(removeTag, "");
    }

    private static Stream<Arguments> sampleRemoveTagList(){
        return Stream.of(
                Arguments.of("<html><body><request><aaaaaa><bbbbbb>"),
                Arguments.of("<html><body><request></body></request>"),
                Arguments.of("<html><body><request></html>"),
                Arguments.of("<html><body><request></body></html>")
        );
    }

    private static Stream<Arguments> sampleDataList() {
        return Stream.of(
                Arguments.of("AAAAAAAAAAAADF3klㄹ아ㅣ멀ㄴ이ㅏㅓㄷfdk324343676hys"),
                Arguments.of("12d4fds$^ㄹ9ㅇ03(#)5ㅣㄹ90햐7ㅣ;ㅅ90레;ㅈ.;ㄷㅈ"),
                Arguments.of("애ㅣ퍂93ㅣㅏ3ㅣㅇ9ㅠ8ㅣㅌㅇ0ㅊ팽리아랴ㅏㅠ퍄ㅛㅏㅛ\n\ndk,fjhj"),
                Arguments.of("dfkdfjktdity\r\ndklfjcigjynmdka,d,fltyk\rdkfk##(%(6")
        );
    }
}