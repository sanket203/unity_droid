package unity.com.unityapp.unity.com.unityapp.base.view;

import unity.com.unityapp.unity.com.unityapp.base.BaseView;

/**
 * Created by admin on 19/12/18.
 */

public interface LoginView extends BaseView {
    void loginAndNavigateToHomeScreen();

    void showProgressBar(boolean showProgress);
}
