package unity.com.unityapp.unity.com.unityapp.base.view;

import android.util.Log;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.GetPhysicalDetailUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.PhysicalDetailsDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PhysicalDetailsViewModel;

public class PhysicalDetailsPagerPresenter extends BasePresenter<PhysicalDetailsPagerView> {

    private final GetPhysicalDetailUseCase getPhysicalDetailsUseCase;
    private final PhysicalDetailsDataModelToViewModelMapper physicalDetailsDataModelToViewModelMapper;

    @Inject

    public PhysicalDetailsPagerPresenter(GetPhysicalDetailUseCase getPhysicalDetailsUseCase, PhysicalDetailsDataModelToViewModelMapper physicalDetailsDataModelToViewModelMapper) {
        this.getPhysicalDetailsUseCase = getPhysicalDetailsUseCase;
        this.physicalDetailsDataModelToViewModelMapper = physicalDetailsDataModelToViewModelMapper;
    }

    public void getPhysicalDetails(String candidateId) {
        if (view != null) {
            view.showProgressBar(true);
        }
        getPhysicalDetailsUseCase.execute(candidateId)
                .compose(bindToLifecycle()).subscribe(physicalDetailsResponseDataModel -> {
            if (physicalDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                PhysicalDetailsViewModel viewModel = physicalDetailsDataModelToViewModelMapper.mapToViewModel(physicalDetailsResponseDataModel);
                if (view != null) {
                    view.showProgressBar(false);
                    view.showPhysicalDetails(viewModel);
                }
            } else {
                if (view != null) {
                    view.showProgressBar(false);
                }
                Log.d("ERROR", physicalDetailsResponseDataModel.getMessage());
            }
        }, error -> {
            if (view != null) {
                view.showProgressBar(false);
            }
            Log.d("ERROR", error.getMessage());
        });
    }
}


