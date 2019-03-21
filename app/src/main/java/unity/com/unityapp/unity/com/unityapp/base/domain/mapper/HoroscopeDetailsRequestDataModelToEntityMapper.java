package unity.com.unityapp.unity.com.unityapp.base.domain.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.HoroscopeDetailsEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.HoroscopeDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.HoroscopeDetailsViewModel;

public class HoroscopeDetailsRequestDataModelToEntityMapper {
    @Inject

    public HoroscopeDetailsRequestDataModelToEntityMapper() {
    }

    public HoroscopeDetailsEntity mapToEntity(HoroscopeDetailsDataModel horoscopeDetailsDataModel) {
        HoroscopeDetailsEntity entity = new HoroscopeDetailsEntity();
        entity.setCandidateId(horoscopeDetailsDataModel.getCandidateId());
        entity.setCaste(horoscopeDetailsDataModel.getCaste());
        entity.setSubCaste(horoscopeDetailsDataModel.getSubCaste());
        entity.setShakha(horoscopeDetailsDataModel.getShakha());
        entity.setUpshakha(horoscopeDetailsDataModel.getUpshakha());
        entity.setRashi(horoscopeDetailsDataModel.getRashi());
        entity.setNakshatra(horoscopeDetailsDataModel.getNakshatra());
        entity.setNaadi(horoscopeDetailsDataModel.getNaadi());
        entity.setGana(horoscopeDetailsDataModel.getGana());
        entity.setCharan(horoscopeDetailsDataModel.getCharan());
        entity.setGotra(horoscopeDetailsDataModel.getGotra());
        entity.setMangal(horoscopeDetailsDataModel.getMangal());
        entity.setRemarks(horoscopeDetailsDataModel.getRemarks());
        entity.setId(horoscopeDetailsDataModel.getId());

        return entity;
    }
}
