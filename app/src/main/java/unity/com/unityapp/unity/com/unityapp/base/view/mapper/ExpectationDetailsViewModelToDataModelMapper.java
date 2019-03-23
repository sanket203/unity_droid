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
        dataModel.setMinHeight(getMinHeight(expectationDetailsViewModel));
        dataModel.setMaxHeight(getMaxHeight(expectationDetailsViewModel));
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

    private String getMaxHeight(ExpectationsViewModel expectationDetailsViewModel) {
        String height = "";
        height = expectationDetailsViewModel.getMaxFeet() + "\'" + expectationDetailsViewModel.getMaxInch() + "\"";
        return height;
    }

    private String getMinHeight(ExpectationsViewModel expectationDetailsViewModel) {
        String height = "";
        height = expectationDetailsViewModel.getMinFeet() + "\'" + expectationDetailsViewModel.getMinInch() + "\"";
        return height;
    }
}
