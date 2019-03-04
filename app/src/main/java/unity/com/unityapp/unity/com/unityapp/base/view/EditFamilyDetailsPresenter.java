package unity.com.unityapp.unity.com.unityapp.base.view;

import android.util.Log;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.SaveFamilyDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.FamilyDetailsResponseDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.FamilyDetailsViewModelToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.FamilyDetailsViewModel;

public class EditFamilyDetailsPresenter extends BasePresenter<EditFamilyDetailsView> {

    private final SaveFamilyDetailsUseCase saveFamilyDetailsUseCase;

    private final FamilyDetailsResponseDataModelToViewModelMapper familyDetailsDataModelToViewModelMapper;

    private final FamilyDetailsViewModelToDataModelMapper familyDetailsViewModelToDataModelMapper;

    @Inject
    public EditFamilyDetailsPresenter(SaveFamilyDetailsUseCase saveFamilyDetailsUseCase, FamilyDetailsResponseDataModelToViewModelMapper familyDetailsDataModelToViewModelMapper, FamilyDetailsViewModelToDataModelMapper familyDetailsViewModelToDataModelMapper) {
        this.saveFamilyDetailsUseCase = saveFamilyDetailsUseCase;
        this.familyDetailsDataModelToViewModelMapper = familyDetailsDataModelToViewModelMapper;
        this.familyDetailsViewModelToDataModelMapper = familyDetailsViewModelToDataModelMapper;
    }

    public void save(FamilyDetailsViewModel familyDetailsViewModel) {
        if (view != null) {
            view.showProgress(true);
        }
        saveFamilyDetailsUseCase.execute(familyDetailsViewModelToDataModelMapper.mapToDataModel(familyDetailsViewModel))
                .compose(bindToLifecycle()).subscribe(familyDetailsResponseDataModel -> {
            if (familyDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                FamilyDetailsViewModel viewModel = familyDetailsDataModelToViewModelMapper.mapToViewModel(familyDetailsResponseDataModel);
                if (view != null) {
                    view.showProgress(false);
                    view.close();
                }
            } else {
                if (view != null) {
                    view.showProgress(false);
                }
                Log.d("ERROR", familyDetailsResponseDataModel.getMessage());
            }
        }, error -> {
            if (view != null) {
                view.showProgress(false);
            }
            Log.d("ERROR", error.getMessage());
        });
    }
}
