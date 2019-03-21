package unity.com.unityapp.unity.com.unityapp.base.view;

import unity.com.unityapp.unity.com.unityapp.base.BaseView;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PersonalDetailsViewModel;

public interface EditPersonalDetailsView extends BaseView {
    void showProgress(boolean showProgress);
    void showErrorMessage(String message);

    void navigateToEditPhysicalDetailsActivity();

    void showProgressBar(boolean b);

    void showPersonalDetails(PersonalDetailsViewModel viewModel);
}
