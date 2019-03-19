package unity.com.unityapp.unity.com.unityapp.base.view;

import unity.com.unityapp.unity.com.unityapp.base.BaseView;
import unity.com.unityapp.unity.com.unityapp.base.view.model.FamilyDetailsViewModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PersonalDetailsViewModel;

public interface FamilyDetailsPagerView extends BaseView {

    void showFamilyDetails(FamilyDetailsViewModel viewModel);
    void showErrorMessage(String message);
    void showProgressBar(boolean isVisible);
}
