package unity.com.unityapp.unity.com.unityapp.base.view;

import android.util.Log;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.UserInfo;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.GetFamilyDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.SaveFamilyDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.FamilyDetailsResponseDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.FamilyDetailsViewModelToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.FamilyDetailsViewModel;

public class EditFamilyDetailsPresenter extends BasePresenter<EditFamilyDetailsView> {

    private final SaveFamilyDetailsUseCase saveFamilyDetailsUseCase;

    private final FamilyDetailsResponseDataModelToViewModelMapper familyDetailsDataModelToViewModelMapper;

    private final FamilyDetailsViewModelToDataModelMapper familyDetailsViewModelToDataModelMapper;
    private final GetFamilyDetailsUseCase familyDetailsUseCase;

    private final FamilyDetailsResponseDataModelToViewModelMapper familyDetailsResponseDataModelToViewModelMapper;

    @Inject
    public EditFamilyDetailsPresenter(SaveFamilyDetailsUseCase saveFamilyDetailsUseCase, FamilyDetailsResponseDataModelToViewModelMapper familyDetailsDataModelToViewModelMapper, FamilyDetailsViewModelToDataModelMapper familyDetailsViewModelToDataModelMapper, GetFamilyDetailsUseCase familyDetailsUseCase, FamilyDetailsResponseDataModelToViewModelMapper familyDetailsResponseDataModelToViewModelMapper) {
        this.saveFamilyDetailsUseCase = saveFamilyDetailsUseCase;
        this.familyDetailsDataModelToViewModelMapper = familyDetailsDataModelToViewModelMapper;
        this.familyDetailsViewModelToDataModelMapper = familyDetailsViewModelToDataModelMapper;
        this.familyDetailsUseCase = familyDetailsUseCase;
        this.familyDetailsResponseDataModelToViewModelMapper = familyDetailsResponseDataModelToViewModelMapper;
    }

    public void save(FamilyDetailsViewModel familyDetailsViewModel, boolean isFromRegistration) {
        if (view != null) {
            view.showProgress(true);
        }
        saveFamilyDetailsUseCase.execute(familyDetailsViewModelToDataModelMapper.mapToDataModel(familyDetailsViewModel))
                .compose(bindToLifecycle()).subscribe(familyDetailsResponseDataModel -> {
            if (familyDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                FamilyDetailsViewModel viewModel = familyDetailsDataModelToViewModelMapper.mapToViewModel(familyDetailsResponseDataModel);
                if (view != null) {
                    view.showProgress(false);
                    if (isFromRegistration) {
                        //navigate to address details
                    } else {
                        view.close();
                    }
                }
            } else {
                if (view != null) {
                    view.showProgress(false);
                }
                //Log.d("ERROR", familyDetailsResponseDataModel.getMessage());
                view.showErrorMessage(familyDetailsResponseDataModel.getMessage());
            }
        }, error -> {
            if (view != null) {
                view.showProgress(false);
            }
            Log.d("ERROR", error.getMessage());
            view.showErrorMessage(error.getMessage());
        });
    }

    public void getFamilyDetails() {
        if (view != null) {
            view.showProgress(true);
        }
        familyDetailsUseCase.execute(String.valueOf(UserInfo.getUserInfo().getCandidateId()))
                .compose(bindToLifecycle()).subscribe(personalDetailsResponseDataModel -> {
            if (personalDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                FamilyDetailsViewModel viewModel = familyDetailsResponseDataModelToViewModelMapper.mapToViewModel(personalDetailsResponseDataModel);
                if (view != null) {
                    view.showProgress(false);
                    view.showFamilyDetails(viewModel);
                }
            } else {
                if (view != null) {
                    view.showProgress(false);
                }
                // Log.d("ERROR", personalDetailsResponseDataModel.getMessage());
                view.showErrorMessage(personalDetailsResponseDataModel.getMessage());
            }
        }, error -> {
            if (view != null) {
                view.showProgress(false);
            }
            //Log.d("ERROR", error.getMessage());
            view.showErrorMessage(error.getMessage());
        });
    }
}
