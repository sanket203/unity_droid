package unity.com.unityapp.unity.com.unityapp.base.domain.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.ExpectationsEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.FamilyDetailsEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.ExpectationsDataModel;

public class ExpectationDetailsRequestDataModelToEntityMapper {


    @Inject
    public ExpectationDetailsRequestDataModelToEntityMapper() {
    }

    public ExpectationsEntity mapToEntity(ExpectationsDataModel expectationsDataModel) {
        ExpectationsEntity entity = new ExpectationsEntity();

        entity.setCandidateId(expectationsDataModel.getCandidateId());
        entity.setMinHeight(expectationsDataModel.getMinHeight());
        entity.setMaxHeight(expectationsDataModel.getMaxHeight());
        entity.setMinAge(expectationsDataModel.getMinAge());
        entity.setMaxAge(expectationsDataModel.getMaxAge());
        entity.setSubCaste(expectationsDataModel.getSubCaste());
        entity.setDegree(expectationsDataModel.getDegree());
        entity.setWorkingLocation(expectationsDataModel.getWorkingLocation());
        entity.setParentsLocation(expectationsDataModel.getParentsLocation());
        entity.setPackageLimit(expectationsDataModel.getPackageLimit());
        entity.setPatrikaMatching(expectationsDataModel.getPatrikaMatching());
        entity.setOther(expectationsDataModel.getOther());
        return entity;
    }
}
