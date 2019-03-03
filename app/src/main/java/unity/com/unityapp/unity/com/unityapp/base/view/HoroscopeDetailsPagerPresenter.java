package unity.com.unityapp.unity.com.unityapp.base.view;

import android.util.Log;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.GetHoroscopeDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.GetPersonalDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.HoroscopeDetailsDatamodelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.PersonalDetailsDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.HoroscopeDetailsViewModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PersonalDetailsViewModel;

public class HoroscopeDetailsPagerPresenter extends BasePresenter<HoroscopeDetailsPagerView> {

    private final GetHoroscopeDetailsUseCase getHoroscopeDetailsUseCase;
    private final HoroscopeDetailsDatamodelToViewModelMapper horoscopeDetailsDatamodelToViewModelMapper;

    @Inject

    public HoroscopeDetailsPagerPresenter(GetHoroscopeDetailsUseCase getHoroscopeDetailsUseCase, HoroscopeDetailsDatamodelToViewModelMapper horoscopeDetailsDatamodelToViewModelMapper) {
        this.getHoroscopeDetailsUseCase = getHoroscopeDetailsUseCase;
        this.horoscopeDetailsDatamodelToViewModelMapper = horoscopeDetailsDatamodelToViewModelMapper;
    }

    public void getHoroscopeDetails(String candidateId) {
        if (view != null) {
            view.showProgressBar(true);
        }
        getHoroscopeDetailsUseCase.execute(candidateId)
                .compose(bindToLifecycle()).subscribe(personalDetailsResponseDataModel -> {
            if (personalDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                HoroscopeDetailsViewModel viewModel = horoscopeDetailsDatamodelToViewModelMapper.mapToViewModel(personalDetailsResponseDataModel);
                if (view != null) {
                    view.showProgressBar(false);
                    view.showHoroscopeDetails(viewModel);
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


