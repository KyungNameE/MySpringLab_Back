// OrgSggCodeVO.java
package com.example.myspringlab.cmm.vo;

public class OrgSggCodeVO {
    private String sdCd;    // 시도코드
    private String sdNm;    // 시도명
    private String sggCd;   // 시군구코드
    private String sggNm;   // 시군구명
    private String useYn;   // 사용여부
    private String sdSnm;   // 시도명약어

    // Getter, Setter
    public String getSdCd() {
        return sdCd;
    }
    public void setSdCd(String sdCd) {
        this.sdCd = sdCd;
    }
    public String getSdNm() {
        return sdNm;
    }
    public void setSdNm(String sdNm) {
        this.sdNm = sdNm;
    }
    public String getSggCd() {
        return sggCd;
    }
    public void setSggCd(String sggCd) {
        this.sggCd = sggCd;
    }
    public String getSggNm() {
        return sggNm;
    }
    public void setSggNm(String sggNm) {
        this.sggNm = sggNm;
    }
    public String getUseYn() {
        return useYn;
    }
    public void setUseYn(String useYn) {
        this.useYn = useYn;
    }
    public String getSdSnm() {
        return sdSnm;
    }
    public void setSdSnm(String sdSnm) {
        this.sdSnm = sdSnm;
    }
}
