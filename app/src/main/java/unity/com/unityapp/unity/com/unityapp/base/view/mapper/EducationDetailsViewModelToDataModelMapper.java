package unity.com.unityapp.unity.com.unityapp.base.view.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.domain.model.EducationalDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.EducationalDetailsViewModel;

public class EducationDetailsViewModelToDataModelMapper {

    @Inject
    public EducationDetailsViewModelToDataModelMapper() {
    }

    public EducationalDetailsDataModel mapToDataModel(EducationalDetailsViewModel educationDetailsViewModel) {
        EducationalDetailsDataModel dataModel = new EducationalDetailsDataModel();

        dataModel.setCandidateId(educationDetailsViewModel.getCandidateId());
        dataModel.setCollege(educationDetailsViewModel.getCollege());
        dataModel.setDegree(educationDetailsViewModel.getDegree());
        dataModel.setPassYear(educationDetailsViewModel.getPassYear());
        dataModel.setStream(educationDetailsViewModel.getStream());
        dataModel.setUniversity(educationDetailsViewModel.getUniversity());
        return dataModel;
    }
}
