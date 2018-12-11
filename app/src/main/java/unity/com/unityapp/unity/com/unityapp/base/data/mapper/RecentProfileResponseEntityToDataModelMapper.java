package unity.com.unityapp.unity.com.unityapp.base.data.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.RecentProfileResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.RecentProfileResponseDataModel;

/**
 * Created by admin on 11/12/18.
 */

public class RecentProfileResponseEntityToDataModelMapper {

    @Inject
    public RecentProfileResponseEntityToDataModelMapper() {

    }

    public RecentProfileResponseDataModel mapToDataModel(RecentProfileResponseEntity entity) {
        RecentProfileResponseDataModel dataModel = new RecentProfileResponseDataModel();
        return dataModel;
    }


}
