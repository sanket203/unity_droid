package unity.com.unityapp.unity.com.unityapp.base.view;

import unity.com.unityapp.unity.com.unityapp.base.BaseView;
import unity.com.unityapp.unity.com.unityapp.base.view.model.ImageResponseViewModel;

/**
 * Created by admin on 11/12/18.
 */

public interface RecentProfileDetailsView extends BaseView {
    void showProgressBar(boolean b);

    void showPopup();

    void navigateToAddressFragment(boolean b);

    void showImages(ImageResponseViewModel viewModel);
}
