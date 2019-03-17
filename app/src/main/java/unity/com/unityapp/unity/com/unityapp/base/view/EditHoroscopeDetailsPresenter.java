package unity.com.unityapp.unity.com.unityapp.base.view;

import android.util.Log;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.SaveHoroscopeDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.HoroscopeDetailsDatamodelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.HoroscopeDetailsViewModelToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.HoroscopeDetailsViewModel;

public class EditHoroscopeDetailsPresenter extends BasePresenter<EditHoroscopeDetailsView> {

    private final SaveHoroscopeDetailsUseCase saveHoroscopeDetailsUseCase;

    private final HoroscopeDetailsDatamodelToViewModelMapper horoscopeDetailsDataModelToViewModelMapper;

    private final HoroscopeDetailsViewModelToDataModelMapper horoscopeDetailsViewModelToDataModelMapper;

    @Inject
    public EditHoroscopeDetailsPresenter(SaveHoroscopeDetailsUseCase saveHoroscopeDetailsUseCase, HoroscopeDetailsDatamodelToViewModelMapper horoscopeDetailsDataModelToViewModelMapper, HoroscopeDetailsViewModelToDataModelMapper horoscopeDetailsViewModelToDataModelMapper) {
        this.saveHoroscopeDetailsUseCase = saveHoroscopeDetailsUseCase;
        this.horoscopeDetailsDataModelToViewModelMapper = horoscopeDetailsDataModelToViewModelMapper;
        this.horoscopeDetailsViewModelToDataModelMapper = horoscopeDetailsViewModelToDataModelMapper;
    }

    public void save(HoroscopeDetailsViewModel horoscopeDetailsViewModel, boolean isFromRegistration) {
        if (view != null) {
            view.showProgress(true);
        }
        saveHoroscopeDetailsUseCase.execute(horoscopeDetailsViewModelToDataModelMapper.mapToDataModel(horoscopeDetailsViewModel))
                .compose(bindToLifecycle()).subscribe(horoscopeDetailsResponseDataModel -> {
            if (horoscopeDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                HoroscopeDetailsViewModel viewModel = horoscopeDetailsDataModelToViewModelMapper.mapToViewModel(horoscopeDetailsResponseDataModel);
                if (view != null) {
                    view.showProgress(false);
                    if (isFromRegistration) {
                        view.navigateToEditDietDetails();
                    } else {
                        view.close();
                    }
                }
            } else {
                if (view != null) {
                    view.showProgress(false);
                }
               // Log.d("ERROR", horoscopeDetailsResponseDataModel.getMessage());
                view.showErrorMessage(horoscopeDetailsResponseDataModel.getMessage());
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
