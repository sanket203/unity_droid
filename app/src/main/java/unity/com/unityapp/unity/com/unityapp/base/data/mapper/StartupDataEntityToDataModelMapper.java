package unity.com.unityapp.unity.com.unityapp.base.data.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.domain.model.StartupDataEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.StartupDataModel;

/**
 * Created by admin on 19/12/18.
 */

public class StartupDataEntityToDataModelMapper {


    @Inject
    public StartupDataEntityToDataModelMapper() {
    }

    public StartupDataModel mapToDataModel(StartupDataEntity entity) {
        StartupDataModel dataModel = new StartupDataModel();
        return dataModel;
    }
}
