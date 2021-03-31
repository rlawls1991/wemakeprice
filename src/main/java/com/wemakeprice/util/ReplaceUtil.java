package com.wemakeprice.util;

public class ReplaceUtil {
    /**
     *  자바 정규식
     *  index 0 = 태그 제거
     *  index 1 = 영어 숫자만
     *  index 2 = 숫자만
     *  index 3 = 영어만
     *  index 4 = 개행문자
     */
    private static String[] replaceType = {"<([^>]+)>", "[^a-zA-Z]*$", "[^0-9]", "[^a-zA-Z]", "(\r\n|\r|\n|\n\r)"};

    /**
     * 기본적인 replace (공백, 개행문자)
     * @param text
     * @return
     */
    public static String replaceBasic(String text){
        // 공백제거
        text = text.replaceAll(" ", "");
        // 개행문자 제거
        text = text.replaceAll(replaceType[4], "");
        return text;
    }

    /**
     * 태그 삭제
     * @param text
     * @return
     */
    public static String removeTag(String text){
        return text.replaceAll(replaceType[0], "");
    }

    /**
     * text중에서 숫자만 return 하기
     * @param text
     * @return
     */
    public static String returnNumber(String text){
        return text.replaceAll(replaceType[2], "");
    }

    public static String returnAlphabet(String text){
        return text.replaceAll(replaceType[3], "");
    }
}
