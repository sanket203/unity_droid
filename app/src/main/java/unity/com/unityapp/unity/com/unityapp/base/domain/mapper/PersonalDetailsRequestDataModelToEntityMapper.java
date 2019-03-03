package unity.com.unityapp.unity.com.unityapp.base.domain.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.PersonalDetailsEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.PersonalDetailsDataModel;

public class PersonalDetailsRequestDataModelToEntityMapper {

    @Inject

    public PersonalDetailsRequestDataModelToEntityMapper() {
    }

    public PersonalDetailsEntity mapToEntity(PersonalDetailsDataModel personalDetailsDataModel) {
        PersonalDetailsEntity personalDetailsEntity = new PersonalDetailsEntity();
        personalDetailsEntity.setAboutMe(personalDetailsDataModel.getAboutMe());
        personalDetailsEntity.setBirthDate(personalDetailsDataModel.getBirthDate());
        personalDetailsEntity.setBirthPlace(personalDetailsDataModel.getBirthPlace());
        personalDetailsEntity.setBirthTime(personalDetailsDataModel.getBirthTime());
        personalDetailsEntity.setCandidateId(personalDetailsDataModel.getCandidateId());
        personalDetailsEntity.setFirstName(personalDetailsDataModel.getFirstName());
        personalDetailsEntity.setMiddleName(personalDetailsDataModel.getMiddleName());
        personalDetailsEntity.setLastName(personalDetailsDataModel.getLastName());
        personalDetailsEntity.setGender(personalDetailsDataModel.getGender());
        personalDetailsEntity.setMaritalStatus(personalDetailsDataModel.getMaritalStatus());
        return personalDetailsEntity;
    }
}
