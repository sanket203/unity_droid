package unity.com.unityapp.unity.com.unityapp.base.view.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.HoroscopeDetailsEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.HoroscopeDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.HoroscopeDetailsViewModel;

public class HoroscopeDetailsViewModelToDataModelMapper {

    @Inject
    public HoroscopeDetailsViewModelToDataModelMapper() {
    }

    public HoroscopeDetailsDataModel mapToDataModel(HoroscopeDetailsViewModel horoscopeDetailsViewModel) {
        HoroscopeDetailsDataModel dataModel = new HoroscopeDetailsDataModel();
        dataModel.setCandidateId(horoscopeDetailsViewModel.getCandidateId());
        dataModel.setCaste(horoscopeDetailsViewModel.getCaste());
        dataModel.setSubCaste(horoscopeDetailsViewModel.getSubCaste());
        dataModel.setShakha(horoscopeDetailsViewModel.getShakha());
        dataModel.setUpshakha(horoscopeDetailsViewModel.getUpshakha());
        dataModel.setRashi(horoscopeDetailsViewModel.getRashi());
        dataModel.setNakshatra(horoscopeDetailsViewModel.getNakshatra());
        dataModel.setNaadi(horoscopeDetailsViewModel.getNaadi());
        dataModel.setGana(horoscopeDetailsViewModel.getGana());
        dataModel.setCharan(horoscopeDetailsViewModel.getCharan());
        dataModel.setGotra(horoscopeDetailsViewModel.getGotra());
        dataModel.setMangal(horoscopeDetailsViewModel.getMangal());
        dataModel.setRemarks(horoscopeDetailsViewModel.getRemarks());
        dataModel.setId(horoscopeDetailsViewModel.getId());

        return dataModel;
    }
}
