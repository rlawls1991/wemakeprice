package com.wemakeprice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.Errors;

@Getter
@AllArgsConstructor
public class ErrorResponseMessage {
    private Errors errors;
}
