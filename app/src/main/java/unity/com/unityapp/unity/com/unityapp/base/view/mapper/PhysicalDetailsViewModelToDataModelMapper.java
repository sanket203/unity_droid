package unity.com.unityapp.unity.com.unityapp.base.view.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.domain.model.PhysicalDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PhysicalDetailsViewModel;

public class PhysicalDetailsViewModelToDataModelMapper {

    @Inject
    public PhysicalDetailsViewModelToDataModelMapper() {
    }

    public PhysicalDetailsDataModel mapToDataModel(PhysicalDetailsViewModel physicalDetailsViewModel) {
        PhysicalDetailsDataModel physicalDetailsDataModel = new PhysicalDetailsDataModel();
        physicalDetailsDataModel.setCandidateId(physicalDetailsViewModel.getCandidateId());
        physicalDetailsDataModel.setHeight(physicalDetailsViewModel.getHeight());
        physicalDetailsDataModel.setWeight(physicalDetailsViewModel.getWeight());
        physicalDetailsDataModel.setComplexion(physicalDetailsViewModel.getComplexion());
        physicalDetailsDataModel.setBodyfom(physicalDetailsViewModel.getBodyform());
        physicalDetailsDataModel.setSpects(physicalDetailsViewModel.getSpects());
        physicalDetailsDataModel.setBloodGroup(physicalDetailsViewModel.getBloodGroup());
        physicalDetailsDataModel.setMedicalSurgary(physicalDetailsViewModel.getMedicalSurgary());
        physicalDetailsDataModel.setDisability(physicalDetailsViewModel.getDisability());
        physicalDetailsDataModel.setOtherRemarks(physicalDetailsViewModel.getOtherRemarks());
        return physicalDetailsDataModel;
    }
}
