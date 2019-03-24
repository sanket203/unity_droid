package unity.com.unityapp.unity.com.unityapp.base.domain.model;

import com.squareup.moshi.Json;

import java.util.List;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.AddressEntity;

public class AddressDetailsResponseDataModel {

    @Json(name = "message")
    private String message;

    @Json(name = "status")
    private String status;

    @Json(name = "object")
    private List<AddressDataModel> addressDataModelsd;

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

    public List<AddressDataModel> getAddressDataModelsd() {
        return addressDataModelsd;
    }

    public void setAddressDataModelsd(List<AddressDataModel> addressDataModelsd) {
        this.addressDataModelsd = addressDataModelsd;
    }
}
