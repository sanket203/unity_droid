package unity.com.unityapp.unity.com.unityapp.base.view.model;

import java.io.Serializable;

public class ServiceDetailsViewModel implements Serializable {


    private int candidateId;


    private String occupation;


    private String organization;


    private String organizationType;


    private String sector;


    private String workingCity;


    private String designation;


    private String serviceStatus;


    private String experience;


    private int annualIncome;


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

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ServiceDetailsViewModel{");
        sb.append("candidateId=").append(candidateId);
        sb.append(", occupation='").append(occupation).append('\'');
        sb.append(", organization='").append(organization).append('\'');
        sb.append(", organizationType='").append(organizationType).append('\'');
        sb.append(", sector='").append(sector).append('\'');
        sb.append(", workingCity='").append(workingCity).append('\'');
        sb.append(", designation='").append(designation).append('\'');
        sb.append(", serviceStatus='").append(serviceStatus).append('\'');
        sb.append(", experience='").append(experience).append('\'');
        sb.append(", annualIncome=").append(annualIncome);
        sb.append(", address='").append(address).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
