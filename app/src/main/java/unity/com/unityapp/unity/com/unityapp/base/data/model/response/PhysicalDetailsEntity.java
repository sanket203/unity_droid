package unity.com.unityapp.unity.com.unityapp.base.data.model.response;

import com.squareup.moshi.Json;


public class PhysicalDetailsEntity {


    private int id;

    @Json(name = "candidateId")
    private int candidateId;

    @Json(name = "height")
    private String height;

    @Json(name = "weight")
    private String weight;

    @Json(name = "complexion")
    private String complexion;

    @Json(name = "bodyForm")
    private String bodyform;

    @Json(name = "spects")
    private String spects;

    @Json(name = "bloodGroup")
    private String bloodGroup;

    @Json(name = "medicalSurgary")
    private String medicalSurgary;

    @Json(name = "disability")
    private String disability;

    @Json(name = "otherRemarks")
    private String otherRemarks;

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

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getComplexion() {
        return complexion;
    }

    public void setComplexion(String complexion) {
        this.complexion = complexion;
    }

    public String getBodyform() {
        return bodyform;
    }

    public void setBodyfom(String bodyform) {
        this.bodyform = bodyform;
    }

    public String getSpects() {
        return spects;
    }

    public void setSpects(String spects) {
        this.spects = spects;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getMedicalSurgary() {
        return medicalSurgary;
    }

    public void setMedicalSurgary(String medicalSurgary) {
        this.medicalSurgary = medicalSurgary;
    }

    public String getDisability() {
        return disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    public String getOtherRemarks() {
        return otherRemarks;
    }

    public void setOtherRemarks(String otherRemarks) {
        this.otherRemarks = otherRemarks;
    }

}
