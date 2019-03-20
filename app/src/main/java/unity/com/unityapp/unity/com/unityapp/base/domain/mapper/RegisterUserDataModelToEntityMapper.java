package unity.com.unityapp.unity.com.unityapp.base.domain.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.request.RegisterUserEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.request.RegisterUserDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.RegisterUserViewModel;

public class RegisterUserDataModelToEntityMapper {

    @Inject
    public RegisterUserDataModelToEntityMapper() {
    }

    public RegisterUserEntity mapToEntity(RegisterUserDataModel dataModel) {
        RegisterUserEntity entity = new RegisterUserEntity();
        entity.setBirthDate(dataModel.getBirthDate());
        entity.setContact(dataModel.getContact());
        entity.setFirstName(dataModel.getFirstName());
        entity.setMiddleName(dataModel.getMiddleName());
        entity.setLastName(dataModel.getLastName());
        entity.setPassword(dataModel.getPassword());
        return entity;
    }
}
