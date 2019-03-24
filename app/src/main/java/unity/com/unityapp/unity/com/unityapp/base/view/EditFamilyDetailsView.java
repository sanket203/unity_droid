package unity.com.unityapp.unity.com.unityapp.base.view;

import unity.com.unityapp.unity.com.unityapp.base.BaseView;
import unity.com.unityapp.unity.com.unityapp.base.view.model.FamilyDetailsViewModel;

public interface EditFamilyDetailsView extends BaseView {
    void showProgress(boolean showProgress);
    void showErrorMessage(String message);

    void showFamilyDetails(FamilyDetailsViewModel viewModel);

    void navigateToContactDetails();


}
