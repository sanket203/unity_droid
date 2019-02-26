package unity.com.unityapp.unity.com.unityapp.base.data.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.AddressDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.AddressDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.AddressDetailsResponseDataModel;

public class AddressDetailsResponseEntityToDataModelMapper {
    @Inject
    public AddressDetailsResponseEntityToDataModelMapper() {
    }

    AddressDetailsResponseDataModel mapToDataModel(AddressDetailsResponseEntity addressDetailsResponseEntity) {

        AddressDetailsResponseDataModel addressDetailsResponseDataModel = new AddressDetailsResponseDataModel();

        addressDetailsResponseDataModel.setMessage(addressDetailsResponseEntity.getMessage());
        addressDetailsResponseDataModel.setStatus(addressDetailsResponseEntity.getStatus());
        AddressDetailsDataModel addressDetailsDataModel = new AddressDetailsDataModel();
        addressDetailsDataModel.setAddress(addressDetailsResponseEntity.getAddressDetailsEntity().getAddress());
        addressDetailsDataModel.setAlternateNumber(addressDetailsResponseEntity.getAddressDetailsEntity().getAlternateNumber());
        addressDetailsDataModel.setCandidateId(addressDetailsResponseEntity.getAddressDetailsEntity().getCandidateId());
        addressDetailsDataModel.setContact(addressDetailsResponseEntity.getAddressDetailsEntity().getContact());
        addressDetailsResponseDataModel.setAddressDetailsDataModel(addressDetailsDataModel);

        return addressDetailsResponseDataModel;
    }
}
