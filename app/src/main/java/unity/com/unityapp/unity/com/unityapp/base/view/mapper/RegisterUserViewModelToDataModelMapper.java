package unity.com.unityapp.unity.com.unityapp.base.view.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.domain.model.request.RegisterUserDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.RegisterUserViewModel;

public class RegisterUserViewModelToDataModelMapper {

    @Inject
    public RegisterUserViewModelToDataModelMapper() {
    }

    public RegisterUserDataModel mapToDataModel(RegisterUserViewModel viewModel) {
        RegisterUserDataModel dataModel = new RegisterUserDataModel();
        dataModel.setBirthDate(viewModel.getBirthDate());
        dataModel.setContact(viewModel.getContact());
        dataModel.setFirstName(viewModel.getFirstName());
        dataModel.setMiddleName(viewModel.getMiddleName());
        dataModel.setLastName(viewModel.getLastName());
        dataModel.setPassword(viewModel.getPassword());
        return dataModel;
    }
}
