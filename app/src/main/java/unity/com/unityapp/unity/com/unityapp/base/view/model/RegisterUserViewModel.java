package unity.com.unityapp.unity.com.unityapp.base.view.model;

import com.squareup.moshi.Json;

public class RegisterUserViewModel {

    @Json(name = "firstName")
    private String firstName;

    @Json(name = "middleName")
    private String middleName;

    @Json(name = "lastName")
    private String lastName;

    @Json(name = "birthDate")
    private String birthDate;

    @Json(name = "gender")
    private String gender;

    @Json(name = "contact")
    private long contact;

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }
}
