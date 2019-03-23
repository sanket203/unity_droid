package unity.com.unityapp.unity.com.unityapp.base.view;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.UserInfo;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.GetDietDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.SaveDietDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.DietDetailsDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.DietDetailsViewModelToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.DietDetailsViewModel;

public class EditDietDetailsPresenter extends BasePresenter<EditDietDetailsView> {

    private final SaveDietDetailsUseCase saveDietDetailsUseCase;

    private final DietDetailsDataModelToViewModelMapper dietDetailsDataModelToViewModelMapper;

    private final DietDetailsViewModelToDataModelMapper dietDetailsViewModelToDataModelMapper;
    private final GetDietDetailsUseCase getDietDetailsUseCase;

    @Inject
    public EditDietDetailsPresenter(SaveDietDetailsUseCase saveDietDetailsUseCase, DietDetailsDataModelToViewModelMapper dietDetailsDataModelToViewModelMapper, DietDetailsViewModelToDataModelMapper dietDetailsViewModelToDataModelMapper, GetDietDetailsUseCase getDietDetailsUseCase) {
        this.saveDietDetailsUseCase = saveDietDetailsUseCase;
        this.dietDetailsDataModelToViewModelMapper = dietDetailsDataModelToViewModelMapper;
        this.dietDetailsViewModelToDataModelMapper = dietDetailsViewModelToDataModelMapper;
        this.getDietDetailsUseCase = getDietDetailsUseCase;
    }

    public void save(DietDetailsViewModel dietDetailsViewModel, boolean isFromRegistration) {
        if (view != null) {
            view.showProgress(true);
        }
        saveDietDetailsUseCase.execute(dietDetailsViewModelToDataModelMapper.mapToDataModel(dietDetailsViewModel))
                .compose(bindToLifecycle()).subscribe(DietDetailsResponseDataModel -> {
            if (DietDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                DietDetailsViewModel viewModel = dietDetailsDataModelToViewModelMapper.mapToViewModel(DietDetailsResponseDataModel);
                if (view != null) {
                    view.showProgress(false);
                    if (isFromRegistration) {
                        view.navigateToExpectationDetails();
                    } else {
                        view.close();
                    }
                }
            } else {
                if (view != null) {
                    view.showProgress(false);
                }
                // Log.d("ERROR", DietDetailsResponseDataModel.getMessage());
                view.showErrorMessage(DietDetailsResponseDataModel.getMessage());
            }
        }, error -> {
            if (view != null) {
                view.showProgress(false);
            }
            //Log.d("ERROR", error.getMessage());
            view.showErrorMessage(error.getMessage());
        });
    }

    public void getDietDetails() {
        if (view != null) {
            view.showProgress(true);
        }
        getDietDetailsUseCase.execute(String.valueOf(UserInfo.getUserInfo().getCandidateId()))
                .compose(bindToLifecycle()).subscribe(personalDetailsResponseDataModel -> {
            if (personalDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                DietDetailsViewModel viewModel = dietDetailsDataModelToViewModelMapper.mapToViewModel(personalDetailsResponseDataModel);
                if (view != null) {
                    view.showProgress(false);
                    view.showDietDetails(viewModel);
                }
            } else {
                if (view != null) {
                    view.showProgress(false);
                }
                //Log.d("ERROR", personalDetailsResponseDataModel.getMessage());
                view.showErrorMessage(personalDetailsResponseDataModel.getMessage());
            }
        }, error -> {
            if (view != null) {
                view.showProgress(false);
            }
            // Log.d("ERROR", error.getMessage());
            view.showErrorMessage(error.getMessage());
        });
    }
}
