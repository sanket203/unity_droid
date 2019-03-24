package unity.com.unityapp.unity.com.unityapp.base.view;

import unity.com.unityapp.unity.com.unityapp.base.BaseView;
import unity.com.unityapp.unity.com.unityapp.base.view.model.AddressViewModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.EducationalDetailsViewModel;

public interface EditContactDetailsView extends BaseView {
    void showProgress(boolean showProgress);

    void navigateToEditServiceDetails();

    void showErrorMessage(String message);

    void showContactDetails(AddressViewModel viewModel);

    void navigateToRegistrationDone();


}
