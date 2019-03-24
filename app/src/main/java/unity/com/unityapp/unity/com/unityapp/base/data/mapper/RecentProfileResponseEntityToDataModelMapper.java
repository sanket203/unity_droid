package unity.com.unityapp.unity.com.unityapp.base.data.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.ProfileResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.RecentProfileResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.ProfileResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.RecentProfileResponseDataModel;

/**
 * Created by admin on 11/12/18.
 */

public class RecentProfileResponseEntityToDataModelMapper {

    @Inject
    public RecentProfileResponseEntityToDataModelMapper() {

    }

    public RecentProfileResponseDataModel mapToDataModel(RecentProfileResponseEntity entity) {
        RecentProfileResponseDataModel dataModel = new RecentProfileResponseDataModel();
        dataModel.setMessage(entity.getMessage());
        dataModel.setProfileResponseEntities(getListProfileResponse(entity.getProfileResponseEntities()));
        dataModel.setStatus(entity.getStatus());
        return dataModel;
    }

    private List<ProfileResponseDataModel> getListProfileResponse(List<ProfileResponseEntity> entities) {
        List<ProfileResponseDataModel> profileResponseDataModelList = new ArrayList<>();
        if (entities != null) {
            for (ProfileResponseEntity entity : entities
            ) {
                ProfileResponseDataModel dataModel = new ProfileResponseDataModel();
                dataModel.setAddressCount(entity.getAddressCount());
                dataModel.setBirthDate(entity.getBirthDate());
                dataModel.setCandidateID(entity.getCandidateID());
                dataModel.setId(entity.getId());
                dataModel.setEducation(entity.getEducation());
                dataModel.setGender(entity.getGender());
                dataModel.setHeight(entity.getHeight());
                dataModel.setIncome(entity.getIncome());
                dataModel.setLastLogin(entity.getLastLogin());
                dataModel.setName(entity.getName());
                dataModel.setImageUrl(entity.getImageUrl());
                profileResponseDataModelList.add(dataModel);

            }
        }
        return profileResponseDataModelList;
    }


}
