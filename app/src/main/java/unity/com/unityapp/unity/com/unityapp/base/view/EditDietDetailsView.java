package unity.com.unityapp.unity.com.unityapp.base.view;

import unity.com.unityapp.unity.com.unityapp.base.BaseView;
import unity.com.unityapp.unity.com.unityapp.base.view.model.DietDetailsViewModel;

public interface EditDietDetailsView extends BaseView {
    void showProgress(boolean showProgress);

    void showErrorMessage(String message);

    void navigateToExpectationDetails();

    void showDietDetails(DietDetailsViewModel viewModel);

}
