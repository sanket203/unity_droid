package unity.com.unityapp.unity.com.unityapp.base.view.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.domain.model.DietDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.DietDetailsViewModel;

public class DietDetailsViewModelToDataModelMapper {

    @Inject
    public DietDetailsViewModelToDataModelMapper() {
    }

    public DietDetailsDataModel mapToDataModel(DietDetailsViewModel dietDetailsViewModel) {
        DietDetailsDataModel dataModel = new DietDetailsDataModel();

        dataModel.setCandidateId(dietDetailsViewModel.getCandidateId());
        dataModel.setDietType(dietDetailsViewModel.getDietType());
        dataModel.setDrink(dietDetailsViewModel.getDrink());
        dataModel.setSmoke(dietDetailsViewModel.getSmoke());
        dataModel.setId(dietDetailsViewModel.getId());
        return dataModel;
    }
}
