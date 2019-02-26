package unity.com.unityapp.unity.com.unityapp.base.data.model.response;

import com.squareup.moshi.Json;

public class FamilyDetailsResponseEntity {

    @Json(name = "status")
    private String status;

    @Json(name = "message")
    private String message;

    @Json(name = "object")
    FamilyDetailsEntity familyDetailsEntity;

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

    public FamilyDetailsEntity getFamilyDetailsEntity() {
        return familyDetailsEntity;
    }

    public void setFamilyDetailsEntity(FamilyDetailsEntity familyDetailsEntity) {
        this.familyDetailsEntity = familyDetailsEntity;
    }
}
