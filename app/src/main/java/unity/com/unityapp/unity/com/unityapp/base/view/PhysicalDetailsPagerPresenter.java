package unity.com.unityapp.unity.com.unityapp.base.view;

import android.util.Log;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.GetPersonalDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.GetPhysicalDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.PersonalDetailsDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.PhysicalDetailsDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PersonalDetailsViewModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PhysicalDetailsViewModel;

public class PhysicalDetailsPagerPresenter extends BasePresenter<PhysicalDetailsPagerView> {

    private final GetPhysicalDetailsUseCase getPhysicalDetailsUseCase;
    private final PhysicalDetailsDataModelToViewModelMapper physicalDetailsDataModelToViewModelMapper;

    @Inject

    public PhysicalDetailsPagerPresenter(GetPhysicalDetailsUseCase getPhysicalDetailsUseCase, PhysicalDetailsDataModelToViewModelMapper physicalDetailsDataModelToViewModelMapper) {
        this.getPhysicalDetailsUseCase = getPhysicalDetailsUseCase;
        this.physicalDetailsDataModelToViewModelMapper = physicalDetailsDataModelToViewModelMapper;
    }

    public void getPhysicalDetails(String candidateId) {
        if (view != null) {
            view.showProgressBar(true);
        }
        getPhysicalDetailsUseCase.execute(candidateId)
                .compose(bindToLifecycle()).subscribe(personalDetailsResponseDataModel -> {
            if (personalDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                PhysicalDetailsViewModel viewModel = physicalDetailsDataModelToViewModelMapper.mapToViewModel(personalDetailsResponseDataModel);
                if (view != null) {
                    view.showProgressBar(false);
                    view.showPhysicalDetails(viewModel);
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


