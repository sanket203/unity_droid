package unity.com.unityapp.unity.com.unityapp.base.view.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.domain.model.FamilyDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.FamilyDetailsViewModel;

public class FamilyDetailsViewModelToDataModelMapper {

    @Inject
    public FamilyDetailsViewModelToDataModelMapper() {
    }

    public FamilyDetailsDataModel mapToDataModel(FamilyDetailsViewModel familyDetailsViewModel) {
        FamilyDetailsDataModel dataModel = new FamilyDetailsDataModel();
        dataModel.setCandidateId(familyDetailsViewModel.getCandidateId());
        dataModel.setFather(familyDetailsViewModel.getFather());
        dataModel.setFatherDescription(familyDetailsViewModel.getFatherDescription());
        dataModel.setMother(familyDetailsViewModel.getMother());
        dataModel.setMotherDescription(familyDetailsViewModel.getMotherDescription());
        dataModel.setBrothers(familyDetailsViewModel.getBrothers());
        dataModel.setBrotherDescription(familyDetailsViewModel.getBrotherDescription());
        dataModel.setSisters(familyDetailsViewModel.getSisters());
        dataModel.setSisterDescription(familyDetailsViewModel.getSisterDescription());
        dataModel.setId(familyDetailsViewModel.getId());
        return dataModel;
    }
}
