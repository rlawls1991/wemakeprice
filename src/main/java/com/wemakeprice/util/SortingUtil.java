package com.wemakeprice.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortingUtil {

    /**
     * 숫자 정렬
     *
     * @param text
     * @return 정렬된 List
     */
    public static List<Character> sortingNumber(String text) {
        List<Character> returnList = text.chars()
                .mapToObj(ch -> (char) ch)
                .sorted()
                .collect(Collectors.toList());
        return returnList;
    }

    /**
     * 알파벳 정렬 <br/>
     * aaBBAAEEdd -> AAaaBBddEE
     * @param text
     * @return 정렬된 List
     */
    public static List<Character> sortingAlphabet(String text) {
        String sortingData = Arrays.stream(text.split(""))
                .sorted((first, second) -> {
                    int res = first.compareToIgnoreCase(second);
                    return (res == 0) ? first.compareTo(second) : res;
                })
                .collect(Collectors.joining());

        return sortingData.chars()
                .mapToObj(ch -> (char) ch)
                .collect(Collectors.toList());
    }
}
