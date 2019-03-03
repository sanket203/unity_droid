package unity.com.unityapp.unity.com.unityapp.base.view;

import android.util.Log;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.SavePersonalDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.PersonalDetailsDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.PersonalDetailsViewModelToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.EducationalDetailsViewModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PersonalDetailsViewModel;

public class EditPersonalDetailsPresenter extends BasePresenter<EditPersonalDetailsView> {

    private final SavePersonalDetailsUseCase savePersonalDetailsUseCase;

    private final PersonalDetailsDataModelToViewModelMapper personalDetailsDataModelToViewModelMapper;

    private final PersonalDetailsViewModelToDataModelMapper personalDetailsViewModelToDataModelMapper;

    @Inject
    public EditPersonalDetailsPresenter(SavePersonalDetailsUseCase savePersonalDetailsUseCase, PersonalDetailsDataModelToViewModelMapper personalDetailsDataModelToViewModelMapper, PersonalDetailsViewModelToDataModelMapper personalDetailsViewModelToDataModelMapper) {
        this.savePersonalDetailsUseCase = savePersonalDetailsUseCase;
        this.personalDetailsDataModelToViewModelMapper = personalDetailsDataModelToViewModelMapper;
        this.personalDetailsViewModelToDataModelMapper = personalDetailsViewModelToDataModelMapper;
    }

    public void save(PersonalDetailsViewModel personalDetailsViewModel) {
        if (view != null) {
            view.showProgress(true);
        }
        savePersonalDetailsUseCase.execute(personalDetailsViewModelToDataModelMapper.mapToDataModel(personalDetailsViewModel))
                .compose(bindToLifecycle()).subscribe(personalDetailsResponseDataModel -> {
            if (personalDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                PersonalDetailsViewModel viewModel = personalDetailsDataModelToViewModelMapper.mapToViewModel(personalDetailsResponseDataModel);
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
