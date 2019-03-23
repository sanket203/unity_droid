package unity.com.unityapp.unity.com.unityapp.base.data.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.FamilyDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.FamilyDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.FamilyDetailsResponseDataModel;

public class FamilyDetailsResponseEntityToDataModelMapper {

    @Inject
    public FamilyDetailsResponseEntityToDataModelMapper() {
    }

    public FamilyDetailsResponseDataModel mapToDataModel(FamilyDetailsResponseEntity familyDetailsResponseEntity) {

        FamilyDetailsResponseDataModel familyDetailsResponseDataModel = new FamilyDetailsResponseDataModel();
        familyDetailsResponseDataModel.setMessage(familyDetailsResponseEntity.getMessage());
        familyDetailsResponseDataModel.setStatus(familyDetailsResponseEntity.getStatus());
        FamilyDetailsDataModel familyDetailsDataModel = new FamilyDetailsDataModel();
        if (familyDetailsResponseEntity.getFamilyDetailsEntity() != null) {
            familyDetailsDataModel.setCandidateId(familyDetailsResponseEntity.getFamilyDetailsEntity().getCandidateId());
            familyDetailsDataModel.setFather(familyDetailsResponseEntity.getFamilyDetailsEntity().getFather());
            familyDetailsDataModel.setFatherDescription(familyDetailsResponseEntity.getFamilyDetailsEntity().getFatherDescription());
            familyDetailsDataModel.setMother(familyDetailsResponseEntity.getFamilyDetailsEntity().getMother());
            familyDetailsDataModel.setMotherDescription(familyDetailsResponseEntity.getFamilyDetailsEntity().getMotherDescription());
            familyDetailsDataModel.setBrothers(familyDetailsResponseEntity.getFamilyDetailsEntity().getBrothers());
            familyDetailsDataModel.setBrotherDescription(familyDetailsResponseEntity.getFamilyDetailsEntity().getBrotherDescription());
            familyDetailsDataModel.setSisters(familyDetailsResponseEntity.getFamilyDetailsEntity().getSisters());
            familyDetailsDataModel.setSisterDescription(familyDetailsResponseEntity.getFamilyDetailsEntity().getSisterDescription());
            familyDetailsDataModel.setId(familyDetailsResponseEntity.getFamilyDetailsEntity().getId());
        }
        familyDetailsResponseDataModel.setFamilyDetailsDataModel(familyDetailsDataModel);

        return familyDetailsResponseDataModel;
    }
}
