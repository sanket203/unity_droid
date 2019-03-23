package unity.com.unityapp.unity.com.unityapp.base.view.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.FamilyDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.FamilyDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.FamilyDetailsResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.FamilyDetailsViewModel;

public class FamilyDetailsResponseDataModelToViewModelMapper {

    @Inject
    public FamilyDetailsResponseDataModelToViewModelMapper() {
    }

    public FamilyDetailsViewModel mapToViewModel(FamilyDetailsResponseDataModel familyDetailsDataModel) {

        FamilyDetailsViewModel familyDetailsViewModel = new FamilyDetailsViewModel();
        familyDetailsViewModel.setCandidateId(familyDetailsDataModel.getFamilyDetailsDataModel().getCandidateId());
        familyDetailsViewModel.setFather(familyDetailsDataModel.getFamilyDetailsDataModel().getFather());
        familyDetailsViewModel.setFatherDescription(familyDetailsDataModel.getFamilyDetailsDataModel().getFatherDescription());
        familyDetailsViewModel.setMother(familyDetailsDataModel.getFamilyDetailsDataModel().getMother());
        familyDetailsViewModel.setMotherDescription(familyDetailsDataModel.getFamilyDetailsDataModel().getMotherDescription());
        familyDetailsViewModel.setBrothers(familyDetailsDataModel.getFamilyDetailsDataModel().getBrothers());
        familyDetailsViewModel.setBrotherDescription(familyDetailsDataModel.getFamilyDetailsDataModel().getBrotherDescription());
        familyDetailsViewModel.setSisters(familyDetailsDataModel.getFamilyDetailsDataModel().getSisters());
        familyDetailsViewModel.setSisterDescription(familyDetailsDataModel.getFamilyDetailsDataModel().getSisterDescription());
        familyDetailsViewModel.setId(familyDetailsDataModel.getFamilyDetailsDataModel().getId());
        return familyDetailsViewModel;
    }
}
