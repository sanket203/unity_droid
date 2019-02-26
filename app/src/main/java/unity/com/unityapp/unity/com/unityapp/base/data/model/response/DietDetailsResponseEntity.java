package unity.com.unityapp.unity.com.unityapp.base.data.model.response;

import com.squareup.moshi.Json;

public class DietDetailsResponseEntity {

    @Json(name = "status")
    private String status;

    @Json(name = "message")
    private String message;

    @Json(name = "object")
    private DietDetailsEntity dietDetailsEntity;

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

    public DietDetailsEntity getDietDetailsEntity() {
        return dietDetailsEntity;
    }

    public void setDietDetailsEntity(DietDetailsEntity dietDetailsEntity) {
        this.dietDetailsEntity = dietDetailsEntity;
    }
}
