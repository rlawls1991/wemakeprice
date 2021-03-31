package com.wemakeprice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ParsingResultDto {
    private String quotient; // 몫
    private String remainder; // 나머지
}
