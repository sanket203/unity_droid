package unity.com.unityapp.unity.com.unityapp.base.view;

import android.util.Log;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.SaveDietDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.SavePersonalDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.DietDetailsDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.DietDetailsViewModelToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.PersonalDetailsDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.PersonalDetailsViewModelToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.DietDetailsViewModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PersonalDetailsViewModel;

public class EditDietDetailsPresenter extends BasePresenter<EditDietDetailsView> {

    private final SaveDietDetailsUseCase saveDietDetailsUseCase;

    private final DietDetailsDataModelToViewModelMapper dietDetailsDataModelToViewModelMapper;

    private final DietDetailsViewModelToDataModelMapper dietDetailsViewModelToDataModelMapper;

    @Inject
    public EditDietDetailsPresenter(SaveDietDetailsUseCase saveDietDetailsUseCase, DietDetailsDataModelToViewModelMapper dietDetailsDataModelToViewModelMapper, DietDetailsViewModelToDataModelMapper dietDetailsViewModelToDataModelMapper) {
        this.saveDietDetailsUseCase = saveDietDetailsUseCase;
        this.dietDetailsDataModelToViewModelMapper = dietDetailsDataModelToViewModelMapper;
        this.dietDetailsViewModelToDataModelMapper = dietDetailsViewModelToDataModelMapper;
    }

    public void save(DietDetailsViewModel dietDetailsViewModel, boolean isFromRegistration) {
        if (view != null) {
            view.showProgress(true);
        }
        saveDietDetailsUseCase.execute(dietDetailsViewModelToDataModelMapper.mapToDataModel(dietDetailsViewModel))
                .compose(bindToLifecycle()).subscribe(DietDetailsResponseDataModel -> {
            if (DietDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                DietDetailsViewModel viewModel = dietDetailsDataModelToViewModelMapper.mapToViewModel(DietDetailsResponseDataModel);
                if (view != null) {
                    view.showProgress(false);
                    if(isFromRegistration){
                        view.navigateToExpectationDetails();
                    }
                    view.close();
                }
            } else {
                if (view != null) {
                    view.showProgress(false);
                }
               // Log.d("ERROR", DietDetailsResponseDataModel.getMessage());
                view.showErrorMessage(DietDetailsResponseDataModel.getMessage());
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
