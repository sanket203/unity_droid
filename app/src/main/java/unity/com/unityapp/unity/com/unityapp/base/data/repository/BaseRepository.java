package unity.com.unityapp.unity.com.unityapp.base.data.repository;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.data.model.request.RecentProfileRequestEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.RecentProfileResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.RecentProfileResponseDataModel;

/**
 * Created by admin on 10/12/18.
 */

public interface BaseRepository {

    Observable<RecentProfileResponseEntity> getData(RecentProfileRequestEntity recentProfileRequestEntity);
}
