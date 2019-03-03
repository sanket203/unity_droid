package unity.com.unityapp.unity.com.unityapp.base.view.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.domain.model.DietDetailsResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.EducationDetailsResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.DietDetailsViewModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.EducationalDetailsViewModel;

public class EducationDetailsDataModelToViewModelMapper {

    @Inject
    public EducationDetailsDataModelToViewModelMapper() {
    }

    public EducationalDetailsViewModel mapToViewModel(EducationDetailsResponseDataModel dataModel) {
        EducationalDetailsViewModel viewModel = new EducationalDetailsViewModel();

        viewModel.setCandidateId(dataModel.getEducationalDetailsDataModel().getCandidateId());
        viewModel.setCollege(dataModel.getEducationalDetailsDataModel().getCollege());
        viewModel.setDegree(dataModel.getEducationalDetailsDataModel().getDegree());
        viewModel.setPassYear(dataModel.getEducationalDetailsDataModel().getPassYear());
        viewModel.setStream(dataModel.getEducationalDetailsDataModel().getStream());
        viewModel.setUniversity(dataModel.getEducationalDetailsDataModel().getUniversity());
        return viewModel;
    }
}
