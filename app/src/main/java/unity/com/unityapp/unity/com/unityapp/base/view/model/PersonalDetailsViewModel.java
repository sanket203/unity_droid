package unity.com.unityapp.unity.com.unityapp.base.view.model;

import java.io.Serializable;

public class PersonalDetailsViewModel implements Serializable {

    private int candidateId;
    private String firstName;


    private String middleName;


    private String lastName;


    private String birthDate;


    private String birthTime;


    private String birthPlace;


    private String gender;


    private String mailId;


    private String registerBy;


    private String maritalStatus;


    private String religion;


    private String motherTongue;


    private String aboutMe;


    private String hobbies;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthTime() {
        return birthTime;
    }

    public void setBirthTime(String birthTime) {
        this.birthTime = birthTime;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public String getRegisterBy() {
        return registerBy;
    }

    public void setRegisterBy(String registerBy) {
        this.registerBy = registerBy;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getMotherTongue() {
        return motherTongue;
    }

    public void setMotherTongue(String motherTongue) {
        this.motherTongue = motherTongue;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PersonalDetailsViewModel{");
        sb.append("candidateId=").append(candidateId);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", middleName='").append(middleName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", birthDate='").append(birthDate).append('\'');
        sb.append(", birthTime='").append(birthTime).append('\'');
        sb.append(", birthPlace='").append(birthPlace).append('\'');
        sb.append(", gender='").append(gender).append('\'');
        sb.append(", mailId='").append(mailId).append('\'');
        sb.append(", registerBy='").append(registerBy).append('\'');
        sb.append(", maritalStatus='").append(maritalStatus).append('\'');
        sb.append(", religion='").append(religion).append('\'');
        sb.append(", motherTongue='").append(motherTongue).append('\'');
        sb.append(", aboutMe='").append(aboutMe).append('\'');
        sb.append(", hobbies='").append(hobbies).append('\'');
        sb.append('}');
        return sb.toString();
    }
}


