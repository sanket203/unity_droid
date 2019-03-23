package unity.com.unityapp.unity.com.unityapp.base.view;

import android.util.Log;

import javax.inject.Inject;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.UserInfo;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.GetPersonalDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.SavePersonalDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.UploadImageUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.PersonalDetailsDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.PersonalDetailsViewModelToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PersonalDetailsViewModel;

public class EditPersonalDetailsPresenter extends BasePresenter<EditPersonalDetailsView> {

    private final SavePersonalDetailsUseCase savePersonalDetailsUseCase;

    private final UploadImageUseCase uploadImageUseCase;

    private final PersonalDetailsDataModelToViewModelMapper personalDetailsDataModelToViewModelMapper;

    private final PersonalDetailsViewModelToDataModelMapper personalDetailsViewModelToDataModelMapper;

    private final GetPersonalDetailsUseCase getPersonalDetailsUseCase;

    @Inject
    public EditPersonalDetailsPresenter(SavePersonalDetailsUseCase savePersonalDetailsUseCase, UploadImageUseCase uploadImageUseCase, PersonalDetailsDataModelToViewModelMapper personalDetailsDataModelToViewModelMapper, PersonalDetailsViewModelToDataModelMapper personalDetailsViewModelToDataModelMapper, GetPersonalDetailsUseCase getPersonalDetailsUseCase) {
        this.savePersonalDetailsUseCase = savePersonalDetailsUseCase;
        this.uploadImageUseCase = uploadImageUseCase;
        this.personalDetailsDataModelToViewModelMapper = personalDetailsDataModelToViewModelMapper;
        this.personalDetailsViewModelToDataModelMapper = personalDetailsViewModelToDataModelMapper;
        this.getPersonalDetailsUseCase = getPersonalDetailsUseCase;
    }

    public void save(PersonalDetailsViewModel personalDetailsViewModel, boolean isFromRegistration) {
        if (view != null) {
            view.showProgress(true);
        }
        savePersonalDetailsUseCase.execute(personalDetailsViewModelToDataModelMapper.mapToDataModel(personalDetailsViewModel))
                .compose(bindToLifecycle()).subscribe(personalDetailsResponseDataModel -> {
            if (personalDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                PersonalDetailsViewModel viewModel = personalDetailsDataModelToViewModelMapper.mapToViewModel(personalDetailsResponseDataModel);
                if (view != null) {
                    view.showProgress(false);
                    if (isFromRegistration) {
                        view.navigateToEditPhysicalDetailsActivity();
                    } else {
                        view.close();
                    }
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
            //Log.d("ERROR", error.getMessage());
            view.showErrorMessage(error.getMessage());
        });
    }

    public void uploadImage(MultipartBody.Part imageFile, RequestBody body) {

        if (view != null) {
            view.showProgress(true);
        }
        uploadImageUseCase.execute(imageFile, body)
                .compose(bindToLifecycle()).subscribe(personalDetailsResponseDataModel -> {
            if (personalDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                PersonalDetailsViewModel viewModel = personalDetailsDataModelToViewModelMapper.mapToViewModel(personalDetailsResponseDataModel);
                if (view != null) {
                    view.showProgress(false);
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
            //Log.d("ERROR", error.getMessage());
            view.showErrorMessage(error.getMessage());
        });

    }

    public void getPersonalDetails() {
        if (view != null) {
            view.showProgressBar(true);
        }
        getPersonalDetailsUseCase.execute(String.valueOf(UserInfo.getUserInfo().getCandidateId()))
                .compose(bindToLifecycle()).subscribe(personalDetailsResponseDataModel -> {
            if (personalDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                PersonalDetailsViewModel viewModel = personalDetailsDataModelToViewModelMapper.mapToViewModel(personalDetailsResponseDataModel);
                if (view != null) {
                    view.showProgress(false);
                    view.showPersonalDetails(viewModel);
                }
            } else {
                if (view != null) {
                    view.showProgress(false);
                }
                Log.d("Error:" + EditPersonalDetailsPresenter.class.getSimpleName(), personalDetailsResponseDataModel.getMessage());
                view.showErrorMessage(personalDetailsResponseDataModel.getMessage());
            }
        }, error -> {
            if (view != null) {
                view.showProgress(false);
            }
            Log.d("Error:" + EditPersonalDetailsPresenter.class.getSimpleName(), error.getMessage());
            view.showErrorMessage(error.getMessage());
        });
    }
}

