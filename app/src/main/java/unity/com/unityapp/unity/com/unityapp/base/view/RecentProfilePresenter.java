package unity.com.unityapp.unity.com.unityapp.base.view;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.RecentProfilesUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.RecentProfileResponseDatamodelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.RecentProfileResponseViewModel;

/**
 * Created by admin on 11/12/18.
 */

public class RecentProfilePresenter extends BasePresenter<RecentProfileView> {

    private final RecentProfilesUseCase recentProfilesUseCase;
    private final RecentProfileResponseDatamodelToViewModelMapper recentProfileResponseDatamodelToViewModelMapper;

    @Inject
    public RecentProfilePresenter(RecentProfilesUseCase recentProfilesUseCase, RecentProfileResponseDatamodelToViewModelMapper recentProfileResponseDatamodelToViewModelMapper) {
        this.recentProfilesUseCase = recentProfilesUseCase;
        this.recentProfileResponseDatamodelToViewModelMapper = recentProfileResponseDatamodelToViewModelMapper;
    }

    void getRecentProfiles(int pageId) {
        recentProfilesUseCase.execute(String.valueOf(pageId))
                .compose(bindToLifecycle()).subscribe(dataModel -> {
                    if (view != null) {
                        if (dataModel.getStatus().equals(Constants.STATUS_200)) {
                            RecentProfileResponseViewModel responseViewModel = recentProfileResponseDatamodelToViewModelMapper.mapToViewModel(dataModel);
                            view.showRecentProfiles(responseViewModel);
                        } else {
                            view.showError(dataModel.getMessage());
                        }

                    }
                }, error -> {
                    if (view != null) {
                        view.showError(error.getMessage());
                    }
                }

        );
    }
}
