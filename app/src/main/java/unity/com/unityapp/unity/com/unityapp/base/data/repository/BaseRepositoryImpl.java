package unity.com.unityapp.unity.com.unityapp.base.data.repository;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.data.model.request.RecentProfileRequestEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.RecentProfileResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.RecentProfileResponseDataModel;
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
    public Observable<RecentProfileResponseEntity> getData(RecentProfileRequestEntity recentProfileRequestEntity) {
        return networkClient.create(BaseApi.class).getData(recentProfileRequestEntity);
    }
}
