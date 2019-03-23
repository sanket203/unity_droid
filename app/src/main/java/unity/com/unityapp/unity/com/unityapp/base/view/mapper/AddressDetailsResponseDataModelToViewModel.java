package unity.com.unityapp.unity.com.unityapp.base.view.mapper;

import java.util.List;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.domain.model.AddressDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.ContactDetailsResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.AddressViewModel;

public class AddressDetailsResponseDataModelToViewModel {
    @Inject
    public AddressDetailsResponseDataModelToViewModel() {
    }

    public AddressViewModel mapToViewModel(ContactDetailsResponseDataModel contactDetailsResponseDataModel) {

        AddressViewModel addressViewModel = new AddressViewModel();


        addressViewModel = getAddressDataModels(contactDetailsResponseDataModel.getContactDetailsDataModel().getAddressDataModels());

        return addressViewModel;
    }

    private AddressViewModel getAddressDataModels(List<AddressDataModel> addressDataModels) {

        AddressViewModel addressViewModel = new AddressViewModel();
        for (AddressDataModel addressDataModel : addressDataModels
        ) {

            addressViewModel.setAddress(addressDataModel.getAddress());
            addressViewModel.setAlternateNumber(addressDataModel.getAlternateNumber());
            addressViewModel.setCandidateId(addressDataModel.getCandidateId());
            addressViewModel.setContactNumber(addressDataModel.getContactNumber());
            addressDataModels.add(addressDataModel);
        }

        return addressViewModel;
    }
}
