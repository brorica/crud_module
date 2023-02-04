package domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Market {
    private long id; // 상가업소번호
    private String businessName; // 상호명
    private String branchName; // 지점명
    private String CommercialMainClassificationCode; // 상권업종대분류코드
    private String CommercialMainBusinessName; // 상권업종대분류명
    private String CommercialSubMainClassificationCode; // 상권업종중분류코드
    private String CommercialSubMainBusinessName; // 상권업종중분류명
    private String CommercialSubClassificationCode; // 상권업종소분류코드
    private String CommercialSubBusinessName; // 상권업종소분류명
    private String StandardIndustryClassificationCode; // 표준산업분류코드
    private String StandardIndustryClassificationName; // 표준산업분류명
    private String sidCode; // 시도코드
    private String sidName; // 시도명
    private String sigCode; // 시군구코드
    private String sigName; // 시군구명
    private String administrativeDongCode; // 행정동코드
    private String administrativeDongName; // 행정동명
    private String courtCode; // 법정동코드
    private String courtName; // 법정동명
    private String lotCode; // 지번코드
    private String platClassificationCode; // 대지구분코드
    private String platClassificationName; // 대지구분명
    private String lotMainAddress; // 지번본번지
    private String lotSubAddress; // 지번부번지
    private String lotAddress; // 지번주소
    private String addressCode; // 도로명코드
    private String roadName; // 도로명
    private String buildingMainAddress; // 건물본번지
    private String buildingSubAddress; // 건물부번지
    private String buildingManagementNumber; // 건물관리번호
    private String buildingName; // 건물명
    private String roadAddress; // 도로명주소
    private String oldZipCode; // 구우편번호
    private String newZipCode; // 신우편번호
    private String dongInfo; // 동정보
    private String floorInfo; // 층정보
    private String roomInfo; // 호정보
    private double longitude; // 경도
    private double latitude; // 위도
}
