package unity.com.unityapp.unity.com.unityapp.base.view;

import unity.com.unityapp.unity.com.unityapp.base.BaseView;

public interface EditHoroscopeDetailsView extends BaseView {
    void showProgress(boolean showProgress);
    void showErrorMessage(String message);

    void navigateToEditDietDetails();
}
