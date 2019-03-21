package unity.com.unityapp.unity.com.unityapp.base.view;

import android.util.Log;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.UserInfo;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.GetEducationDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.SaveEducationDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.EducationDetailsDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.EducationDetailsViewModelToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.EducationalDetailsViewModel;

public class EditEducationDetailsPresenter extends BasePresenter<EditEducationDetailsView> {

    private final SaveEducationDetailsUseCase saveEducationDetailsUseCase;

    private final EducationDetailsDataModelToViewModelMapper educationDetailsDataModelToViewModelMapper;

    private final EducationDetailsViewModelToDataModelMapper educationDetailsViewModelToDataModelMapper;
    private final GetEducationDetailsUseCase getEducationDetailsUseCase;

    @Inject
    public EditEducationDetailsPresenter(SaveEducationDetailsUseCase saveEducationDetailsUseCase, EducationDetailsDataModelToViewModelMapper educationDetailsDataModelToViewModelMapper, EducationDetailsViewModelToDataModelMapper educationDetailsViewModelToDataModelMapper, GetEducationDetailsUseCase getEducationDetailsUseCase) {
        this.saveEducationDetailsUseCase = saveEducationDetailsUseCase;
        this.educationDetailsDataModelToViewModelMapper = educationDetailsDataModelToViewModelMapper;
        this.educationDetailsViewModelToDataModelMapper = educationDetailsViewModelToDataModelMapper;
        this.getEducationDetailsUseCase = getEducationDetailsUseCase;
    }

    public void save(EducationalDetailsViewModel educationDetailsViewModel, boolean isFromRegistration) {
        if (view != null) {
            view.showProgress(true);
        }
        saveEducationDetailsUseCase.execute(educationDetailsViewModelToDataModelMapper.mapToDataModel(educationDetailsViewModel))
                .compose(bindToLifecycle()).subscribe(educationDetailsResponseDataModel -> {
            if (educationDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                EducationalDetailsViewModel viewModel = educationDetailsDataModelToViewModelMapper.mapToViewModel(educationDetailsResponseDataModel);
                if (view != null) {
                    view.showProgress(false);
                    if (isFromRegistration) {
                        view.navigateToEditServiceDetails();
                    } else {
                        view.close();
                    }
                }
            } else {
                if (view != null) {
                    view.showProgress(false);
                }
                Log.d("ERROR", educationDetailsResponseDataModel.getMessage());
            }
        }, error -> {
            if (view != null) {
                view.showProgress(false);
            }
            Log.d("ERROR", error.getMessage());
        });
    }

    public void getEducationDetails() {
        if (view != null) {
            view.showProgress(true);
        }
        getEducationDetailsUseCase.execute(String.valueOf(UserInfo.getUserInfo().getCandidateId()))
                .compose(bindToLifecycle()).subscribe(personalDetailsResponseDataModel -> {
            if (personalDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                EducationalDetailsViewModel viewModel = educationDetailsDataModelToViewModelMapper.mapToViewModel(personalDetailsResponseDataModel);
                if (view != null) {
                    view.showProgress(false);
                    view.showEducationDetails(viewModel);
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
