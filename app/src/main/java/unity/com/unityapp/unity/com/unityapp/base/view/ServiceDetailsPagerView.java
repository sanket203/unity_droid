package unity.com.unityapp.unity.com.unityapp.base.view;

import unity.com.unityapp.unity.com.unityapp.base.BaseView;
import unity.com.unityapp.unity.com.unityapp.base.view.model.ServiceDetailsViewModel;

public interface ServiceDetailsPagerView extends BaseView {

    void showServiceDetails(ServiceDetailsViewModel viewModel);

    void showProgressBar(boolean isVisible);
}
