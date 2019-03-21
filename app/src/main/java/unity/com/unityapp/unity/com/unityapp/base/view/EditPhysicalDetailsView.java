package unity.com.unityapp.unity.com.unityapp.base.view;

import unity.com.unityapp.unity.com.unityapp.base.BaseView;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PhysicalDetailsViewModel;

public interface EditPhysicalDetailsView extends BaseView {
    void showProgress(boolean showProgress);
    void showErrorMessage(String message);

    void navigateToEditEducationalDetails();

    void showPhysicalDetails(PhysicalDetailsViewModel viewModel);
}
