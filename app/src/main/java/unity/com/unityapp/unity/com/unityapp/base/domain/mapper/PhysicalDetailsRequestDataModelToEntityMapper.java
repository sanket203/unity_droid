package unity.com.unityapp.unity.com.unityapp.base.domain.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.PhysicalDetailsEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.PhysicalDetailsDataModel;

public class PhysicalDetailsRequestDataModelToEntityMapper {
    @Inject

    public PhysicalDetailsRequestDataModelToEntityMapper() {
    }

    public PhysicalDetailsEntity mapToEntity(PhysicalDetailsDataModel physicalDetailsDataModel) {
        PhysicalDetailsEntity entity = new PhysicalDetailsEntity();
        entity.setCandidateId(physicalDetailsDataModel.getCandidateId());
        entity.setHeight(physicalDetailsDataModel.getHeight());
        entity.setWeight(physicalDetailsDataModel.getWeight());
        entity.setComplexion(physicalDetailsDataModel.getComplexion());
        entity.setBodyfom(physicalDetailsDataModel.getBodyform());
        entity.setSpects(physicalDetailsDataModel.getSpects());
        entity.setBloodGroup(physicalDetailsDataModel.getBloodGroup());
        entity.setMedicalSurgary(physicalDetailsDataModel.getMedicalSurgary());
        entity.setDisability(physicalDetailsDataModel.getDisability());
        entity.setOtherRemarks(physicalDetailsDataModel.getOtherRemarks());

        return entity;
    }
}
