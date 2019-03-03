package unity.com.unityapp.unity.com.unityapp.base.data.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.ExpectationDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.ExpectationDetailsResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.ExpectationsDataModel;

public class ExpectationDetailsResponseEntityToDataModelMapper {

    @Inject
    public ExpectationDetailsResponseEntityToDataModelMapper() {
    }

    public ExpectationDetailsResponseDataModel mapToDataModel(ExpectationDetailsResponseEntity expectationDetailsResponseEntity) {
        ExpectationDetailsResponseDataModel expectationDetailsResponseDataModel = new ExpectationDetailsResponseDataModel();

        expectationDetailsResponseDataModel.setMessage(expectationDetailsResponseEntity.getMessage());
        expectationDetailsResponseDataModel.setStatus(expectationDetailsResponseEntity.getStatus());
        ExpectationsDataModel expectationsDataModel = new ExpectationsDataModel();

        expectationsDataModel.setCandidateId(expectationDetailsResponseEntity.getExpectationsEntity().getCandidateId());
        expectationsDataModel.setMinHeight(expectationDetailsResponseEntity.getExpectationsEntity().getMinHeight());
        expectationsDataModel.setMaxHeight(expectationDetailsResponseEntity.getExpectationsEntity().getMaxHeight());
        expectationsDataModel.setMinAge(expectationDetailsResponseEntity.getExpectationsEntity().getMinAge());
        expectationsDataModel.setMaxAge(expectationDetailsResponseEntity.getExpectationsEntity().getMaxAge());
        expectationsDataModel.setSubCaste(expectationDetailsResponseEntity.getExpectationsEntity().getSubCaste());
        expectationsDataModel.setDegree(expectationDetailsResponseEntity.getExpectationsEntity().getDegree());
        expectationsDataModel.setWorkingLocation(expectationDetailsResponseEntity.getExpectationsEntity().getWorkingLocation());
        expectationsDataModel.setParentsLocation(expectationDetailsResponseEntity.getExpectationsEntity().getParentsLocation());
        expectationsDataModel.setPackageLimit(expectationDetailsResponseEntity.getExpectationsEntity().getPackageLimit());
        expectationsDataModel.setPatrikaMatching(expectationDetailsResponseEntity.getExpectationsEntity().getPatrikaMatching());
        expectationsDataModel.setOther(expectationDetailsResponseEntity.getExpectationsEntity().getOther());
        expectationDetailsResponseDataModel.setExpectationsDataModel(expectationsDataModel);
        return expectationDetailsResponseDataModel;
    }
}
