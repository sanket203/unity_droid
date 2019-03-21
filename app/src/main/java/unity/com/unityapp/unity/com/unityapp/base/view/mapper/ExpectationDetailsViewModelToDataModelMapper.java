package unity.com.unityapp.unity.com.unityapp.base.view.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.domain.model.ExpectationsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.ExpectationsViewModel;

public class ExpectationDetailsViewModelToDataModelMapper {

    @Inject
    public ExpectationDetailsViewModelToDataModelMapper() {
    }

    public ExpectationsDataModel mapToDataModel(ExpectationsViewModel expectationDetailsViewModel) {
        ExpectationsDataModel dataModel = new ExpectationsDataModel();

        dataModel.setCandidateId(expectationDetailsViewModel.getCandidateId());
        dataModel.setMinHeight(expectationDetailsViewModel.getMinHeight());
        dataModel.setMaxHeight(expectationDetailsViewModel.getMaxHeight());
        dataModel.setMinAge(expectationDetailsViewModel.getMinAge());
        dataModel.setMaxAge(expectationDetailsViewModel.getMaxAge());
        dataModel.setSubCaste(expectationDetailsViewModel.getSubCaste());
        dataModel.setDegree(expectationDetailsViewModel.getDegree());
        dataModel.setWorkingLocation(expectationDetailsViewModel.getWorkingLocation());
        dataModel.setParentsLocation(expectationDetailsViewModel.getParentsLocation());
        dataModel.setPackageLimit(expectationDetailsViewModel.getPackageLimit());
        dataModel.setPatrikaMatching(expectationDetailsViewModel.getPatrikaMatching());
        dataModel.setOther(expectationDetailsViewModel.getOther());
        dataModel.setId(expectationDetailsViewModel.getId());
        return dataModel;
    }
}
