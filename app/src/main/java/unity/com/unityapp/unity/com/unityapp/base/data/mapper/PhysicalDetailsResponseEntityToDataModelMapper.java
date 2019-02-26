package unity.com.unityapp.unity.com.unityapp.base.data.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.PhysicalDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.PhysicalDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.PhysicalDetailsResponseDataModel;

public class PhysicalDetailsResponseEntityToDataModelMapper {

    @Inject
    public PhysicalDetailsResponseEntityToDataModelMapper() {
    }

    public PhysicalDetailsResponseDataModel mapToDataModel(PhysicalDetailsResponseEntity physicalDetailsResponseEntity) {

        PhysicalDetailsResponseDataModel physicalDetailsResponseDataModel = new PhysicalDetailsResponseDataModel();

        physicalDetailsResponseDataModel.setMessage(physicalDetailsResponseEntity.getMessage());
        physicalDetailsResponseDataModel.setStatus(physicalDetailsResponseEntity.getStatus());
        PhysicalDetailsDataModel physicalDetailsDataModel = new PhysicalDetailsDataModel();
        physicalDetailsDataModel.setCandidateId(physicalDetailsResponseEntity.getPhysicalDetailsEntity().getCandidateId());
        physicalDetailsDataModel.setHeight(physicalDetailsResponseEntity.getPhysicalDetailsEntity().getHeight());
        physicalDetailsDataModel.setWeight(physicalDetailsResponseEntity.getPhysicalDetailsEntity().getWeight());
        physicalDetailsDataModel.setComplexion(physicalDetailsResponseEntity.getPhysicalDetailsEntity().getComplexion());
        physicalDetailsDataModel.setBodyfom(physicalDetailsResponseEntity.getPhysicalDetailsEntity().getBodyform());
        physicalDetailsDataModel.setSpects(physicalDetailsResponseEntity.getPhysicalDetailsEntity().getSpects());
        physicalDetailsDataModel.setBloodGroup(physicalDetailsResponseEntity.getPhysicalDetailsEntity().getBloodGroup());
        physicalDetailsDataModel.setMedicalSurgary(physicalDetailsResponseEntity.getPhysicalDetailsEntity().getMedicalSurgary());
        physicalDetailsDataModel.setDisability(physicalDetailsResponseEntity.getPhysicalDetailsEntity().getDisability());
        physicalDetailsDataModel.setOtherRemarks(physicalDetailsResponseEntity.getPhysicalDetailsEntity().getOtherRemarks());

        return physicalDetailsResponseDataModel;
    }
}
