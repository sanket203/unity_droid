package unity.com.unityapp.unity.com.unityapp.base.view.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.PhysicalDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.PhysicalDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.PhysicalDetailsResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PhysicalDetailsViewModel;

public class PhysicalDetailsDataModelToViewModelMapper {

    @Inject
    public PhysicalDetailsDataModelToViewModelMapper() {
    }

    public PhysicalDetailsViewModel mapToViewModel(PhysicalDetailsResponseDataModel physicalDetailsResponseDataModel) {

        PhysicalDetailsViewModel physicalDetailsViewModel = new PhysicalDetailsViewModel();
        physicalDetailsViewModel.setCandidateId(physicalDetailsResponseDataModel.getPhysicalDetailsDataModel().getCandidateId());
        physicalDetailsViewModel.setHeight(physicalDetailsResponseDataModel.getPhysicalDetailsDataModel().getHeight());
        physicalDetailsViewModel.setWeight(physicalDetailsResponseDataModel.getPhysicalDetailsDataModel().getWeight());
        physicalDetailsViewModel.setComplexion(physicalDetailsResponseDataModel.getPhysicalDetailsDataModel().getComplexion());
        physicalDetailsViewModel.setBodyfom(physicalDetailsResponseDataModel.getPhysicalDetailsDataModel().getBodyform());
        physicalDetailsViewModel.setSpects(physicalDetailsResponseDataModel.getPhysicalDetailsDataModel().getSpects());
        physicalDetailsViewModel.setBloodGroup(physicalDetailsResponseDataModel.getPhysicalDetailsDataModel().getBloodGroup());
        physicalDetailsViewModel.setMedicalSurgary(physicalDetailsResponseDataModel.getPhysicalDetailsDataModel().getMedicalSurgary());
        physicalDetailsViewModel.setDisability(physicalDetailsResponseDataModel.getPhysicalDetailsDataModel().getDisability());
        physicalDetailsViewModel.setOtherRemarks(physicalDetailsResponseDataModel.getPhysicalDetailsDataModel().getOtherRemarks());
        physicalDetailsViewModel.setId(physicalDetailsResponseDataModel.getPhysicalDetailsDataModel().getId());

        return physicalDetailsViewModel;
    }
}
