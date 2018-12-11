package unity.com.unityapp.unity.com.unityapp.base.view;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.RecentProfilesUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.RecentProfileResponseDatamodelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.RecentRequestViewModelToDataModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.RecentProfileRequestViewModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.RecentProfileResponseViewModel;

/**
 * Created by admin on 11/12/18.
 */

public class RecentProfilePresenter extends BasePresenter<RecentProfileView> {

    private final RecentProfilesUseCase recentProfilesUseCase;
    private final RecentRequestViewModelToDataModelMapper recentRequestViewModelToDataModelMapper;
    private final RecentProfileResponseDatamodelToViewModelMapper recentProfileResponseDatamodelToViewModelMapper;

    @Inject
    public RecentProfilePresenter(RecentProfilesUseCase recentProfilesUseCase, RecentRequestViewModelToDataModelMapper recentRequestViewModelToDataModelMapper, RecentProfileResponseDatamodelToViewModelMapper recentProfileResponseDatamodelToViewModelMapper) {
        this.recentProfilesUseCase = recentProfilesUseCase;
        this.recentRequestViewModelToDataModelMapper = recentRequestViewModelToDataModelMapper;
        this.recentProfileResponseDatamodelToViewModelMapper = recentProfileResponseDatamodelToViewModelMapper;
    }

    void getRecentProfiles(RecentProfileRequestViewModel viewModel) {
        recentProfilesUseCase.execute(recentRequestViewModelToDataModelMapper.mapToDataModel(viewModel))
                .compose(bindToLifecycle()).subscribe(dataModel -> {
            if (view != null) {
                RecentProfileResponseViewModel responseViewModel = recentProfileResponseDatamodelToViewModelMapper.mapToViewModel(dataModel);
            }
        });
    }
}
