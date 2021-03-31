package com.wemakeprice.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Min;

@Getter
@Builder
@AllArgsConstructor
public class ParsingParamDto {

    @URL(message = "URL 형식으로 입력해주세요")
    private String url;

    private String printStatus; // TEXT = text 전체  /  REMOVE = HTML 태그 제외

    @Min(value = 1, message = "출력 단위 묶음은 1이상이여야 합니다.")
    private int bundle;
}
