package unity.com.unityapp.unity.com.unityapp.base.domain.model;

import com.squareup.moshi.Json;


public class AbroadDetailsDataModel {

    @Json(name = "id")
    private int id;

    @Json(name = "candidateId")
    private int candidateId;

    @Json(name = "country")
    private String country;

    @Json(name = "visaType")
    private String visaType;

    @Json(name = "visaYear")
    private String visaYear;

    @Json(name = "citizenship")
    private String citizenship;

    @Json(name = "staytype")
    private String stayType;

    @Json(name = "remarks")
    private String remarks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getVisaType() {
        return visaType;
    }

    public void setVisaType(String visaType) {
        this.visaType = visaType;
    }

    public String getVisaYear() {
        return visaYear;
    }

    public void setVisaYear(String visaYear) {
        this.visaYear = visaYear;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getStayType() {
        return stayType;
    }

    public void setStayType(String stayType) {
        this.stayType = stayType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }


}
