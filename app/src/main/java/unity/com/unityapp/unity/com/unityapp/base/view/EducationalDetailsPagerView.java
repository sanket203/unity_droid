package unity.com.unityapp.unity.com.unityapp.base.view;

import unity.com.unityapp.unity.com.unityapp.base.BaseView;
import unity.com.unityapp.unity.com.unityapp.base.view.model.EducationalDetailsViewModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PersonalDetailsViewModel;

public interface EducationalDetailsPagerView extends BaseView {

    void showEducationDetails(EducationalDetailsViewModel viewModel);
    void showErrorMessage(String message);
    void showProgressBar(boolean isVisible);
}
