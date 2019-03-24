package unity.com.unityapp.unity.com.unityapp.base.view;

import android.util.Log;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.CheckAndGetContactDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.GetContactDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.AddressDetailsResponseDataModelToViewModel;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.ContactDetailsResponseDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.AddressViewModel;

public class ShowContactDetailsPresenter extends BasePresenter<ShowContactDetailsView> {

    private final CheckAndGetContactDetailsUseCase useCase;
    private final GetContactDetailsUseCase getContactDetailsUseCase;
    private final ContactDetailsResponseDataModelToViewModelMapper contactDetailsResponseDataModelToViewModelMapper;
    private final AddressDetailsResponseDataModelToViewModel addressDetailsResponseDataModelToViewModel;

    @Inject
    public ShowContactDetailsPresenter(CheckAndGetContactDetailsUseCase useCase, GetContactDetailsUseCase getContactDetailsUseCase, ContactDetailsResponseDataModelToViewModelMapper contactDetailsResponseDataModelToViewModelMapper, AddressDetailsResponseDataModelToViewModel addressDetailsResponseDataModelToViewModel) {
        this.useCase = useCase;
        this.getContactDetailsUseCase = getContactDetailsUseCase;
        this.contactDetailsResponseDataModelToViewModelMapper = contactDetailsResponseDataModelToViewModelMapper;
        this.addressDetailsResponseDataModelToViewModel = addressDetailsResponseDataModelToViewModel;
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
                        AddressViewModel addressViewModel = addressDetailsResponseDataModelToViewModel.mapToViewModel(personalDetailsResponseDataModel);
                        view.showContactDetails(addressViewModel);
                    }
                }
            } else if (personalDetailsResponseDataModel.getStatus().equals(Constants.STATUS_400)){
                if (view != null) {
                    view.showProgressBar(false);
                    view.showUpgradeMessage(personalDetailsResponseDataModel.getMessage());
                }
                Log.d("ERROR", personalDetailsResponseDataModel.getMessage());
            }else{
                if (view != null) {
                    view.showProgressBar(false);
                    view.showError(personalDetailsResponseDataModel.getMessage());
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
