package unity.com.unityapp.unity.com.unityapp.base.view;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import unity.com.unityapp.R;
import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.SavePhysicalDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.PhysicalDetailsDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.PhysicalDetailsViewModelToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PhysicalDetailsViewModel;

public class EditPhysicalDetailsPresenter extends BasePresenter<EditPhysicalDetailsView> {

    private final SavePhysicalDetailsUseCase savePhysicalDetailsUseCase;

    private final PhysicalDetailsDataModelToViewModelMapper physicalDetailsDataModelToViewModelMapper;

    private final PhysicalDetailsViewModelToDataModelMapper physicalDetailsViewModelToDataModelMapper;

    @Inject
    public EditPhysicalDetailsPresenter(SavePhysicalDetailsUseCase savePhysicalDetailsUseCase, PhysicalDetailsDataModelToViewModelMapper physicalDetailsDataModelToViewModelMapper, PhysicalDetailsViewModelToDataModelMapper physicalDetailsViewModelToDataModelMapper) {
        this.savePhysicalDetailsUseCase = savePhysicalDetailsUseCase;
        this.physicalDetailsDataModelToViewModelMapper = physicalDetailsDataModelToViewModelMapper;
        this.physicalDetailsViewModelToDataModelMapper = physicalDetailsViewModelToDataModelMapper;
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
                view.showErrorMessage( personalDetailsResponseDataModel.getMessage());


            }
        }, error -> {
            if (view != null) {
                view.showProgress(false);
            }
           // Log.d("ERROR", error.getMessage());
            view.showErrorMessage( error.getMessage());
        });
    }
}
