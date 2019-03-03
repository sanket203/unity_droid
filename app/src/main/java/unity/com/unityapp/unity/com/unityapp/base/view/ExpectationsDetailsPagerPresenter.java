package unity.com.unityapp.unity.com.unityapp.base.view;

import android.util.Log;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.GetExpectationDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.ExpectationDetailsDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.PersonalDetailsDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.ExpectationsViewModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PersonalDetailsViewModel;

public class ExpectationsDetailsPagerPresenter extends BasePresenter<ExpectationsDetailsPagerView> {

    private final GetExpectationDetailsUseCase getExpectationDetailsUseCase;
    private final ExpectationDetailsDataModelToViewModelMapper expectationDetailsDataModelToViewModelMapper;

    @Inject

    public ExpectationsDetailsPagerPresenter(GetExpectationDetailsUseCase getExpectationDetailsUseCase, ExpectationDetailsDataModelToViewModelMapper expectationDetailsDataModelToViewModelMapper) {
        this.getExpectationDetailsUseCase = getExpectationDetailsUseCase;
        this.expectationDetailsDataModelToViewModelMapper = expectationDetailsDataModelToViewModelMapper;
    }

    public void getExpectationDetails(String candidateId) {
        if (view != null) {
            view.showProgressBar(true);
        }
        getExpectationDetailsUseCase.execute(candidateId)
                .compose(bindToLifecycle()).subscribe(personalDetailsResponseDataModel -> {
            if (personalDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                ExpectationsViewModel viewModel = expectationDetailsDataModelToViewModelMapper.mapToViewModel(personalDetailsResponseDataModel);
                if (view != null) {
                    view.showProgressBar(false);
                    view.showExpectationDetails(viewModel);
                }
            } else {
                if (view != null) {
                    view.showProgressBar(false);
                }
                Log.d("ERROR", personalDetailsResponseDataModel.getMessage());
            }
        }, error -> {
            if (view != null) {
                view.showProgressBar(false);
            }
            Log.d("ERROR", error.getMessage());
        });
    }
}


