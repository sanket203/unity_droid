package unity.com.unityapp.unity.com.unityapp.base.view.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.domain.model.ProfileResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.RecentProfileResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.ProfileResponseViewModel;
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
        viewModel.setProfileResponseViewModelList(getListofViewModel(dataModel.getProfileResponseEntities()));

        return viewModel;
    }

    private List<ProfileResponseViewModel> getListofViewModel(List<ProfileResponseDataModel> profileResponseEntities) {

        List<ProfileResponseViewModel> profileResponseViewModels = new ArrayList<>();
        for (ProfileResponseDataModel dataModel : profileResponseEntities

                ) {

            ProfileResponseViewModel viewModel = new ProfileResponseViewModel();
            viewModel.setBirthDate(dataModel.getBirthDate());
            viewModel.setEducation(dataModel.getEducation());
            viewModel.setGender(dataModel.getGender());
            viewModel.setHeight(dataModel.getHeight());
            viewModel.setIncome(dataModel.getIncome());
            viewModel.setName(dataModel.getName());
            profileResponseViewModels.add(viewModel);

        }
        return profileResponseViewModels;
    }
}
