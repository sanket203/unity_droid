package unity.com.unityapp.unity.com.unityapp.base.data.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.HoroscopeDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.HoroscopeDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.HoroscopeDetailsResponseDataModel;

public class HoroscopeDetailsResponseEntityToDataModelMapper {

    @Inject
    public HoroscopeDetailsResponseEntityToDataModelMapper() {
    }

    public HoroscopeDetailsResponseDataModel mapToDataModel(HoroscopeDetailsResponseEntity horoscopeDetailsResponseEntity) {
        HoroscopeDetailsResponseDataModel horoscopeDetailsResponseDataModel = new HoroscopeDetailsResponseDataModel();
        horoscopeDetailsResponseDataModel.setMessage(horoscopeDetailsResponseEntity.getMessage());
        horoscopeDetailsResponseDataModel.setStatus(horoscopeDetailsResponseEntity.getStatus());
        HoroscopeDetailsDataModel horoscopeDetailsDataModel = new HoroscopeDetailsDataModel();
        if (horoscopeDetailsResponseEntity.getHoroscopeDetailsEntity() != null) {
            horoscopeDetailsDataModel.setCandidateId(horoscopeDetailsResponseEntity.getHoroscopeDetailsEntity().getCandidateId());
            horoscopeDetailsDataModel.setCaste(horoscopeDetailsResponseEntity.getHoroscopeDetailsEntity().getCaste());
            horoscopeDetailsDataModel.setSubCaste(horoscopeDetailsResponseEntity.getHoroscopeDetailsEntity().getSubCaste());
            horoscopeDetailsDataModel.setShakha(horoscopeDetailsResponseEntity.getHoroscopeDetailsEntity().getShakha());
            horoscopeDetailsDataModel.setUpshakha(horoscopeDetailsResponseEntity.getHoroscopeDetailsEntity().getUpshakha());
            horoscopeDetailsDataModel.setRashi(horoscopeDetailsResponseEntity.getHoroscopeDetailsEntity().getRashi());
            horoscopeDetailsDataModel.setNakshatra(horoscopeDetailsResponseEntity.getHoroscopeDetailsEntity().getNakshatra());
            horoscopeDetailsDataModel.setNaadi(horoscopeDetailsResponseEntity.getHoroscopeDetailsEntity().getNaadi());
            horoscopeDetailsDataModel.setGana(horoscopeDetailsResponseEntity.getHoroscopeDetailsEntity().getGana());
            horoscopeDetailsDataModel.setCharan(horoscopeDetailsResponseEntity.getHoroscopeDetailsEntity().getCharan());
            horoscopeDetailsDataModel.setGotra(horoscopeDetailsResponseEntity.getHoroscopeDetailsEntity().getGotra());
            horoscopeDetailsDataModel.setMangal(horoscopeDetailsResponseEntity.getHoroscopeDetailsEntity().getMangal());
            horoscopeDetailsDataModel.setRemarks(horoscopeDetailsResponseEntity.getHoroscopeDetailsEntity().getRemarks());
            horoscopeDetailsDataModel.setId(horoscopeDetailsResponseEntity.getHoroscopeDetailsEntity().getId());
        }
        horoscopeDetailsResponseDataModel.setHoroscopeDetailsDataModel(horoscopeDetailsDataModel);
        return horoscopeDetailsResponseDataModel;
    }
}
