package unity.com.unityapp.unity.com.unityapp.base.data.model.response;

import com.squareup.moshi.Json;

public class AddressDetailsResponseEntity {

    @Json(name = "status")
    private String status;

    @Json(name = "message")
    private String message;

    @Json(name = "object")
    AddressDetailsEntity addressDetailsEntity;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AddressDetailsEntity getAddressDetailsEntity() {
        return addressDetailsEntity;
    }

    public void setAddressDetailsEntity(AddressDetailsEntity addressDetailsEntity) {
        this.addressDetailsEntity = addressDetailsEntity;
    }
}


