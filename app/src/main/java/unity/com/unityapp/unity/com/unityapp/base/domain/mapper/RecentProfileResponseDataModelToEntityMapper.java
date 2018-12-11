package unity.com.unityapp.unity.com.unityapp.base.domain.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.RecentProfileResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.RecentProfileResponseDataModel;

/**
 * Created by admin on 11/12/18.
 */

public class RecentProfileResponseDataModelToEntityMapper {

    @Inject
    public RecentProfileResponseDataModelToEntityMapper() {

    }

    public RecentProfileResponseEntity mapToDataModel(RecentProfileResponseDataModel dataModel) {

        RecentProfileResponseEntity entity = new RecentProfileResponseEntity();
        return entity;
    }


}
