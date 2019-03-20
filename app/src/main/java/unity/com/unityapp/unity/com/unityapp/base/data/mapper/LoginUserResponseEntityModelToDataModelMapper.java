package unity.com.unityapp.unity.com.unityapp.base.data.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.LoginUserResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.UserResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.LoginUserResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.UserResponseDataModel;

/**
 * Created by admin on 20/12/18.
 */

public class LoginUserResponseEntityModelToDataModelMapper {


    @Inject
    public LoginUserResponseEntityModelToDataModelMapper() {
    }

    public LoginUserResponseDataModel mapToEntity(LoginUserResponseEntity entity) {
        LoginUserResponseDataModel dataModel = new LoginUserResponseDataModel();
        dataModel.setStatus(entity.getStatus());
        dataModel.setMessage(entity.getMessage());
        dataModel.setUserResponseDataModel(setUSerResponseDataModel(entity.getUserResponseEntity()));
        return dataModel;
    }

    public UserResponseDataModel setUSerResponseDataModel(UserResponseEntity entity) {
        UserResponseDataModel userResponseDataModel = new UserResponseDataModel();

        if (entity != null) {

            userResponseDataModel.setAddressCount(entity.getAddressCount());
            userResponseDataModel.setBirthDate(entity.getBirthDate());
            userResponseDataModel.setCandidateId(entity.getCandidateId());
            userResponseDataModel.setGender(entity.getGender());
            userResponseDataModel.setEducation(entity.getEducation());
            userResponseDataModel.setHeight(entity.getHeight());
            userResponseDataModel.setIncome(entity.getIncome());
            userResponseDataModel.setLastLogin(entity.getLastLogin());
            userResponseDataModel.setName(entity.getName());
            userResponseDataModel.setPayment(entity.getPayment());
            userResponseDataModel.setStatus(entity.getStatus());
            userResponseDataModel.setTransactionId(entity.getTransactionId());
            userResponseDataModel.setRegistered(entity.isRegistered());
        }
        return userResponseDataModel;

    }
}
