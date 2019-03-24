package unity.com.unityapp.unity.com.unityapp.base.view;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.UserInfo;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.RegistrationDoneUseCase;

public class RegistrationDonePresenter extends BasePresenter<RegistrationDoneView> {

    private final RegistrationDoneUseCase registrationDoneUseCase;

    @Inject
    public RegistrationDonePresenter(RegistrationDoneUseCase registrationDoneUseCase) {
        this.registrationDoneUseCase = registrationDoneUseCase;
    }

    void registerDone(String candidateId, String registered) {
        registrationDoneUseCase.execute(candidateId, registered)
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
                            view.navigateToHomeActivity();
                        }

                    } else {
                        view.showProgressBar(false);
                        view.showErrorMessage(loginUserResponseDataModel.getMessage());
                    }

                }, error -> {
                    view.showProgressBar(false);
                    view.showErrorMessage(error.getMessage());
                });
    }
}
