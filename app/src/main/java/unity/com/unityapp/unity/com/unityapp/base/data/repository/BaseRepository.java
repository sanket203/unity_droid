package unity.com.unityapp.unity.com.unityapp.base.data.repository;

import io.reactivex.Observable;
import unity.com.unityapp.unity.com.unityapp.base.data.model.request.LoginUserRequestEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.LoginUserResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.PersonalDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.PhysicalDetailsResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.RecentProfileResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.LoginUserResponseDataModel;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.StartupDataEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.StartupDataModel;

/**
 * Created by admin on 10/12/18.
 */

public interface BaseRepository {

    Observable<RecentProfileResponseEntity> getRecentProfiles(String gender, String pageId);

    Observable<RecentProfileResponseEntity> getAddresstakenProfiles(String candidateId, String pageId);

    Observable<StartupDataEntity> getStartupData(String token);

    Observable<LoginUserResponseEntity> loginUser(LoginUserRequestEntity loginUserRequestEntity);

    Observable<PersonalDetailsResponseEntity> getPersonalDetails(String candidateId);

    Observable<PhysicalDetailsResponseEntity> getPhysicalDetails(String candidateId);
}
