package unity.com.unityapp.unity.com.unityapp.base.view;

import android.util.Log;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.GetEducationDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.GetPersonalDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.EducationDetailsDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.PersonalDetailsDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.EducationalDetailsViewModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PersonalDetailsViewModel;

public class EducationalDetailsPagerPresenter extends BasePresenter<EducationalDetailsPagerView> {

    private final GetEducationDetailsUseCase getEducationDetailsUseCase;
    private final EducationDetailsDataModelToViewModelMapper educationDetailsDataModelToViewModelMapper;

    @Inject

    public EducationalDetailsPagerPresenter(GetEducationDetailsUseCase getEducationDetailsUseCase, EducationDetailsDataModelToViewModelMapper educationDetailsDataModelToViewModelMapper) {
        this.getEducationDetailsUseCase = getEducationDetailsUseCase;
        this.educationDetailsDataModelToViewModelMapper = educationDetailsDataModelToViewModelMapper;
    }

    public void getEducationDetails(String candidateId) {
        if (view != null) {
            view.showProgressBar(true);
        }
        getEducationDetailsUseCase.execute(candidateId)
                .compose(bindToLifecycle()).subscribe(personalDetailsResponseDataModel -> {
            if (personalDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                EducationalDetailsViewModel viewModel = educationDetailsDataModelToViewModelMapper.mapToViewModel(personalDetailsResponseDataModel);
                if (view != null) {
                    view.showProgressBar(false);
                    view.showEducationDetails(viewModel);
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


