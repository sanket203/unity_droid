package unity.com.unityapp.unity.com.unityapp.base.view;

import android.util.Log;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.GetDietDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.DietDetailsDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.DietDetailsViewModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PersonalDetailsViewModel;

public class DietDetailsPagerPresenter extends BasePresenter<DietDetailsPagerView> {

    private final GetDietDetailsUseCase getDietDetailsUseCase;
    private final DietDetailsDataModelToViewModelMapper dietDetailsDataModelToViewModelMapper;

    @Inject

    public DietDetailsPagerPresenter(GetDietDetailsUseCase getDietDetailsUseCase, DietDetailsDataModelToViewModelMapper personalDetailsDataModelToViewModelMapper) {
        this.getDietDetailsUseCase = getDietDetailsUseCase;
        this.dietDetailsDataModelToViewModelMapper = personalDetailsDataModelToViewModelMapper;
    }

    public void getDietDetails(String candidateId) {
        if (view != null) {
            view.showProgressBar(true);
        }
        getDietDetailsUseCase.execute(candidateId)
                .compose(bindToLifecycle()).subscribe(personalDetailsResponseDataModel -> {
            if (personalDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                DietDetailsViewModel viewModel = dietDetailsDataModelToViewModelMapper.mapToViewModel(personalDetailsResponseDataModel);
                if (view != null) {
                    view.showProgressBar(false);
                    view.showDietDetails(viewModel);
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


