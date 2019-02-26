package unity.com.unityapp.unity.com.unityapp.base.domain.model;

import com.squareup.moshi.Json;

public class DietDetailsResponseDataModel {

    @Json(name = "status")
    private String status;

    @Json(name = "message")
    private String message;

    @Json(name = "object")
    private DietDetailsDataModel dietDetailsDataModel;

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

    public DietDetailsDataModel getDietDetailsDataModel() {
        return dietDetailsDataModel;
    }

    public void setDietDetailsDataModel(DietDetailsDataModel dietDetailsDataModel) {
        this.dietDetailsDataModel = dietDetailsDataModel;
    }
}
