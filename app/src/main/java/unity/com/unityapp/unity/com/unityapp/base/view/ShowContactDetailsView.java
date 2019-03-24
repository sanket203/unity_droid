package unity.com.unityapp.unity.com.unityapp.base.view;

import unity.com.unityapp.unity.com.unityapp.base.BaseView;
import unity.com.unityapp.unity.com.unityapp.base.view.model.AddressViewModel;

public interface ShowContactDetailsView extends BaseView {
    void showProgressBar(boolean b);

    void showContactDetails(AddressViewModel addressViewModel);

    void showError(String message);

    void showUpgradeMessage(String message);
}
