package unity.com.unityapp.unity.com.unityapp.base.view.model;

import java.io.Serializable;

public class EducationalDetailsViewModel implements Serializable {


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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("EducationalDetailsViewModel{");
        sb.append("candidateId=").append(candidateId);
        sb.append(", degree='").append(degree).append('\'');
        sb.append(", passYear='").append(passYear).append('\'');
        sb.append(", college='").append(college).append('\'');
        sb.append(", university='").append(university).append('\'');
        sb.append(", stream='").append(stream).append('\'');
        sb.append(", remarks='").append(remarks).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
