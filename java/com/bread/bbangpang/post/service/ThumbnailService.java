package com.bread.bbangpang.post.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Service
public class ThumbnailService {

    public String extractFirstImageUrl(String htmlContent) {
        // HTML 문자열을 파싱합니다.
        Document document = Jsoup.parse(htmlContent);

        // 첫 번째 img 태그를 선택합니다.
        Element imgElement = document.selectFirst("img");

        if (imgElement != null) {
            return imgElement.attr("src"); // img 태그의 src 속성을 반환합니다.
        } else {
            return "https://bbangpang.s3.ap-northeast-2.amazonaws.com/thumbnail.png"; // 이미지가 없을 경우 기본 이미지를 반환합니다.
        }
    }

}
