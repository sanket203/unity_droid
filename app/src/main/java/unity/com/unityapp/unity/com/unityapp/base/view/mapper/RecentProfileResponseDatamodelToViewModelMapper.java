package unity.com.unityapp.unity.com.unityapp.base.view.mapper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
            viewModel.setCandidateId(dataModel.getCandidateID());
            viewModel.setBirthDate(convertDate(dataModel.getBirthDate()));
            viewModel.setEducation(dataModel.getEducation());
            viewModel.setGender(dataModel.getGender());
            viewModel.setHeight(dataModel.getHeight());
            viewModel.setIncome(dataModel.getIncome());
            viewModel.setName(dataModel.getName());
            viewModel.setImageUrl(dataModel.getImageUrl());
            profileResponseViewModels.add(viewModel);

        }
        return profileResponseViewModels;
    }

    String convertDate(String date) {
        String finalDate = "";
        DateFormat df = new SimpleDateFormat("dd-Mm-yyyy");
        Date date1;
        try {
            date1 = df.parse(date);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            finalDate = sdf.format(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return finalDate;
    }
}
