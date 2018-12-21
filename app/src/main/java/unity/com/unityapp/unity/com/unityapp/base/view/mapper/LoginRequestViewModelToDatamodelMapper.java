package unity.com.unityapp.unity.com.unityapp.base.view.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.domain.model.LoginUserRequestDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.LoginRequestViewModel;

/**
 * Created by admin on 20/12/18.
 */

public class LoginRequestViewModelToDatamodelMapper {

    @Inject
    public LoginRequestViewModelToDatamodelMapper() {
    }

    public LoginUserRequestDataModel mapToDataModel(LoginRequestViewModel viewModel) {
        LoginUserRequestDataModel dataModel = new LoginUserRequestDataModel();
        dataModel.setUserName(viewModel.getUserName());
        dataModel.setPassword(viewModel.getPassword());
        dataModel.setPayment(viewModel.getPayment());
        dataModel.setTransactionId(viewModel.getTransactionId());
        return dataModel;
    }
}
