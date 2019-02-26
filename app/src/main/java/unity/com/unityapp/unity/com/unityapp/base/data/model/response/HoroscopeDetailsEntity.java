package unity.com.unityapp.unity.com.unityapp.base.data.model.response;

import com.squareup.moshi.Json;

public class HoroscopeDetailsEntity {

    @Json(name = "candidateId")
    private int candidateId;

    @Json(name = "caste")
    private String caste;

    @Json(name = "subCaste")
    private String subCaste;

    @Json(name = "shakha")
    private String shakha;

    @Json(name = "upshakha")
    private String upshakha;

    @Json(name = "rashi")
    private String rashi;

    @Json(name = "nakshatra")
    private String nakshatra;

    @Json(name = "naadi")
    private String naadi;

    @Json(name = "gana")
    private String gana;

    @Json(name = "charan")
    private String charan;

    @Json(name = "gotra")
    private String gotra;

    @Json(name = "mangal")
    private String mangal;

    @Json(name = "remarks")
    private String remarks;


    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public String getCaste() {
        return caste;
    }

    public void setCaste(String caste) {
        this.caste = caste;
    }

    public String getSubCaste() {
        return subCaste;
    }

    public void setSubCaste(String subCaste) {
        this.subCaste = subCaste;
    }

    public String getShakha() {
        return shakha;
    }

    public void setShakha(String shakha) {
        this.shakha = shakha;
    }

    public String getRashi() {
        return rashi;
    }

    public void setRashi(String rashi) {
        this.rashi = rashi;
    }

    public String getNakshatra() {
        return nakshatra;
    }

    public void setNakshatra(String nakshatra) {
        this.nakshatra = nakshatra;
    }

    public String getNaadi() {
        return naadi;
    }

    public void setNaadi(String naadi) {
        this.naadi = naadi;
    }

    public String getGana() {
        return gana;
    }

    public void setGana(String gana) {
        this.gana = gana;
    }

    public String getCharan() {
        return charan;
    }

    public void setCharan(String charan) {
        this.charan = charan;
    }

    public String getGotra() {
        return gotra;
    }

    public void setGotra(String gotra) {
        this.gotra = gotra;
    }

    public String getMangal() {
        return mangal;
    }

    public void setMangal(String mangal) {
        this.mangal = mangal;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getUpshakha() {
        return upshakha;
    }

    public void setUpshakha(String upshakha) {
        this.upshakha = upshakha;
    }

}

