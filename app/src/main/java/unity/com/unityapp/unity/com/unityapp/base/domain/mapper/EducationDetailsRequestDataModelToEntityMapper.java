package unity.com.unityapp.unity.com.unityapp.base.domain.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.EducationDetailsEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.PersonalDetailsEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.EducationalDetailsDataModel;

public class EducationDetailsRequestDataModelToEntityMapper {

    @Inject
    public EducationDetailsRequestDataModelToEntityMapper() {

    }

    public EducationDetailsEntity mapToEntity(EducationalDetailsDataModel educationalDetailsDataModel) {
        EducationDetailsEntity entity = new EducationDetailsEntity();

        entity.setCandidateId(educationalDetailsDataModel.getCandidateId());
        entity.setCollege(educationalDetailsDataModel.getCollege());
        entity.setDegree(educationalDetailsDataModel.getDegree());
        entity.setPassYear(educationalDetailsDataModel.getPassYear());
        entity.setStream(educationalDetailsDataModel.getStream());
        entity.setUniversity(educationalDetailsDataModel.getUniversity());
        entity.setRemarks(educationalDetailsDataModel.getRemarks());
        entity.setId(educationalDetailsDataModel.getId());
        return entity;
    }
}
