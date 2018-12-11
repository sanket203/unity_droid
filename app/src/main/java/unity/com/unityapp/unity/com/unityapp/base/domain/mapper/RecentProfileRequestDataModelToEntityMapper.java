package unity.com.unityapp.unity.com.unityapp.base.domain.mapper;

import javax.inject.Inject;

import unity.com.unityapp.unity.com.unityapp.base.data.model.request.RecentProfileRequestEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.RecentProfileRequestDataModel;

/**
 * Created by admin on 11/12/18.
 */

public class RecentProfileRequestDataModelToEntityMapper {

    @Inject

    public RecentProfileRequestDataModelToEntityMapper() {
    }

    public RecentProfileRequestEntity mapToEntity(RecentProfileRequestDataModel dataModel) {
        RecentProfileRequestEntity entity = new RecentProfileRequestEntity();
        return entity;
    }
}
