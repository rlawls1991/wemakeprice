package com.wemakeprice.dto;


import com.wemakeprice.dto.printstatus.PrintStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class ParsingParamDto {
    @URL(message = "URL 형식으로 입력해주세요")
    private String url;

    @NotNull(message = "printStatus 중에 하나를 선택하셔야 합니다.")
    private PrintStatus printStatus;

    @Min(value = 1, message = "출력 단위 묶음은 1이상이여야 합니다.")
    private int bundle;
}
