package com.wemakeprice.controller.api;

import com.wemakeprice.dto.ParsingParamDto;
import com.wemakeprice.service.ParsingUrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/parse", consumes = MediaType.APPLICATION_JSON_VALUE)
public class ParsingUrlApiController {

    private final ParsingUrlService parsingUrlService;

    @PostMapping
    public ResponseEntity parsingUrl(@RequestBody @Valid ParsingParamDto parsingParamDto) {
        return new ResponseEntity<>(parsingUrlService.getParsingResult(parsingParamDto), HttpStatus.OK);
    }
}
