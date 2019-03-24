package unity.com.unityapp.unity.com.unityapp.base.view.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.domain.model.AddressDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.AddressViewModel;

public class AddressViewModelToDataModelMapper {

    @Inject
    public AddressViewModelToDataModelMapper() {
    }

    public AddressDataModel mapToDataModel(AddressViewModel addressViewModel) {
        AddressDataModel addressDataModel = new AddressDataModel();
        addressDataModel.setId(addressViewModel.getId());
        addressDataModel.setCandidateId(addressViewModel.getCandidateId());
        addressDataModel.setAddress(addressViewModel.getAddress());
        addressDataModel.setContactNumber(addressViewModel.getContactNumber());
        addressDataModel.setAlternateNumber(addressViewModel.getAlternateNumber());
        return addressDataModel;
    }
}
