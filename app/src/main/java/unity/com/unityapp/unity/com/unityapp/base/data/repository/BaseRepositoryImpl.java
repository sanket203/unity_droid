package unity.com.unityapp.unity.com.unityapp.base.data.repository;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.data.model.request.LoginUserRequestEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.LoginUserResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.PersonalDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.RecentProfileResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.StartupDataEntity;
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
    public Observable<RecentProfileResponseEntity> getRecentProfiles(String gender, String pageId) {
        return networkClient.create(BaseApi.class).getRecentProfiles(gender.toLowerCase(), pageId);
    }

    @Override
    public Observable<RecentProfileResponseEntity> getAddresstakenProfiles(String candidateId, String pageId) {
        return networkClient.create(BaseApi.class).getAddresstakenProfiles(candidateId, pageId);
    }

    @Override
    public Observable<StartupDataEntity> getStartupData(String token) {
        return networkClient.create(BaseApi.class).getStartupData(token);
    }

    @Override
    public Observable<LoginUserResponseEntity> loginUser(LoginUserRequestEntity loginUserRequestEntity) {
        return networkClient.create(BaseApi.class).loginUser(loginUserRequestEntity);
    }

    @Override
    public Observable<PersonalDetailsResponseEntity> getPersonalDetails(String candidateId) {
        return networkClient.create(BaseApi.class).getPersonalDetails(candidateId);
    }
}
