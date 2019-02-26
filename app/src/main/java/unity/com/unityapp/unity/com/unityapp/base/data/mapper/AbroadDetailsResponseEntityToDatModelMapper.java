package unity.com.unityapp.unity.com.unityapp.base.data.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.AbroadDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.AbroadDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.AbroadDetailsResponseDataModel;

public class AbroadDetailsResponseEntityToDatModelMapper {
    @Inject
    public AbroadDetailsResponseEntityToDatModelMapper() {


    }

    public AbroadDetailsResponseDataModel mapToDataModel(AbroadDetailsResponseEntity abroadDetailsResponseEntity) {
        AbroadDetailsResponseDataModel abroadDetailsResponseDataModel = new AbroadDetailsResponseDataModel();
        abroadDetailsResponseDataModel.setMessage(abroadDetailsResponseEntity.getMessage());
        abroadDetailsResponseDataModel.setStatus(abroadDetailsResponseDataModel.getStatus());
        AbroadDetailsDataModel abroadDetailsDataModel = new AbroadDetailsDataModel();
        abroadDetailsDataModel.setCandidateId(abroadDetailsResponseEntity.getAbroadDetailsEntity().getCandidateId());
        abroadDetailsDataModel.setCitizenship(abroadDetailsResponseEntity.getAbroadDetailsEntity().getCitizenship());
        abroadDetailsDataModel.setCountry(abroadDetailsResponseEntity.getAbroadDetailsEntity().getCountry());
        abroadDetailsDataModel.setRemarks(abroadDetailsResponseEntity.getAbroadDetailsEntity().getRemarks());
        abroadDetailsDataModel.setStayType(abroadDetailsResponseEntity.getAbroadDetailsEntity().getStayType());
        abroadDetailsDataModel.setVisaType(abroadDetailsResponseEntity.getAbroadDetailsEntity().getVisaType());
        abroadDetailsDataModel.setVisaYear(abroadDetailsResponseEntity.getAbroadDetailsEntity().getVisaYear());
        abroadDetailsResponseDataModel.setAbroadDetailsDataModel(abroadDetailsDataModel);
        return abroadDetailsResponseDataModel;
    }
}
