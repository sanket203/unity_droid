package unity.com.unityapp.unity.com.unityapp.base.view.model;

import com.squareup.moshi.Json;

import java.io.Serializable;


public class FamilyDetailsViewModel implements Serializable {


    private int id;

    @Json(name = "candidateId")
    private int candidateId;

    @Json(name = "father")
    private String father;

    @Json(name = "fatherDescription")
    private String fatherDescription;

    @Json(name = "mother")
    private String mother;

    @Json(name = "motherDescription")
    private String motherDescription;

    @Json(name = "sisters")
    private String sisters;

    @Json(name = "sisterDescription")
    private String sisterDescription;

    @Json(name = "brothers")
    private String brothers;

    public String getBrothers() {
        return brothers;
    }

    public void setBrothers(String brothers) {
        this.brothers = brothers;
    }

    public String getBrotherDescription() {
        return brotherDescription;
    }

    public void setBrotherDescription(String brotherDescription) {
        this.brotherDescription = brotherDescription;
    }

    @Json(name = "brotherDescription")
    private String brotherDescription;

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

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getFatherDescription() {
        return fatherDescription;
    }

    public void setFatherDescription(String fatherDescription) {
        this.fatherDescription = fatherDescription;
    }

    public String getMother() {
        return mother;
    }

    public void setMother(String mother) {
        this.mother = mother;
    }

    public String getMotherDescription() {
        return motherDescription;
    }

    public void setMotherDescription(String motherDescription) {
        this.motherDescription = motherDescription;
    }

    public String getSisters() {
        return sisters;
    }

    public void setSisters(String sisters) {
        this.sisters = sisters;
    }

    public String getSisterDescription() {
        return sisterDescription;
    }

    public void setSisterDescription(String sisterDescription) {
        this.sisterDescription = sisterDescription;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("FamilyDetailsViewModel{");
        sb.append("id=").append(id);
        sb.append(", candidateId=").append(candidateId);
        sb.append(", father='").append(father).append('\'');
        sb.append(", fatherDescription='").append(fatherDescription).append('\'');
        sb.append(", mother='").append(mother).append('\'');
        sb.append(", motherDescription='").append(motherDescription).append('\'');
        sb.append(", sisters='").append(sisters).append('\'');
        sb.append(", sisterDescription='").append(sisterDescription).append('\'');
        sb.append(", brothers='").append(brothers).append('\'');
        sb.append(", brotherDescription='").append(brotherDescription).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
