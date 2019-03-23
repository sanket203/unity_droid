package unity.com.unityapp.unity.com.unityapp.base.domain.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.AddressEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.AddressDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.AddressViewModel;

public class AddressDetailsRequestDataModelToEntityMapper {
    @Inject
    public AddressDetailsRequestDataModelToEntityMapper() {
    }

    public AddressEntity mapToEntity(AddressDataModel addressDataModel) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(addressDataModel.getId());
        addressEntity.setCandidateId(addressDataModel.getCandidateId());
        addressEntity.setAddress(addressDataModel.getAddress());
        addressEntity.setContactNumber(addressDataModel.getContactNumber());
        addressEntity.setAlternateNumber(addressDataModel.getAlternateNumber());
        return addressEntity;
    }
}
