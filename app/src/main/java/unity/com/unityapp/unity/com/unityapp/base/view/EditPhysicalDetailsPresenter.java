package unity.com.unityapp.unity.com.unityapp.base.view;

import android.util.Log;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.SavePersonalDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.SavePhysicalDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.PersonalDetailsDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.PersonalDetailsViewModelToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.PhysicalDetailsDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PersonalDetailsViewModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PhysicalDetailsViewModel;

public class EditPhysicalDetailsPresenter extends BasePresenter<EditPhysicalDetailsView> {

    private final SavePhysicalDetailsUseCase savePhysicalDetailsUseCase;

    private final PhysicalDetailsDataModelToViewModelMapper physicalDetailsDataModelToViewModelMapper;

    private final PhysicalDetailsViewModelToDataModelMapper physicalDetailsViewModelToDataModelMapper;

    public EditPhysicalDetailsPresenter(SavePhysicalDetailsUseCase savePhysicalDetailsUseCase, PhysicalDetailsDataModelToViewModelMapper physicalDetailsDataModelToViewModelMapper, PhysicalDetailsViewModelToDataModelMapper physicalDetailsViewModelToDataModelMapper) {
        this.savePhysicalDetailsUseCase = savePhysicalDetailsUseCase;
        this.physicalDetailsDataModelToViewModelMapper = physicalDetailsDataModelToViewModelMapper;
        this.physicalDetailsViewModelToDataModelMapper = physicalDetailsViewModelToDataModelMapper;
    }

    @Inject

    public void save(PhysicalDetailsViewModel physicalDetailsViewModel) {
        if (view != null) {
            view.showProgress(true);
        }
        savePhysicalDetailsUseCase.execute(physicalDetailsViewModelToDataModelMapper.mapToDataModel(physicalDetailsViewModel))
                .compose(bindToLifecycle()).subscribe(personalDetailsResponseDataModel -> {
            if (personalDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                PhysicalDetailsViewModel viewModel = physicalDetailsDataModelToViewModelMapper.mapToViewModel(personalDetailsResponseDataModel);
                if (view != null) {
                    view.showProgress(false);
                    view.close();
                }
            } else {
                if (view != null) {
                    view.showProgress(false);
                }
                Log.d("ERROR", personalDetailsResponseDataModel.getMessage());
            }
        }, error -> {
            if (view != null) {
                view.showProgress(false);
            }
            Log.d("ERROR", error.getMessage());
        });
    }
}
