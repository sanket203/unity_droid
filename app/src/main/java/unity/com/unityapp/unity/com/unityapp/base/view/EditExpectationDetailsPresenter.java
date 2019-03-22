package unity.com.unityapp.unity.com.unityapp.base.view;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.UserInfo;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.GetExpectationDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.SaveExpectationDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.ExpectationDetailsDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.ExpectationDetailsViewModelToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.ExpectationsViewModel;

public class EditExpectationDetailsPresenter extends BasePresenter<EditExpectationDetailsView> {

    private final SaveExpectationDetailsUseCase saveExpectationDetailsUseCase;

    private final ExpectationDetailsDataModelToViewModelMapper expectationDetailsDataModelToViewModelMapper;

    private final ExpectationDetailsViewModelToDataModelMapper expectationDetailsViewModelToDataModelMapper;
    private final GetExpectationDetailsUseCase getExpectationDetailsUseCase;


    @Inject
    public EditExpectationDetailsPresenter(SaveExpectationDetailsUseCase saveExpectationDetailsUseCase, ExpectationDetailsDataModelToViewModelMapper expectationDetailsDataModelToViewModelMapper, ExpectationDetailsViewModelToDataModelMapper expectationDetailsViewModelToDataModelMapper, GetExpectationDetailsUseCase getExpectationDetailsUseCase) {
        this.saveExpectationDetailsUseCase = saveExpectationDetailsUseCase;
        this.expectationDetailsDataModelToViewModelMapper = expectationDetailsDataModelToViewModelMapper;
        this.expectationDetailsViewModelToDataModelMapper = expectationDetailsViewModelToDataModelMapper;
        this.getExpectationDetailsUseCase = getExpectationDetailsUseCase;
    }

    public void save(ExpectationsViewModel expectationDetailsViewModel, boolean isFromRegistration) {
        if (view != null) {
            view.showProgress(true);
        }
        saveExpectationDetailsUseCase.execute(expectationDetailsViewModelToDataModelMapper.mapToDataModel(expectationDetailsViewModel))
                .compose(bindToLifecycle()).subscribe(expectationDetailsResponseDataModel -> {
            if (expectationDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                ExpectationsViewModel viewModel = expectationDetailsDataModelToViewModelMapper.mapToViewModel(expectationDetailsResponseDataModel);
                if (view != null) {
                    view.showProgress(false);
                    if (isFromRegistration) {
                        view.navigateToFamilyDetails();
                    } else {
                        view.close();
                    }
                }
            } else {
                if (view != null) {
                    view.showProgress(false);
                }
                //  Log.d("ERROR", expectationDetailsResponseDataModel.getMessage());
                view.showErrorMessage(expectationDetailsResponseDataModel.getMessage());
            }
        }, error -> {
            if (view != null) {
                view.showProgress(false);
            }
            //  Log.d("ERROR", error.getMessage());
            view.showErrorMessage(error.getMessage());
        });
    }

    public void getExpectationDetails() {
        if (view != null) {
            view.showProgress(true);
        }
        getExpectationDetailsUseCase.execute(String.valueOf(UserInfo.getUserInfo().getCandidateId()))
                .compose(bindToLifecycle()).subscribe(personalDetailsResponseDataModel -> {
            if (personalDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                ExpectationsViewModel viewModel = expectationDetailsDataModelToViewModelMapper.mapToViewModel(personalDetailsResponseDataModel);
                if (view != null) {
                    view.showProgress(false);
                    view.showExpectationDetails(viewModel);
                }
            } else {
                if (view != null) {
                    view.showProgress(false);
                }
                //  Log.d("ERROR", personalDetailsResponseDataModel.getMessage());
                view.showErrorMessage(personalDetailsResponseDataModel.getMessage());
            }
        }, error -> {
            if (view != null) {
                view.showProgress(false);
            }
            //  Log.d("ERROR", error.getMessage());
            view.showErrorMessage(error.getMessage());
        });
    }
}
