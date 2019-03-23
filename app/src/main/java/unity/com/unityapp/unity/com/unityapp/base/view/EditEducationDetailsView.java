package unity.com.unityapp.unity.com.unityapp.base.view;

import unity.com.unityapp.unity.com.unityapp.base.BaseView;
import unity.com.unityapp.unity.com.unityapp.base.view.model.EducationalDetailsViewModel;

public interface EditEducationDetailsView extends BaseView {
    void showProgress(boolean showProgress);

    void navigateToEditServiceDetails();

    void showEducationDetails(EducationalDetailsViewModel viewModel);

    void showErrorMessage(String message);
}
