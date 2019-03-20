package unity.com.unityapp.unity.com.unityapp.base.data.model.response;

import com.squareup.moshi.Json;

import java.util.List;

public class ContactDetailsResponseEntity {

    @Json(name = "message")
    private String message;

    @Json(name = "status")
    private String status;

    @Json(name = "object")
    private ContactDetailsEntity contactDetailsEntitie;

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

    public ContactDetailsEntity getContactDetailsEntitie() {
        return contactDetailsEntitie;
    }

    public void setContactDetailsEntitie(ContactDetailsEntity contactDetailsEntities) {
        this.contactDetailsEntitie = contactDetailsEntitie;
    }
}
