package unity.com.unityapp.unity.com.unityapp.base.view;

import unity.com.unityapp.unity.com.unityapp.base.BaseView;
import unity.com.unityapp.unity.com.unityapp.base.view.model.ServiceDetailsViewModel;

public interface EditServiceDetailsView extends BaseView {
    void showProgress(boolean showProgress);
    void showErrorMessage(String message);
    void navigateToEditHoroscopeDetails();

    void showServiceDetails(ServiceDetailsViewModel viewModel);
}
