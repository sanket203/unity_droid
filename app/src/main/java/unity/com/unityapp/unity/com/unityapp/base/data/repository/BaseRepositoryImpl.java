package unity.com.unityapp.unity.com.unityapp.base.data.repository;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.RecentProfileResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.networking.BaseApi;
import unity.com.unityapp.unity.com.unityapp.base.networking.NetworkClient;

/**
 * Created by admin on 10/12/18.
 */

public class BaseRepositoryImpl implements BaseRepository {

    private final NetworkClient networkClient;

    public BaseRepositoryImpl(NetworkClient networkClient) {
        this.networkClient = networkClient;
    }

    @Override
    public Observable<RecentProfileResponseEntity> getRecentProfiles(String pageId) {
        return networkClient.create(BaseApi.class).getRecentProfiles(pageId);
    }

    @Override
    public Observable<RecentProfileResponseEntity> getAddresstakenProfiles(String pageId) {
        return networkClient.create(BaseApi.class).getAddresstakenProfiles(pageId);
    }
}
