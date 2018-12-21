package unity.com.unityapp.unity.com.unityapp.base.networking;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import unity.com.unityapp.unity.com.unityapp.base.data.model.request.LoginUserRequestEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.LoginUserResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.RecentProfileResponseEntity;
import unity.com.unityapp.unity.com.unityapp.base.domain.model.StartupDataEntity;

/**
 * Created by admin on 10/12/18.
 */

public interface BaseApi {

    @GET("latestProfile/{gender}/{pageId}")
    Observable<RecentProfileResponseEntity> getRecentProfiles(@Path("gender") String gender, @Path("pageId") String pageId);

    @GET("addressTakenProfiles/{candidateId}/{pageId}")
    Observable<RecentProfileResponseEntity> getAddresstakenProfiles(@Path("candidateId") String candidateId, @Path("pageId") String pageId);

    @GET("addressTakenProfiles/{candidateId}/{pageId}")
    Observable<StartupDataEntity> getStartupData(String token);

    @POST("matrimony/login")
    Observable<LoginUserResponseEntity> loginUser(@Body LoginUserRequestEntity loginUserRequestEntity);
}
