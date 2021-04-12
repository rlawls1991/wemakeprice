package com.wemakeprice.global.error;


import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.List;

@Getter
@NoArgsConstructor
public class ErrorsResource {

    private String message;
    private int status;
    private String code;
    private List<FieldError> fieldError;

    public ErrorsResource(ErrorCode code, Errors errors) {
        this.fieldError = errors.getFieldErrors();
        this.message = code.getMessage();
        this.status = code.getStatus();
        this.code = code.getCode();
    }

    public ErrorsResource(ErrorCode code){
        this.message = code.getMessage();
        this.status = code.getStatus();
        this.code = code.getCode();
    }

}