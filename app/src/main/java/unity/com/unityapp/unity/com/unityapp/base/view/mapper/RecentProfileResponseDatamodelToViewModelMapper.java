package unity.com.unityapp.unity.com.unityapp.base.view.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.domain.model.RecentProfileResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.RecentProfileResponseViewModel;

/**
 * Created by admin on 11/12/18.
 */

public class RecentProfileResponseDatamodelToViewModelMapper {

    @Inject
    public RecentProfileResponseDatamodelToViewModelMapper() {
    }

    public RecentProfileResponseViewModel mapToViewModel(RecentProfileResponseDataModel dataModel) {
        RecentProfileResponseViewModel viewModel = new RecentProfileResponseViewModel();
        return viewModel;
    }
}
