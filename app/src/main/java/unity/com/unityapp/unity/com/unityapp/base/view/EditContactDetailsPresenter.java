package unity.com.unityapp.unity.com.unityapp.base.view;

import android.util.Log;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.UserInfo;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.GetContactDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.SaveAddressDetailsUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.AddressDetailsResponseDataModelToViewModel;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.AddressViewModelToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.ContactDetailsResponseDataModelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.AddressViewModel;

public class EditContactDetailsPresenter extends BasePresenter<EditContactDetailsView> {


    private final SaveAddressDetailsUseCase saveAddressDetailsUseCase;

    private final AddressViewModelToDataModelMapper addressViewModelToDataModelMapper;

    private final ContactDetailsResponseDataModelToViewModelMapper addressDetailsResponseDataModelToViewModel;

    private final GetContactDetailsUseCase getContactDetailsUseCase;

    @Inject
    public EditContactDetailsPresenter(SaveAddressDetailsUseCase saveAddressDetailsUseCase, AddressViewModelToDataModelMapper addressViewModelToDataModelMapper, ContactDetailsResponseDataModelToViewModelMapper addressDetailsResponseDataModelToViewModel, GetContactDetailsUseCase getContactDetailsUseCase) {
        this.saveAddressDetailsUseCase = saveAddressDetailsUseCase;
        this.addressViewModelToDataModelMapper = addressViewModelToDataModelMapper;
        this.addressDetailsResponseDataModelToViewModel = addressDetailsResponseDataModelToViewModel;
        this.getContactDetailsUseCase = getContactDetailsUseCase;
    }

    public void save(AddressViewModel addressViewModel, boolean isFromRegistration) {
        if (view != null) {
            view.showProgress(true);
        }
        saveAddressDetailsUseCase.execute(addressViewModelToDataModelMapper.mapToDataModel(addressViewModel))
                .compose(bindToLifecycle()).subscribe(educationDetailsResponseDataModel -> {
            if (educationDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                AddressViewModel viewModel = addressDetailsResponseDataModelToViewModel.mapToViewModel(educationDetailsResponseDataModel);
                if (view != null) {
                    view.showProgress(false);
                    if (isFromRegistration) {
                        view.navigateToRegistrationDone();
                    } else {
                        view.close();
                    }
                }
            } else {
                if (view != null) {
                    view.showProgress(false);
                }
                Log.d("ERROR", educationDetailsResponseDataModel.getMessage());
            }
        }, error -> {
            if (view != null) {
                view.showProgress(false);
            }
            Log.d("ERROR", error.getMessage());
        });
    }

    void getContactDetails() {
        if (view != null) {
            view.showProgress(true);
        }
        getContactDetailsUseCase.execute(String.valueOf(UserInfo.getUserInfo().getCandidateId()))
                .compose(bindToLifecycle()).subscribe(educationDetailsResponseDataModel -> {
            if (educationDetailsResponseDataModel.getStatus().equals(Constants.STATUS_200)) {
                AddressViewModel viewModel = addressDetailsResponseDataModelToViewModel.mapToViewModel(educationDetailsResponseDataModel);
                if (view != null) {
                    view.showProgress(false);

                    view.showContactDetails(viewModel);

                }
            } else {
                if (view != null) {
                    view.showProgress(false);
                }
                Log.d("ERROR", educationDetailsResponseDataModel.getMessage());
            }
        }, error -> {
            if (view != null) {
                view.showProgress(false);
            }
            Log.d("ERROR", error.getMessage());
        });
    }

}
