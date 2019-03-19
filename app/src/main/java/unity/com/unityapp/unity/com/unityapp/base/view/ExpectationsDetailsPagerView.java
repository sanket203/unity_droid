package unity.com.unityapp.unity.com.unityapp.base.view;

import unity.com.unityapp.unity.com.unityapp.base.BaseView;
import unity.com.unityapp.unity.com.unityapp.base.view.model.ExpectationsViewModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PersonalDetailsViewModel;

public interface ExpectationsDetailsPagerView extends BaseView {

    void showExpectationDetails(ExpectationsViewModel viewModel);
    void showErrorMessage(String message);
    void showProgressBar(boolean isVisible);
}
