package unity.com.unityapp.unity.com.unityapp.base.view;

import unity.com.unityapp.unity.com.unityapp.base.BaseView;
import unity.com.unityapp.unity.com.unityapp.base.view.model.RecentProfileResponseViewModel;

/**
 * Created by admin on 11/12/18.
 */

public interface AddressTakenView extends BaseView {
    void showAddresstakenProfiles(RecentProfileResponseViewModel responseViewModel);

    void showError(String message);
}
