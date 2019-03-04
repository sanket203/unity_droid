package unity.com.unityapp.unity.com.unityapp.base.view.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.domain.model.PhysicalDetailsDataModel;
import unity.com.unityapp.unity.com.unityapp.base.view.model.PhysicalDetailsViewModel;

public class PhysicalDetailsViewModelToDataModelMapper {

    @Inject
    public PhysicalDetailsViewModelToDataModelMapper() {
    }

    public PhysicalDetailsDataModel mapToDataModel(PhysicalDetailsViewModel physicalDetailsViewModel) {
        PhysicalDetailsDataModel physicalDetailsDataModel = new PhysicalDetailsDataModel();
        return physicalDetailsDataModel;
    }
}
