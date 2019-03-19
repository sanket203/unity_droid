package unity.com.unityapp.unity.com.unityapp.base.view;

import android.util.Log;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.GetPersonalDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.PersonalDetailsDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PersonalDetailsViewModel;

public class PersonalDetailsPagerPresenter extends BasePresenter<PersonalDetailsPagerView> {

    private final GetPersonalDetailsUseCase getPersonalDetailsUseCase;
    private final PersonalDetailsDataModelToViewModelMapper personalDetailsDataModelToViewModelMapper;

    @Inject

    public PersonalDetailsPagerPresenter(GetPersonalDetailsUseCase getPersonalDetailsUseCase, PersonalDetailsDataModelToViewModelMapper personalDetailsDataModelToViewModelMapper) {
        this.getPersonalDetailsUseCase = getPersonalDetailsUseCase;
        this.personalDetailsDataModelToViewModelMapper = personalDetailsDataModelToViewModelMapper;
    }

    public void getPersonalDetails(String candidateId) {
        if (view != null) {
            view.showProgressBar(true);
        }
        getPersonalDetailsUseCase.execute(candidateId)
                .compose(bindToLifecycle()).subscribe(personalDetailsResponseDataModel -> {
            if (personalDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                PersonalDetailsViewModel viewModel = personalDetailsDataModelToViewModelMapper.mapToViewModel(personalDetailsResponseDataModel);
                if (view != null) {
                    view.showProgressBar(false);
                    view.showPersonalDetails(viewModel);
                }
            } else {
                if (view != null) {
                    view.showProgressBar(false);
                }
                //Log.d("ERROR", personalDetailsResponseDataModel.getMessage());
                view.showErrorMessage(personalDetailsResponseDataModel.getMessage());
            }
        }, error -> {
            if (view != null) {
                view.showProgressBar(false);
            }
            Log.d("ERROR", error.getMessage());
            view.showErrorMessage(error.getMessage());
        });
    }
}


