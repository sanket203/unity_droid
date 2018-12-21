package unity.com.unityapp.unity.com.unityapp.base.view;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.BasePresenter;
import unity.com.unityapp.unity.com.unityapp.base.Constants;
import unity.com.unityapp.unity.com.unityapp.base.UserInfo;
import unity.com.unityapp.unity.com.unityapp.base.domain.usecase.AddressTakenProfilesUseCase;
import unity.com.unityapp.unity.com.unityapp.base.view.mapper.RecentProfileResponseDatamodelToViewModelMapper;
import unity.com.unityapp.unity.com.unityapp.base.view.model.RecentProfileResponseViewModel;

/**
 * Created by admin on 11/12/18.
 */

public class AddressTakenPresenter extends BasePresenter<AddressTakenView> {

    private final AddressTakenProfilesUseCase useCase;
    private final RecentProfileResponseDatamodelToViewModelMapper recentProfileResponseDatamodelToViewModelMapper;

    @Inject
    public AddressTakenPresenter(AddressTakenProfilesUseCase useCase, RecentProfileResponseDatamodelToViewModelMapper recentProfileResponseDatamodelToViewModelMapper) {
        this.useCase = useCase;
        this.recentProfileResponseDatamodelToViewModelMapper = recentProfileResponseDatamodelToViewModelMapper;
    }

    public void getAddresstakenProfiles(int pageNumber) {
        useCase.execute(String.valueOf(UserInfo.getUserInfo().getCandidateId()), String.valueOf(pageNumber))
                .compose(bindToLifecycle()).subscribe(dataModel -> {
                    if (view != null) {
                        if (dataModel.getStatus().equals(Constants.STATUS_200)) {
                            RecentProfileResponseViewModel responseViewModel = recentProfileResponseDatamodelToViewModelMapper.mapToViewModel(dataModel);
                            view.showAddresstakenProfiles(responseViewModel);
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


