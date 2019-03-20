package unity.com.unityapp.unity.com.unityapp.base.data.model.response;

import com.squareup.moshi.Json;

import java.util.List;

public class ContactDetailsEntity {

    @Json(name = "isAddressExist")
    private boolean isAddressTaken;

    @Json(name = "allAddress")
    private List<AddressEntity> addressEntities;

    public boolean isAddressTaken() {
        return isAddressTaken;
    }

    public void isAddressTaken(boolean addressExist) {
        isAddressTaken = addressExist;
    }

    public List<AddressEntity> getAddressEntities() {
        return addressEntities;
    }

    public void setAddressEntities(List<AddressEntity> addressEntities) {
        this.addressEntities = addressEntities;
    }
}
