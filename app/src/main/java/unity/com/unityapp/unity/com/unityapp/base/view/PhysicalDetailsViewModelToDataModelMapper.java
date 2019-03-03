package unity.com.unityapp.unity.com.unityapp.base.view;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.domain.model.PhysicalDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PhysicalDetailsViewModel;

class PhysicalDetailsViewModelToDataModelMapper {

    @Inject
    public PhysicalDetailsViewModelToDataModelMapper() {
    }

    PhysicalDetailsDataModel mapToDataModel(PhysicalDetailsViewModel physicalDetailsViewModel) {
        PhysicalDetailsDataModel physicalDetailsDataModel = new PhysicalDetailsDataModel();
        return physicalDetailsDataModel;
    }
}
