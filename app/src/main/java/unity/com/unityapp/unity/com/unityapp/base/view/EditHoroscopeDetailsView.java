package unity.com.unityapp.unity.com.unityapp.base.view;

import unity.com.unityapp.unity.com.unityapp.base.BaseView;
import unity.com.unityapp.unity.com.unityapp.base.view.model.HoroscopeDetailsViewModel;

public interface EditHoroscopeDetailsView extends BaseView {
    void showProgress(boolean showProgress);
    void showErrorMessage(String message);

    void navigateToEditDietDetails();

    void showHoroscopeDetails(HoroscopeDetailsViewModel viewModel);

}
