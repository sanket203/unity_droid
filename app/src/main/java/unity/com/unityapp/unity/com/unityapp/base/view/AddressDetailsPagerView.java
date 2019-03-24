package unity.com.unityapp.unity.com.unityapp.base.view;

import unity.com.unityapp.unity.com.unityapp.base.BaseView;
import unity.com.unityapp.unity.com.unityapp.base.view.model.AddressViewModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PersonalDetailsViewModel;

public interface AddressDetailsPagerView extends BaseView {

    void showPersonalDetails(PersonalDetailsViewModel viewModel);

    void showProgressBar(boolean isVisible);

    void showPopup();

    void showContactDetails(AddressViewModel viewModel);

    void showError(String message);
}
