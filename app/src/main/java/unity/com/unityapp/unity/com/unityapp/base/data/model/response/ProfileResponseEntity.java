package unity.com.unityapp.unity.com.unityapp.base.data.model.response;

import com.squareup.moshi.Json;

/**
 * Created by admin on 11/12/18.
 */

public class ProfileResponseEntity {

    @Json(name = "id")
    private int id;

    @Json(name = "candidateId")
    private int candidateID;

    @Json(name = "name")
    private String name;

    @Json(name = "gender")
    private String gender;

    @Json(name = "birthDate")
    private String birthDate;

    @Json(name = "height")
    private String height;

    @Json(name = "education")
    private String education;

    @Json(name = "income")
    private String income;

    @Json(name = "lastLogin")
    private String lastLogin;

    @Json(name = "addressCount")
    private int addressCount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(int candidateID) {
        this.candidateID = candidateID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public int getAddressCount() {
        return addressCount;
    }

    public void setAddressCount(int addressCount) {
        this.addressCount = addressCount;
    }
}
