package unity.com.unityapp.unity.com.unityapp.base.data.model.response;

import com.squareup.moshi.Json;

import unity.com.unityapp.unity.com.unityapp.base.domain.model.AbroadDetailsDataModel;

public class AbroadDetailsResponseEntity {

    @Json(name = "status")
    private String status;

    @Json(name = "message")
    private String message;

    @Json(name = "object")
    private AbroadDetailsEntity abroadDetailsEntity;

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

    public AbroadDetailsEntity getAbroadDetailsEntity() {
        return abroadDetailsEntity;
    }

    public void setAbroadDetailsEntity(AbroadDetailsEntity abroadDetailsEntity) {
        this.abroadDetailsEntity = abroadDetailsEntity;
    }
}
