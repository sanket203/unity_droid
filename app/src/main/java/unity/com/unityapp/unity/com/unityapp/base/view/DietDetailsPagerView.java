package unity.com.unityapp.unity.com.unityapp.base.view;

import unity.com.unityapp.unity.com.unityapp.base.BaseView;
import unity.com.unityapp.unity.com.unityapp.base.view.model.DietDetailsViewModel;

public interface DietDetailsPagerView extends BaseView {

    void showDietDetails(DietDetailsViewModel viewModel);

    void showProgressBar(boolean isVisible);
}
