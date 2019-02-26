package unity.com.unityapp.unity.com.unityapp.base.domain.model;

import com.squareup.moshi.Json;

public class AbroadDetailsResponseDataModel {

    @Json(name = "status")
    private String status;

    @Json(name = "message")
    private String message;

    @Json(name = "object")
    private AbroadDetailsDataModel abroadDetailsDataModel;

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

    public AbroadDetailsDataModel getAbroadDetailsDataModel() {
        return abroadDetailsDataModel;
    }

    public void setAbroadDetailsDataModel(AbroadDetailsDataModel abroadDetailsDataModel) {
        this.abroadDetailsDataModel = abroadDetailsDataModel;
    }
}


