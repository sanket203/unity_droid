package unity.com.unityapp.unity.com.unityapp.base.view.model;

import com.squareup.moshi.Json;

public class AddressViewModel {

    private int id;



    @Json(name = "candidateId")
    private int candidateId;

    @Json(name = "contact")
    private long contactNumber;

    @Json(name = "alternateNumber")
    private long alternateNumber;

    @Json(name = "address")
    private String address;

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public long getAlternateNumber() {
        return alternateNumber;
    }

    public void setAlternateNumber(long alternateNumber) {
        this.alternateNumber = alternateNumber;
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
