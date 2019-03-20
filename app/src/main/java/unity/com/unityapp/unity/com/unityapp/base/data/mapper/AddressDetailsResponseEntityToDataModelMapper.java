package unity.com.unityapp.unity.com.unityapp.base.data.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.AddressEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.ContactDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.AddressDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.ContactDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.ContactDetailsResponseDataModel;

public class AddressDetailsResponseEntityToDataModelMapper {
    @Inject
    public AddressDetailsResponseEntityToDataModelMapper() {
    }

    public ContactDetailsResponseDataModel mapToDataModel(ContactDetailsResponseEntity addressDetailsResponseEntity) {

        ContactDetailsResponseDataModel addressDetailsResponseDataModel = new ContactDetailsResponseDataModel();

        addressDetailsResponseDataModel.setMessage(addressDetailsResponseEntity.getMessage());
        addressDetailsResponseDataModel.setStatus(addressDetailsResponseEntity.getStatus());
        ContactDetailsDataModel contactDetailsDataModel = new ContactDetailsDataModel();
        if (addressDetailsResponseEntity.getContactDetailsEntitie() != null) {
            contactDetailsDataModel.setAddressDataModels(getAddressDataModels(addressDetailsResponseEntity.getContactDetailsEntitie().getAddressEntities()));
        }
        contactDetailsDataModel.setAddressExist(addressDetailsResponseEntity.getContactDetailsEntitie().isAddressTaken());
        addressDetailsResponseDataModel.setContactDetailsDataModel(contactDetailsDataModel);
        return addressDetailsResponseDataModel;
    }

    private List<AddressDataModel> getAddressDataModels(List<AddressEntity> addressEntities) {
        List<AddressDataModel> addressDataModels = new ArrayList<>();
        if (addressEntities != null) {
            for (AddressEntity addressEntity : addressEntities
            ) {
                AddressDataModel addressDataModel = new AddressDataModel();
                addressDataModel.setAddress(addressEntity.getAddress());
                addressDataModel.setAlternateNumber(addressEntity.getAlternateNumber());
                addressDataModel.setCandidateId(addressEntity.getCandidateId());
                addressDataModel.setContactNumber(addressEntity.getContactNumber());
                addressDataModels.add(addressDataModel);
            }
        }
        return addressDataModels;
    }
}
