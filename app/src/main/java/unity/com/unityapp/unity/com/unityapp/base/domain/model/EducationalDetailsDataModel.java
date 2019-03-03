package unity.com.unityapp.unity.com.unityapp.base.domain.model;

import com.squareup.moshi.Json;

public class EducationalDetailsDataModel {


    private int candidateId;


    private String degree;


    private String passYear;


    private String college;


    private String university;


    private String stream;


    private String remarks;

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getPassYear() {
        return passYear;
    }

    public void setPassYear(String passYear) {
        this.passYear = passYear;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

}
