package com.wemakeprice.util;

import java.util.List;

public class MixStringUtil {

    /**
     * 두 개의 정렬된 리스트들을 섞는다(숫자, 알파벳) <br />
     * AaaBbb  0123  -> A0a1a2B3bb
     *
     * @param sortingAlphabetList
     * @param sortingNumberList
     * @return
     */
    public static String mixString(List<Character> sortingAlphabetList, List<Character> sortingNumberList) {
        StringBuffer resultSb = new StringBuffer();
        int sortingAlphabetSize = sortingAlphabetList.size();
        int sortingNumberSize = sortingNumberList.size();

        // 알파벳리스트가 더 길거나 같은 경우
        if (sortingAlphabetSize >= sortingNumberSize) {
            for (int i = 0; i < sortingNumberSize; i++) {
                resultSb.append(sortingAlphabetList.get(i));
                resultSb.append(sortingNumberList.get(i));
            }
            // 길이가 같은경우 return 한다.
            if (sortingAlphabetSize == sortingNumberSize) {
                return resultSb.toString();
            }
            // 알파벳남은 길이만큼 더한다.
            for (int i = sortingNumberSize; i < sortingAlphabetSize; i++) {
                resultSb.append(sortingAlphabetList.get(i));
            }

            return resultSb.toString();
        }

        // 알파벳 리스트가 더 짧은 경우
        if (sortingAlphabetSize < sortingNumberSize) {
            for (int i = 0; i < sortingAlphabetSize; i++) {
                resultSb.append(sortingAlphabetList.get(i));
                resultSb.append(sortingNumberList.get(i));
            }
            // 숫자 남은 길이만큼 더한다.
            for (int i = sortingAlphabetSize; i < sortingNumberSize; i++) {
                resultSb.append(sortingNumberList.get(i));
            }
        }

        return resultSb.toString();
    }
}
