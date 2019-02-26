package unity.com.unityapp.unity.com.unityapp.base.data.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.EducationDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.EducationDetailsResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.EducationalDetailsEntity;

public class EducationDetailsResponseEntityToDataModelMapper {

    @Inject
    public EducationDetailsResponseEntityToDataModelMapper() {
    }

    EducationDetailsResponseDataModel mapToDataModel(EducationDetailsResponseEntity educationDetailsResponseEntity) {

        EducationDetailsResponseDataModel educationDetailsResponseDataModel = new EducationDetailsResponseDataModel();
        educationDetailsResponseDataModel.setMessage(educationDetailsResponseEntity.getMessage());
        educationDetailsResponseDataModel.setStatus(educationDetailsResponseEntity.getStatus());
        EducationalDetailsEntity educationalDetailsDataModel = new EducationalDetailsEntity();
        educationalDetailsDataModel.setCandidateId(educationDetailsResponseEntity.getEducationalDetailsEntity().getCandidateId());
        educationalDetailsDataModel.setCollege(educationDetailsResponseEntity.getEducationalDetailsEntity().getCollege());
        educationalDetailsDataModel.setDegree(educationDetailsResponseEntity.getEducationalDetailsEntity().getDegree());
        educationalDetailsDataModel.setPassYear(educationDetailsResponseEntity.getEducationalDetailsEntity().getPassYear());
        educationalDetailsDataModel.setRemarks(educationDetailsResponseEntity.getEducationalDetailsEntity().getRemarks());
        educationalDetailsDataModel.setStream(educationDetailsResponseEntity.getEducationalDetailsEntity().getStream());
        educationalDetailsDataModel.setUniversity(educationDetailsResponseEntity.getEducationalDetailsEntity().getUniversity());
        educationDetailsResponseDataModel.setEducationalDetailsDataModel(educationalDetailsDataModel);
        return educationDetailsResponseDataModel;
    }
}
