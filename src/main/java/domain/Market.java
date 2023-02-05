package domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Market {
    private long id; // 상가업소번호
    private String businessName; // 상호명
    private String branchName; // 지점명
    private String commercialMainClassificationCode; // 상권업종대분류코드
    private String commercialMainBusinessName; // 상권업종대분류명
    private String commercialSubMainClassificationCode; // 상권업종중분류코드
    private String commercialSubMainBusinessName; // 상권업종중분류명
    private String commercialSubClassificationCode; // 상권업종소분류코드
    private String commercialSubBusinessName; // 상권업종소분류명
    private String standardIndustryClassificationCode; // 표준산업분류코드
    private String standardIndustryClassificationName; // 표준산업분류명
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
    private String roadNameCode; // 도로명코드
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

    @Builder
    public Market(long id, String businessName, String branchName,
        String commercialMainClassificationCode, String commercialMainBusinessName,
        String commercialSubMainClassificationCode, String commercialSubMainBusinessName,
        String commercialSubClassificationCode, String commercialSubBusinessName,
        String standardIndustryClassificationCode, String standardIndustryClassificationName,
        String sidCode, String sidName, String sigCode, String sigName,
        String administrativeDongCode, String administrativeDongName, String courtCode,
        String courtName, String lotCode, String platClassificationCode,
        String platClassificationName, String lotMainAddress, String lotSubAddress,
        String lotAddress, String roadNameCode, String roadName, String buildingMainAddress,
        String buildingSubAddress, String buildingManagementNumber, String buildingName,
        String roadAddress, String oldZipCode, String newZipCode, String dongInfo,
        String floorInfo, String roomInfo, double longitude, double latitude) {
        this.id = id;
        this.businessName = businessName;
        this.branchName = branchName;
        this.commercialMainClassificationCode = commercialMainClassificationCode;
        this.commercialMainBusinessName = commercialMainBusinessName;
        this.commercialSubMainClassificationCode = commercialSubMainClassificationCode;
        this.commercialSubMainBusinessName = commercialSubMainBusinessName;
        this.commercialSubClassificationCode = commercialSubClassificationCode;
        this.commercialSubBusinessName = commercialSubBusinessName;
        this.standardIndustryClassificationCode = standardIndustryClassificationCode;
        this.standardIndustryClassificationName = standardIndustryClassificationName;
        this.sidCode = sidCode;
        this.sidName = sidName;
        this.sigCode = sigCode;
        this.sigName = sigName;
        this.administrativeDongCode = administrativeDongCode;
        this.administrativeDongName = administrativeDongName;
        this.courtCode = courtCode;
        this.courtName = courtName;
        this.lotCode = lotCode;
        this.platClassificationCode = platClassificationCode;
        this.platClassificationName = platClassificationName;
        this.lotMainAddress = lotMainAddress;
        this.lotSubAddress = lotSubAddress;
        this.lotAddress = lotAddress;
        this.roadNameCode = roadNameCode;
        this.roadName = roadName;
        this.buildingMainAddress = buildingMainAddress;
        this.buildingSubAddress = buildingSubAddress;
        this.buildingManagementNumber = buildingManagementNumber;
        this.buildingName = buildingName;
        this.roadAddress = roadAddress;
        this.oldZipCode = oldZipCode;
        this.newZipCode = newZipCode;
        this.dongInfo = dongInfo;
        this.floorInfo = floorInfo;
        this.roomInfo = roomInfo;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
