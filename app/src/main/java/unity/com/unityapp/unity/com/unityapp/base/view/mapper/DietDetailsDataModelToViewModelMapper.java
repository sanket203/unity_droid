package unity.com.unityapp.unity.com.unityapp.base.view.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.domain.model.DietDetailsResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.PersonalDetailsResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.DietDetailsViewModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PersonalDetailsViewModel;

public class DietDetailsDataModelToViewModelMapper {

    @Inject
    public DietDetailsDataModelToViewModelMapper() {
    }

    public DietDetailsViewModel mapToViewModel(DietDetailsResponseDataModel dataModel) {
        DietDetailsViewModel viewModel = new DietDetailsViewModel();

        viewModel.setCandidateId(dataModel.getDietDetailsDataModel().getCandidateId());
        viewModel.setDietType(dataModel.getDietDetailsDataModel().getDietType());
        viewModel.setDrink(dataModel.getDietDetailsDataModel().getDrink());
        viewModel.setSmoke(dataModel.getDietDetailsDataModel().getSmoke());
        return viewModel;
    }
}
