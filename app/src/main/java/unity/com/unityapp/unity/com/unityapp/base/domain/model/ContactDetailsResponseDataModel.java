package unity.com.unityapp.unity.com.unityapp.base.domain.model;

import com.squareup.moshi.Json;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.ContactDetailsEntity;

public class ContactDetailsResponseDataModel {

    @Json(name = "message")
    private String message;

    @Json(name = "status")
    private String status;

    @Json(name = "object")
    private ContactDetailsDataModel contactDetailsDataModel;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ContactDetailsDataModel getContactDetailsDataModel() {
        return contactDetailsDataModel;
    }

    public void setContactDetailsDataModel(ContactDetailsDataModel contactDetailsDataModel) {
        this.contactDetailsDataModel = contactDetailsDataModel;
    }
}
