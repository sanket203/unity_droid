package unity.com.unityapp.unity.com.unityapp.base.domain.model;

import com.squareup.moshi.Json;

public class PhysicalDetailsResponseDataModel {

    @Json(name = "status")
    private String status;

    @Json(name = "message")
    private String message;

    @Json(name = "object")
    PhysicalDetailsDataModel physicalDetailsDataModel;

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

    public PhysicalDetailsDataModel getPhysicalDetailsDataModel() {
        return physicalDetailsDataModel;
    }

    public void setPhysicalDetailsDataModel(PhysicalDetailsDataModel physicalDetailsDataModel) {
        this.physicalDetailsDataModel = physicalDetailsDataModel;
    }
}
