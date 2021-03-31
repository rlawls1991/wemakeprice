package com.wemakeprice.util;

public class CalculateUtil {

    /**
     * 몫 구하기 <br/>
     * 묶음 단위 내 값
     *
     * @return 몫
     */
    public static String calculateQuotient(String text, int bundle) {
        int textLength = text.length();
        int remainderLength = textLength % bundle;
        int quotientLength = textLength - remainderLength;

        return text.substring(0, quotientLength);
    }


    /**
     * 나머지 구하기 <br/>
     * 묶음 단위 외 값
     *
     * @return 나머지
     */
    public static String calculateRemainder(String text, int bundle) {
        int textLength = text.length();
        int remainderLength = textLength % bundle;
        int quotientLength = textLength - remainderLength;

        return text.substring(quotientLength);
    }
}
