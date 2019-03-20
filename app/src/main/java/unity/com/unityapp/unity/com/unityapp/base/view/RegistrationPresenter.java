package unity.com.unityapp.unity.com.unityapp.base.view;

import android.util.Log;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.UserInfo;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.RegisterUserUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.RegisterUserViewModelToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.RegisterUserViewModel;

public class RegistrationPresenter extends BasePresenter<RegistrationView> {

    private final RegisterUserUseCase useCase;
    private final RegisterUserViewModelToDataModelMapper registerUserViewModelToDataModelMapper;

    @Inject
    public RegistrationPresenter(RegisterUserUseCase useCase, RegisterUserViewModelToDataModelMapper registerUserViewModelToDataModelMapper) {
        this.useCase = useCase;
        this.registerUserViewModelToDataModelMapper = registerUserViewModelToDataModelMapper;
    }

    public void register(RegisterUserViewModel registerUserViewModel) {
        useCase.execute(registerUserViewModelToDataModelMapper.mapToDataModel(registerUserViewModel))
                .compose(bindToLifecycle())
                .subscribe(loginUserResponseDataModel -> {
                    if (loginUserResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                        UserInfo.getUserInfo().setCandidateId(loginUserResponseDataModel.getUserResponseDataModel().getCandidateId());
                        UserInfo.getUserInfo().setFirstName(loginUserResponseDataModel.getUserResponseDataModel().getName());
                        UserInfo.getUserInfo().setGender(loginUserResponseDataModel.getUserResponseDataModel().getGender());
                        UserInfo.getUserInfo().setAddressCount(loginUserResponseDataModel.getUserResponseDataModel().getAddressCount());

                        if (view != null) {
                            view.showProgressBar(false);
                            view.navigateToWelcomeScreen();
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

