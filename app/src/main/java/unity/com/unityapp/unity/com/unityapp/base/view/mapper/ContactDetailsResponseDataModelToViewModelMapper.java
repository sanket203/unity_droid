package unity.com.unityapp.unity.com.unityapp.base.view.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.AddressDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.AddressEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.AddressDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.AddressDetailsResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.ContactDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.AddressViewModel;

public class ContactDetailsResponseDataModelToViewModelMapper {
    @Inject
    public ContactDetailsResponseDataModelToViewModelMapper() {
    }

    public AddressViewModel mapToViewModel(AddressDetailsResponseDataModel addressDetailsResponseDataModel) {

        AddressViewModel addressViewModel = new AddressViewModel();


        if (addressDetailsResponseDataModel != null) {
            addressViewModel = (getAddressDataModels(addressDetailsResponseDataModel.getAddressDataModelsd()));
        }
        return addressViewModel;
    }

    private AddressViewModel getAddressDataModels(List<AddressDataModel> addressDataModels) {
        AddressViewModel addressViewModel = new AddressViewModel();
        if (addressDataModels != null) {
            for (AddressDataModel addressDataModel : addressDataModels
            ) {

                addressViewModel.setId(addressDataModel.getId());
                addressViewModel.setAddress(addressDataModel.getAddress());
                addressViewModel.setAlternateNumber(addressDataModel.getAlternateNumber());
                addressViewModel.setCandidateId(addressDataModel.getCandidateId());
                addressViewModel.setContactNumber(addressDataModel.getContactNumber());

            }
        }
        return addressViewModel;
    }
}
