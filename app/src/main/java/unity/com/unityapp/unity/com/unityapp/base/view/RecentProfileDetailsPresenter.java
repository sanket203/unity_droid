package unity.com.unityapp.unity.com.unityapp.base.view;

import android.util.Log;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.CheckAndGetContactDetailsUseCase;

/**
 * Created by admin on 11/12/18.
 */

public class RecentProfileDetailsPresenter extends BasePresenter<RecentProfileDetailsView> {

    private final CheckAndGetContactDetailsUseCase useCase;

    @Inject
    public RecentProfileDetailsPresenter(CheckAndGetContactDetailsUseCase useCase) {
        this.useCase = useCase;
    }

    public void getContactDetails(String candidateId, String profileId, Boolean isAddressExist) {
        if (view != null) {
            view.showProgressBar(true);
        }
        useCase.execute(candidateId, profileId, isAddressExist)
                .compose(bindToLifecycle()).subscribe(personalDetailsResponseDataModel -> {
            if (personalDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                if (view != null) {
                    view.showProgressBar(false);
                    if (personalDetailsResponseDataModel.getContactDetailsDataModel().getAddressDataModels().size() > 0) {
                        view.navigateToAddressFragment();
                    } else {
                         view.showPopup();
                    }
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
