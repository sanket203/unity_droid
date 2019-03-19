package unity.com.unityapp.unity.com.unityapp.base.view;

import android.util.Log;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.GetPersonalDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.GetServiceDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.PersonalDetailsDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.ServiceDetailsDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PersonalDetailsViewModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.ServiceDetailsViewModel;

public class ServiceDetailsPagerPresenter extends BasePresenter<ServiceDetailsPagerView> {

    private final GetServiceDetailsUseCase getServiceDetailsUseCase;
    private final ServiceDetailsDataModelToViewModelMapper serviceDetailsDataModelToViewModelMapper;

    @Inject

    public ServiceDetailsPagerPresenter(GetServiceDetailsUseCase getServiceDetailsUseCase, ServiceDetailsDataModelToViewModelMapper serviceDetailsDataModelToViewModelMapper) {
        this.getServiceDetailsUseCase = getServiceDetailsUseCase;
        this.serviceDetailsDataModelToViewModelMapper = serviceDetailsDataModelToViewModelMapper;
    }

    public void getServiceDetails(String candidateId) {
        if (view != null) {
            view.showProgressBar(true);
        }
        getServiceDetailsUseCase.execute(candidateId)
                .compose(bindToLifecycle()).subscribe(personalDetailsResponseDataModel -> {
            if (personalDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                ServiceDetailsViewModel viewModel = serviceDetailsDataModelToViewModelMapper.mapToViewModel(personalDetailsResponseDataModel);
                if (view != null) {
                    view.showProgressBar(false);
                    view.showServiceDetails(viewModel);
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
          //  Log.d("ERROR", error.getMessage());
            view.showErrorMessage(error.getMessage());
        });
    }
}


