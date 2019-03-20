package unity.com.unityapp.unity.com.unityapp.base.domain.model;

import com.squareup.moshi.Json;

import java.util.List;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.AddressEntity;

public class ContactDetailsDataModel {

    @Json(name = "isAddressExist")
    private boolean isAddressExist;

    @Json(name = "allAddress")
    private List<AddressDataModel> addressDataModels;

    public boolean isAddressExist() {
        return isAddressExist;
    }

    public void setAddressExist(boolean addressExist) {
        isAddressExist = addressExist;
    }

    public List<AddressDataModel> getAddressDataModels() {
        return addressDataModels;
    }

    public void setAddressDataModels(List<AddressDataModel> addressDataModels) {
        this.addressDataModels = addressDataModels;
    }
}
