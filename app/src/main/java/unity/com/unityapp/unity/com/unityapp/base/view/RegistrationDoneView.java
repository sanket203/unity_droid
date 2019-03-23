package unity.com.unityapp.unity.com.unityapp.base.view;

import unity.com.unityapp.unity.com.unityapp.base.BaseView;

public interface RegistrationDoneView extends BaseView {

    void navigateToHomeActivity();

    void showProgressBar(boolean b);

    void showErrorMessage(String message);

}
