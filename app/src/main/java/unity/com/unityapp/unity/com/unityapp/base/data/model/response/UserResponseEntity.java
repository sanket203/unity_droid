package unity.com.unityapp.unity.com.unityapp.base.data.model.response;

import com.squareup.moshi.Json;

/**
 * Created by admin on 20/12/18.
 */

public class UserResponseEntity {

    @Json(name = "candidateId")
    private int candidateId;

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
    private int income;

    @Json(name = "lastLogin")
    private String lastLogin;

    @Json(name = "addressCount")
    private int addressCount;

    @Json(name = "subscriptionDate")
    private String subscriptionDate;

    @Json(name = "payment")
    private String payment;

    @Json(name = "status")
    private String status;

    @Json(name = "transactionId")
    private String transactionId;

    @Json(name = "registered")
    private String registered;

    @Json(name = "imageUrl")
    private String imageUrl;

    public String isRegistered() {
        return registered;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(String subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }

    public int getAddressCount() {
        return addressCount;
    }

    public void setAddressCount(int addressCount) {
        this.addressCount = addressCount;
    }


    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
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

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getRegistered() {
        return registered;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
