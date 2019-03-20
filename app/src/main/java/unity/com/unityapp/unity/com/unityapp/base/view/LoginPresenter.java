package unity.com.unityapp.unity.com.unityapp.base.view;

import android.util.Log;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.UserInfo;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.LoginUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.LoginRequestViewModelToDatamodelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.LoginRequestViewModel;

/**
 * Created by admin on 19/12/18.
 */

public class LoginPresenter extends BasePresenter<LoginView> {

    private final LoginUseCase useCase;

    private final LoginRequestViewModelToDatamodelMapper loginRequestViewModelToDatamodelMapper;

    @Inject
    public LoginPresenter(LoginUseCase useCase, LoginRequestViewModelToDatamodelMapper loginRequestViewModelToDatamodelMapper) {
        this.useCase = useCase;
        this.loginRequestViewModelToDatamodelMapper = loginRequestViewModelToDatamodelMapper;
    }

    void loginUser(String userName, String password) {
        view.showProgressBar(true);
        LoginRequestViewModel viewModel = new LoginRequestViewModel();
        viewModel.setUserName(userName);
        viewModel.setPassword(password);
        useCase.execute(loginRequestViewModelToDatamodelMapper.mapToDataModel(viewModel))
                .compose(bindToLifecycle())
                .subscribe(loginUserResponseDataModel -> {
                    if (loginUserResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                        UserInfo.getUserInfo().setCandidateId(loginUserResponseDataModel.getUserResponseDataModel().getCandidateId());
                        UserInfo.getUserInfo().setFirstName(loginUserResponseDataModel.getUserResponseDataModel().getName());
                        UserInfo.getUserInfo().setGender(loginUserResponseDataModel.getUserResponseDataModel().getGender());
                        UserInfo.getUserInfo().setAddressCount(loginUserResponseDataModel.getUserResponseDataModel().getAddressCount());
                        UserInfo.getUserInfo().setRegistered(loginUserResponseDataModel.getUserResponseDataModel().getRegistered());
                        if (view != null) {
                            view.showProgressBar(false);
                           /* if (loginUserResponseDataModel.getUserResponseDataModel().getRegistered() == null || loginUserResponseDataModel.getUserResponseDataModel().getRegistered().equalsIgnoreCase("NOT_REGISTERED")) {
                                //   view.navigateToRegistration();
                            } else {*/
                                view.loginAndNavigateToHomeScreen();
                          //  }
                        }
                    } else {
                        view.showProgressBar(false);
                        Log.d("ERROR", loginUserResponseDataModel.getMessage());
                    }

                }, error -> {
                    view.showProgressBar(false);
                    Log.d("ERROR", error.getMessage());
                });
    }
}
