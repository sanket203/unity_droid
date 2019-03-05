package unity.com.unityapp.unity.com.unityapp.base.domain.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.DietDetailsEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.FamilyDetailsEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.FamilyDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.FamilyDetailsViewModel;

public class FamilyDetailsRequestDataModelToEntityMapper {

    @Inject
    public FamilyDetailsRequestDataModelToEntityMapper() {
    }

    public FamilyDetailsEntity mapToEntity(FamilyDetailsDataModel familyDetailsDataModel) {
        FamilyDetailsEntity entity = new FamilyDetailsEntity();
        entity.setCandidateId(familyDetailsDataModel.getCandidateId());
        entity.setFather(familyDetailsDataModel.getFather());
        entity.setFatherDescription(familyDetailsDataModel.getFatherDescription());
        entity.setMother(familyDetailsDataModel.getMother());
        entity.setMotherDescription(familyDetailsDataModel.getMotherDescription());
        entity.setBrothers(familyDetailsDataModel.getBrothers());
        entity.setBrotherDescription(familyDetailsDataModel.getBrotherDescription());
        entity.setSisters(familyDetailsDataModel.getSisters());
        entity.setSisterDescription(familyDetailsDataModel.getSisterDescription());
        return entity;
    }
}
