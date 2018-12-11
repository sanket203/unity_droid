package unity.com.unityapp.unity.com.unityapp.base.view.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.domain.model.RecentProfileRequestDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.RecentProfileRequestViewModel;

/**
 * Created by admin on 11/12/18.
 */

public class RecentRequestViewModelToDataModelMapper {

    @Inject

    public RecentRequestViewModelToDataModelMapper() {
    }

    public RecentProfileRequestDataModel mapToDataModel(RecentProfileRequestViewModel viewModel) {
        RecentProfileRequestDataModel dataModel = new RecentProfileRequestDataModel();
        return dataModel;
    }

}
