package unity.com.unityapp.unity.com.unityapp.base.view;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.CheckAndGetContactDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.GetPersonalDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.PersonalDetailsDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PersonalDetailsViewModel;

public class AddressDetailsPagerPresenter extends BasePresenter<AddressDetailsPagerView> {

    private final CheckAndGetContactDetailsUseCase useCase;


    @Inject
    public AddressDetailsPagerPresenter(CheckAndGetContactDetailsUseCase useCase) {
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
                        // TODO: 17-03-2019 write view model binding
                        // view.showPersonalDetails();
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


