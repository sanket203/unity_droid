package unity.com.unityapp.unity.com.unityapp.base.view;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.UserInfo;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.GetServiceDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.SaveServiceDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.ServiceDetailsDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.ServiceDetailsViewModelToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.ServiceDetailsViewModel;

public class EditServiceDetailsPresenter extends BasePresenter<EditServiceDetailsView> {

    private final SaveServiceDetailsUseCase saveServiceDetailsUseCase;

    private final GetServiceDetailsUseCase getServiceDetailsUseCase;

    private final ServiceDetailsDataModelToViewModelMapper serviceDetailsDataModelToViewModelMapper;

    private final ServiceDetailsViewModelToDataModelMapper serviceDetailsViewModelToDataModelMapper;

    @Inject
    public EditServiceDetailsPresenter(SaveServiceDetailsUseCase saveServiceDetailsUseCase, GetServiceDetailsUseCase getServiceDetailsUseCase, ServiceDetailsDataModelToViewModelMapper serviceDetailsDataModelToViewModelMapper, ServiceDetailsViewModelToDataModelMapper serviceDetailsViewModelToDataModelMapper) {
        this.saveServiceDetailsUseCase = saveServiceDetailsUseCase;
        this.getServiceDetailsUseCase = getServiceDetailsUseCase;
        this.serviceDetailsDataModelToViewModelMapper = serviceDetailsDataModelToViewModelMapper;
        this.serviceDetailsViewModelToDataModelMapper = serviceDetailsViewModelToDataModelMapper;
    }

    public void save(ServiceDetailsViewModel serviceDetailsViewModel, boolean isFromRegistration) {
        if (view != null) {
            view.showProgress(true);
        }
        saveServiceDetailsUseCase.execute(serviceDetailsViewModelToDataModelMapper.mapToDataModel(serviceDetailsViewModel))
                .compose(bindToLifecycle()).subscribe(serviceDetailsResponseDataModel -> {
            if (serviceDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                ServiceDetailsViewModel viewModel = serviceDetailsDataModelToViewModelMapper.mapToViewModel(serviceDetailsResponseDataModel);
                if (view != null) {
                    view.showProgress(false);
                    if (isFromRegistration) {
                        view.navigateToEditHoroscopeDetails();
                    } else {
                        view.close();
                    }
                }
            } else {
                if (view != null) {
                    view.showProgress(false);
                }
                // Log.d("ERROR", serviceDetailsResponseDataModel.getMessage());
                view.showErrorMessage(serviceDetailsResponseDataModel.getMessage());

            }
        }, error -> {
            if (view != null) {
                view.showProgress(false);
            }
            //Log.d("ERROR", error.getMessage());
            view.showErrorMessage(error.getMessage());
        });
    }

    public void getServiceDetails() {
        if (view != null) {
            view.showProgress(true);
        }
        getServiceDetailsUseCase.execute(String.valueOf(UserInfo.getUserInfo().getCandidateId()))
                .compose(bindToLifecycle()).subscribe(personalDetailsResponseDataModel -> {
            if (personalDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                ServiceDetailsViewModel viewModel = serviceDetailsDataModelToViewModelMapper.mapToViewModel(personalDetailsResponseDataModel);
                if (view != null) {
                    view.showProgress(false);
                    view.showServiceDetails(viewModel);
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
            //  Log.d("ERROR", error.getMessage());
            view.showErrorMessage(error.getMessage());
        });
    }
}
