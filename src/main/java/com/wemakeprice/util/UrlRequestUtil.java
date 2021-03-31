package com.wemakeprice.util;

import com.wemakeprice.exception.UrlNullPointException;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.net.UnknownHostException;

@Slf4j
public class UrlRequestUtil {

    /**
     * 파싱할 URL을 통한 html 데이터 가져오기
     *
     * @param url
     * @return document html데이터 반환 및 공백제거
     */
    public static String httpRequest(String url) throws Exception {
        if ("".equals(url) || url == null) {
            throw new UrlNullPointException("Url이 null이거나 비어있습니다.");
        }

        try {
            Connection.Response response = Jsoup.connect(url)
                    .method(Connection.Method.GET)
                    .timeout(30000)
                    .execute();
            Document document = response.parse();

            return document.html();
        } catch (UnknownHostException e) {
            throw new UnknownHostException("URL을 잘못 입력했습니다.");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }


}
