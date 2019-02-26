package unity.com.unityapp.unity.com.unityapp.base.domain.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.PersonalDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.PersonalDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.PersonalDetailsResponseDataModel;

public class PersonalDetailsResponseEntityToDataModelMapper {

    @Inject
    public PersonalDetailsResponseEntityToDataModelMapper() {
    }

    public PersonalDetailsResponseDataModel mapToDataModel(PersonalDetailsResponseEntity entity) {
        PersonalDetailsResponseDataModel dataModel = new PersonalDetailsResponseDataModel();
        dataModel.setMessage(entity.getMessage());
        dataModel.setStatus(entity.getStatus());
        PersonalDetailsDataModel personalDetailsDataModel = new PersonalDetailsDataModel();
        personalDetailsDataModel.setAboutMe(entity.getPersonalDetailsEntity().getAboutMe());
        personalDetailsDataModel.setBirthDate(entity.getPersonalDetailsEntity().getBirthDate());
        personalDetailsDataModel.setBirthPlace(entity.getPersonalDetailsEntity().getBirthPlace());
        personalDetailsDataModel.setBirthTime(entity.getPersonalDetailsEntity().getBirthTime());
        personalDetailsDataModel.setFirstName(entity.getPersonalDetailsEntity().getFirstName());
        personalDetailsDataModel.setGender(entity.getPersonalDetailsEntity().getGender());
        personalDetailsDataModel.setHobbies(entity.getPersonalDetailsEntity().getHobbies());
        personalDetailsDataModel.setLastName(entity.getPersonalDetailsEntity().getLastName());
        personalDetailsDataModel.setMailId(entity.getPersonalDetailsEntity().getMailId());
        personalDetailsDataModel.setMaritalStatus(entity.getPersonalDetailsEntity().getMaritalStatus());
        personalDetailsDataModel.setMiddleName(entity.getPersonalDetailsEntity().getMiddleName());
        personalDetailsDataModel.setMotherTongue(entity.getPersonalDetailsEntity().getMotherTongue());
        dataModel.setPersonalDetailsDataModel(personalDetailsDataModel);
        return dataModel;
    }
}
