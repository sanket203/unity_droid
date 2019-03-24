package unity.com.unityapp.unity.com.unityapp.base.view.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.ExpectationDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.ExpectationDetailsResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.ExpectationsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.ExpectationsViewModel;

public class ExpectationDetailsDataModelToViewModelMapper {

    @Inject
    public ExpectationDetailsDataModelToViewModelMapper() {
    }

    public ExpectationsViewModel mapToViewModel(ExpectationDetailsResponseDataModel expectationDetailsResponseEntity) {

        ExpectationsViewModel expectationsViewModel = new ExpectationsViewModel();

        expectationsViewModel.setCandidateId(expectationDetailsResponseEntity.getExpectationsDataModel().getCandidateId());
        expectationsViewModel.setMaxHeight(expectationDetailsResponseEntity.getExpectationsDataModel().getMaxHeight());
        expectationsViewModel.setMinHeight(expectationDetailsResponseEntity.getExpectationsDataModel().getMinHeight());
        expectationsViewModel.setMinAge(expectationDetailsResponseEntity.getExpectationsDataModel().getMinAge());
        expectationsViewModel.setMaxAge(expectationDetailsResponseEntity.getExpectationsDataModel().getMaxAge());
        expectationsViewModel.setSubCaste(expectationDetailsResponseEntity.getExpectationsDataModel().getSubCaste());
        expectationsViewModel.setDegree(expectationDetailsResponseEntity.getExpectationsDataModel().getDegree());
        expectationsViewModel.setWorkingLocation(expectationDetailsResponseEntity.getExpectationsDataModel().getWorkingLocation());
        expectationsViewModel.setParentsLocation(expectationDetailsResponseEntity.getExpectationsDataModel().getParentsLocation());
        expectationsViewModel.setPackageLimit(expectationDetailsResponseEntity.getExpectationsDataModel().getPackageLimit());
        expectationsViewModel.setPatrikaMatching(expectationDetailsResponseEntity.getExpectationsDataModel().getPatrikaMatching());
        expectationsViewModel.setOther(expectationDetailsResponseEntity.getExpectationsDataModel().getOther());
        expectationsViewModel.setId(expectationDetailsResponseEntity.getExpectationsDataModel().getId());
        expectationsViewModel.setMaxFeet(getMaxFeet(expectationDetailsResponseEntity.getExpectationsDataModel()));
        expectationsViewModel.setMaxInch(getMaxInches(expectationDetailsResponseEntity.getExpectationsDataModel()));
        expectationsViewModel.setMinFeet(getMinFeet(expectationDetailsResponseEntity.getExpectationsDataModel()));
        expectationsViewModel.setMinInch(getMinInches(expectationDetailsResponseEntity.getExpectationsDataModel()));
        return expectationsViewModel;
    }

    private String getMaxFeet(ExpectationsDataModel expectationsDataModel) {
        String height = "";
        if (expectationsDataModel.getMaxHeight() != null)
            height = expectationsDataModel.getMaxHeight().split("\'")[0];
        return height;
    }

    private String getMaxInches(ExpectationsDataModel expectationsDataModel) {
        String height = "";
        if (expectationsDataModel.getMaxHeight() != null)
            height = expectationsDataModel.getMaxHeight().split("\'")[1].split("\"")[0];
        return height;
    }

    private String getMinFeet(ExpectationsDataModel expectationsDataModel) {
        String height = "";
        if (expectationsDataModel.getMinHeight() != null)
            height = expectationsDataModel.getMinHeight().split("\'")[0];
        return height;
    }

    private String getMinInches(ExpectationsDataModel expectationsDataModel) {
        String height = "";
        if (expectationsDataModel.getMinHeight() != null)
            height = expectationsDataModel.getMinHeight().split("\'")[1].split("\"")[0];
        return height;
    }
}
