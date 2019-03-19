package unity.com.unityapp.unity.com.unityapp.base.view;

import android.util.Log;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.GetFamilyDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.GetPersonalDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.FamilyDetailsResponseDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.PersonalDetailsDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.FamilyDetailsViewModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PersonalDetailsViewModel;

public class FamilyDetailsPagerPresenter extends BasePresenter<FamilyDetailsPagerView> {

    private final GetFamilyDetailsUseCase familyDetailsUseCase;
    private final FamilyDetailsResponseDataModelToViewModelMapper familyDetailsResponseDataModelToViewModelMapper;

    @Inject

    public FamilyDetailsPagerPresenter(GetFamilyDetailsUseCase familyDetailsUseCase, FamilyDetailsResponseDataModelToViewModelMapper familyDetailsResponseDataModelToViewModelMapper) {
        this.familyDetailsUseCase = familyDetailsUseCase;
        this.familyDetailsResponseDataModelToViewModelMapper = familyDetailsResponseDataModelToViewModelMapper;
    }

    public void getFamilyDetails(String candidateId) {
        if (view != null) {
            view.showProgressBar(true);
        }
        familyDetailsUseCase.execute(candidateId)
                .compose(bindToLifecycle()).subscribe(personalDetailsResponseDataModel -> {
            if (personalDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                FamilyDetailsViewModel viewModel = familyDetailsResponseDataModelToViewModelMapper.mapToViewModel(personalDetailsResponseDataModel);
                if (view != null) {
                    view.showProgressBar(false);
                    view.showFamilyDetails(viewModel);
                }
            } else {
                if (view != null) {
                    view.showProgressBar(false);
                }
               // Log.d("ERROR", personalDetailsResponseDataModel.getMessage());
                view.showErrorMessage(personalDetailsResponseDataModel.getMessage());
            }
        }, error -> {
            if (view != null) {
                view.showProgressBar(false);
            }
            //Log.d("ERROR", error.getMessage());
            view.showErrorMessage(error.getMessage());
        });
    }
}


