package unity.com.unityapp.unity.com.unityapp.base.view;

import unity.com.unityapp.unity.com.unityapp.base.BaseView;
import unity.com.unityapp.unity.com.unityapp.base.view.model.RecentProfileResponseViewModel;

/**
 * Created by admin on 11/12/18.
 */

public interface RecentProfileView extends BaseView {

    void showRecentProfiles(RecentProfileResponseViewModel viewModel);

    void showError(String message);
}
