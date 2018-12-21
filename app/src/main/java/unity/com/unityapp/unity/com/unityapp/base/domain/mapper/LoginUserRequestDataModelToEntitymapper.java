package unity.com.unityapp.unity.com.unityapp.base.domain.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.request.LoginUserRequestEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.LoginUserRequestDataModel;

/**
 * Created by admin on 20/12/18.
 */

public class LoginUserRequestDataModelToEntitymapper {


    @Inject
    public LoginUserRequestDataModelToEntitymapper() {
    }

    public LoginUserRequestEntity mapToEntity(LoginUserRequestDataModel dataModel) {
        LoginUserRequestEntity entity = new LoginUserRequestEntity();
        entity.setPassword(dataModel.getPassword());
        entity.setPayment(dataModel.getPayment());
        entity.setTransactionId(dataModel.getTransactionId());
        entity.setUserName(dataModel.getUserName());
        return entity;
    }
}
