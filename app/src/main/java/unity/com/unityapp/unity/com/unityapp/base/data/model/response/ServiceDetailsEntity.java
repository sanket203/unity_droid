package unity.com.unityapp.unity.com.unityapp.base.data.model.response;

import com.squareup.moshi.Json;

public class ServiceDetailsEntity {


    @Json(name = "id")
    int id;

    @Json(name = "candidateId")
    private int candidateId;

    @Json(name = "occupation")
    private String occupation;

    @Json(name = "organization")
    private String organization;

    @Json(name = "organizationType")
    private String organizationType;

    @Json(name = "sector")
    private String sector;

    @Json(name = "workingCity")
    private String workingCity;

    @Json(name = "designation")
    private String designation;

    @Json(name = "serviceStatus")
    private String serviceStatus;

    @Json(name = "experience")
    private String experience;

    @Json(name = "annualIncome")
    private int annualIncome;

    @Json(name = "address")
    private String address;

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getOrganizationType() {
        return organizationType;
    }

    public void setOrganizationType(String organizationType) {
        this.organizationType = organizationType;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getWorkingCity() {
        return workingCity;
    }

    public void setWorkingCity(String workingCity) {
        this.workingCity = workingCity;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public int getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(int annualIncome) {
        this.annualIncome = annualIncome;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}


