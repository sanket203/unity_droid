package unity.com.unityapp.unity.com.unityapp.base.data.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.DietDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.DietDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.DietDetailsResponseDataModel;

public class DietDetailsResponseEntityToDataModelMapper {
    @Inject
    public DietDetailsResponseEntityToDataModelMapper() {
    }

    public DietDetailsResponseDataModel mapToDataModel(DietDetailsResponseEntity dietDetailsResponseEntity) {
        DietDetailsResponseDataModel dietDetailsResponseDataModel = new DietDetailsResponseDataModel();
        dietDetailsResponseDataModel.setMessage(dietDetailsResponseEntity.getMessage());
        dietDetailsResponseDataModel.setStatus(dietDetailsResponseEntity.getStatus());
        DietDetailsDataModel dietDetailsDataModel = new DietDetailsDataModel();
        if (dietDetailsResponseEntity.getDietDetailsEntity() != null) {
            dietDetailsDataModel.setCandidateId(dietDetailsResponseEntity.getDietDetailsEntity().getCandidateId());
            dietDetailsDataModel.setDietType(dietDetailsResponseEntity.getDietDetailsEntity().getDietType());
            dietDetailsDataModel.setDrink(dietDetailsResponseEntity.getDietDetailsEntity().getDrink());
            dietDetailsDataModel.setSmoke(dietDetailsResponseEntity.getDietDetailsEntity().getSmoke());
            dietDetailsDataModel.setId(dietDetailsResponseEntity.getDietDetailsEntity().getId());
        }
        dietDetailsResponseDataModel.setDietDetailsDataModel(dietDetailsDataModel);


        return dietDetailsResponseDataModel;
    }
}
