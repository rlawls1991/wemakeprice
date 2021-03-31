# Wemake 과제

## 기능 요구사항
* 모든 문자 입력 가능
  * 서버에서 URL 형태만 입력 가능하게 설정
* 영어 및 숫자만 출력
  * ReplaceUtil 에서 영어 및 숫자만 return을 받을 수 있게 개발
    * returnNumber  - 숫자만
    * returnAlphabet  - 알파벳
* 오름차순 출력
    * 숫자
        * SortingUtil.sortingNumber 개발 완료
    * 영어
        * SortingUtil.sortingAlphabet 개발 완료
* 영어 숫자 Mix
    * MixStringUtil.mixString 개발 완료
* 출력 묶음 단위을 이용한 몫, 나머지 구하기
    * 몫
        * CalculateUtil.calculateQuotient
    * 나머지
        * CalculateUtil.calculateRemainder

## RestApi 설명
    src > docs > asciidoc > index.adoc 을 보게 된다면 RestApi http-request, http-response의 결과 확인가능

## 개발 환경설정 및 라이브러리
* OpenJdk 11
* spring-boot 2.4.4
* LomBok
* Gradle
* thymeleaf
* restdocs
* jsoup 
* hateoas
* validation