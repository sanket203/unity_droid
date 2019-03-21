package unity.com.unityapp.unity.com.unityapp.base.view;

import unity.com.unityapp.unity.com.unityapp.base.BaseView;
import unity.com.unityapp.unity.com.unityapp.base.view.model.ExpectationsViewModel;

public interface EditExpectationDetailsView extends BaseView {
    void showProgress(boolean showProgress);

    void showErrorMessage(String message);

    void navigateToFamilyDetails();

    void showExpectationDetails(ExpectationsViewModel viewModel);
}
