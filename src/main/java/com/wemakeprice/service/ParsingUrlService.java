package com.wemakeprice.service;

import com.wemakeprice.dto.ParsingParamDto;
import com.wemakeprice.dto.ParsingResultDto;

public interface ParsingUrlService {

    /**
     * URL 및 출력묶음 단위를 전달하여 <br/>
     * HTML 문자열을 몫과 나머지로 반환
     * @return
     */
    ParsingResultDto getParsingResult(ParsingParamDto parsingParamDto);
}
