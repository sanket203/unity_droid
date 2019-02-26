package unity.com.unityapp.unity.com.unityapp.base.data.model.response;

import com.squareup.moshi.Json;


public class AddressDetailsEntity {


    private int id;

    @Json(name = "candidateId")
    private int candidateId;

    @Json(name = "address")
    private String address;

    @Json(name = "contact")
    private long contact;

    @Json(name = "alternateNumber")
    private long alternateNumber;

    public int getId() {
        return id;
    }

    public long getContact() {
        return contact;
    }

    public void setContact(long contact) {
        this.contact = contact;
    }

    public long getAlternateNumber() {
        return alternateNumber;
    }

    public void setAlternateNumber(long alternateNumber) {
        this.alternateNumber = alternateNumber;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
