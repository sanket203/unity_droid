package unity.com.unityapp.unity.com.unityapp.base.domain.model;

import com.squareup.moshi.Json;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.FamilyDetailsEntity;

public class FamilyDetailsResponseDataModel {

    @Json(name = "status")
    private String status;

    @Json(name = "message")
    private String message;

    @Json(name = "object")
    private FamilyDetailsDataModel familyDetailsDataModel;

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

    public FamilyDetailsDataModel getFamilyDetailsDataModel() {
        return familyDetailsDataModel;
    }

    public void setFamilyDetailsDataModel(FamilyDetailsDataModel familyDetailsDataModel) {
        this.familyDetailsDataModel = familyDetailsDataModel;
    }
}


