package unity.com.unityapp.unity.com.unityapp.base.view.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.HoroscopeDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.HoroscopeDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.HoroscopeDetailsResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.HoroscopeDetailsViewModel;

public class HoroscopeDetailsDatamodelToViewModelMapper {

    @Inject
    public HoroscopeDetailsDatamodelToViewModelMapper() {
    }

    public HoroscopeDetailsViewModel mapToViewModel(HoroscopeDetailsResponseDataModel horoscopeDetailsResponseDataModel) {

        HoroscopeDetailsViewModel horoscopeDetailsViewModel = new HoroscopeDetailsViewModel();
        horoscopeDetailsViewModel.setCandidateId(horoscopeDetailsResponseDataModel.getHoroscopeDetailsDataModel().getCandidateId());
        horoscopeDetailsViewModel.setCaste(horoscopeDetailsResponseDataModel.getHoroscopeDetailsDataModel().getCaste());
        horoscopeDetailsViewModel.setSubCaste(horoscopeDetailsResponseDataModel.getHoroscopeDetailsDataModel().getSubCaste());
        horoscopeDetailsViewModel.setShakha(horoscopeDetailsResponseDataModel.getHoroscopeDetailsDataModel().getShakha());
        horoscopeDetailsViewModel.setUpshakha(horoscopeDetailsResponseDataModel.getHoroscopeDetailsDataModel().getUpshakha());
        horoscopeDetailsViewModel.setRashi(horoscopeDetailsResponseDataModel.getHoroscopeDetailsDataModel().getRashi());
        horoscopeDetailsViewModel.setNakshatra(horoscopeDetailsResponseDataModel.getHoroscopeDetailsDataModel().getNakshatra());
        horoscopeDetailsViewModel.setNaadi(horoscopeDetailsResponseDataModel.getHoroscopeDetailsDataModel().getNaadi());
        horoscopeDetailsViewModel.setGana(horoscopeDetailsResponseDataModel.getHoroscopeDetailsDataModel().getGana());
        horoscopeDetailsViewModel.setCharan(horoscopeDetailsResponseDataModel.getHoroscopeDetailsDataModel().getCharan());
        horoscopeDetailsViewModel.setGotra(horoscopeDetailsResponseDataModel.getHoroscopeDetailsDataModel().getGotra());
        horoscopeDetailsViewModel.setMangal(horoscopeDetailsResponseDataModel.getHoroscopeDetailsDataModel().getMangal());
        horoscopeDetailsViewModel.setRemarks(horoscopeDetailsResponseDataModel.getHoroscopeDetailsDataModel().getRemarks());

        return horoscopeDetailsViewModel;
    }
}
