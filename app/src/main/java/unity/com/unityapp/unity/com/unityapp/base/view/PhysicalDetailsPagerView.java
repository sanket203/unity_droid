package unity.com.unityapp.unity.com.unityapp.base.view;

import unity.com.unityapp.unity.com.unityapp.base.BaseView;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PhysicalDetailsViewModel;

public interface PhysicalDetailsPagerView extends BaseView {

    void showPhysicalDetails(PhysicalDetailsViewModel viewModel);
    void showErrorMessage(String message);
    void showProgressBar(boolean isVisible);
}
