package unity.com.unityapp.unity.com.unityapp.base.view;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.UserInfo;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.GetPhysicalDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.SavePhysicalDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.PhysicalDetailsDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.PhysicalDetailsViewModelToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PhysicalDetailsViewModel;

public class EditPhysicalDetailsPresenter extends BasePresenter<EditPhysicalDetailsView> {

    private final SavePhysicalDetailsUseCase savePhysicalDetailsUseCase;

    private final PhysicalDetailsDataModelToViewModelMapper physicalDetailsDataModelToViewModelMapper;

    private final PhysicalDetailsViewModelToDataModelMapper physicalDetailsViewModelToDataModelMapper;

    private final GetPhysicalDetailsUseCase getPhysicalDetailsUseCase;

    @Inject
    public EditPhysicalDetailsPresenter(SavePhysicalDetailsUseCase savePhysicalDetailsUseCase, PhysicalDetailsDataModelToViewModelMapper physicalDetailsDataModelToViewModelMapper, PhysicalDetailsViewModelToDataModelMapper physicalDetailsViewModelToDataModelMapper, GetPhysicalDetailsUseCase getPhysicalDetailsUseCase) {
        this.savePhysicalDetailsUseCase = savePhysicalDetailsUseCase;
        this.physicalDetailsDataModelToViewModelMapper = physicalDetailsDataModelToViewModelMapper;
        this.physicalDetailsViewModelToDataModelMapper = physicalDetailsViewModelToDataModelMapper;
        this.getPhysicalDetailsUseCase = getPhysicalDetailsUseCase;
    }


    public void save(PhysicalDetailsViewModel physicalDetailsViewModel, boolean isFromRegistration) {
        if (view != null) {
            view.showProgress(true);
        }
        savePhysicalDetailsUseCase.execute(physicalDetailsViewModelToDataModelMapper.mapToDataModel(physicalDetailsViewModel))
                .compose(bindToLifecycle()).subscribe(personalDetailsResponseDataModel -> {
            if (personalDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                PhysicalDetailsViewModel viewModel = physicalDetailsDataModelToViewModelMapper.mapToViewModel(personalDetailsResponseDataModel);
                if (view != null) {
                    view.showProgress(false);
                    if (isFromRegistration) {
                        view.navigateToEditEducationalDetails();
                    } else {
                        view.close();
                    }
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

    public void getPhysicalDetails() {
        if (view != null) {
            view.showProgress(true);
        }
        getPhysicalDetailsUseCase.execute(String.valueOf(UserInfo.getUserInfo().getCandidateId()))
                .compose(bindToLifecycle()).subscribe(personalDetailsResponseDataModel -> {
            if (personalDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                PhysicalDetailsViewModel viewModel = physicalDetailsDataModelToViewModelMapper.mapToViewModel(personalDetailsResponseDataModel);
                if (view != null) {
                    view.showProgress(false);
                    view.showPhysicalDetails(viewModel);
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
