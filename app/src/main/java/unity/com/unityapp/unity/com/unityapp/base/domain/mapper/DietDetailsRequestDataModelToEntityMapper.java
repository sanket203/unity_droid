package unity.com.unityapp.unity.com.unityapp.base.domain.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.DietDetailsEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.DietDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.PersonalDetailsEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.DietDetailsDataModel;

public class DietDetailsRequestDataModelToEntityMapper {

    @Inject
    public DietDetailsRequestDataModelToEntityMapper() {
    }

    public DietDetailsEntity mapToEntity(DietDetailsDataModel dietDetailsDataModel) {
        DietDetailsEntity entity = new DietDetailsEntity();

        entity.setCandidateId(dietDetailsDataModel.getCandidateId());
        entity.setDietType(dietDetailsDataModel.getDietType());
        entity.setDrink(dietDetailsDataModel.getDrink());
        entity.setSmoke(dietDetailsDataModel.getSmoke());
        entity.setId(dietDetailsDataModel.getId());
        return entity;
    }
}
