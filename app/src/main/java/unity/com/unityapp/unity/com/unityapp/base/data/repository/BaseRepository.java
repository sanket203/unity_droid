package unity.com.unityapp.unity.com.unityapp.base.data.repository;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.RecentProfileResponseEntity;

/**
 * Created by admin on 10/12/18.
 */

public interface BaseRepository {

    Observable<RecentProfileResponseEntity> getRecentProfiles(String pageId);

    Observable<RecentProfileResponseEntity> getAddresstakenProfiles(String pageId);
}
