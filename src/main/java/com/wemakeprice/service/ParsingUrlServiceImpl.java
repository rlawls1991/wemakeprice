package com.wemakeprice.service;


import com.wemakeprice.dto.ParsingParamDto;
import com.wemakeprice.dto.ParsingResultDto;
import com.wemakeprice.util.*;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ParsingUrlServiceImpl implements ParsingUrlService {

    @SneakyThrows
    @Override
    public ParsingResultDto getParsingResult(ParsingParamDto parsingParamDto) {
        // printStatus 에 따른 태그 삭제 유무 결과
        String htmlString = getHtmlString(parsingParamDto.getPrintStatus(), parsingParamDto.getUrl());
        // 오름차순 정렬이 된 알파벳 리스트
        List<Character> sortingAlphabetList = SortingUtil.sortingAlphabet(ReplaceUtil.returnAlphabet(htmlString));
        // 오름차순 정렬이 된 숫자 리스트
        List<Character> sortingNumberList = SortingUtil.sortingNumber(ReplaceUtil.returnNumber(htmlString));
        // 알파벳 리스트와 숫자 리스트가 섞인 문자열
        String mixString = MixStringUtil.mixString(sortingAlphabetList, sortingNumberList);
        // 출력단위 묶음
        int bundle = parsingParamDto.getBundle();
        // 몫
        String quotient = CalculateUtil.calculateQuotient(mixString, bundle);
        // 나머지
        String remainder = CalculateUtil.calculateRemainder(mixString, bundle);

        return new ParsingResultDto(quotient, remainder);
    }


    @SneakyThrows
    private String getHtmlString(String printStatus, String url) {
        String urlRequestHtml = urlRequestHtml = UrlRequestUtil.httpRequest(url);
        urlRequestHtml = ReplaceUtil.replaceBasic(urlRequestHtml);

        // 태그삭제
        if ("REMOVE".equals(printStatus)) {
            return ReplaceUtil.removeTag(urlRequestHtml);
        }

        return urlRequestHtml;
    }
}
