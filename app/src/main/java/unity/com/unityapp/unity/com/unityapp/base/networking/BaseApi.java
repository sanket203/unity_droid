package unity.com.unityapp.unity.com.unityapp.base.networking;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.RecentProfileResponseEntity;

/**
 * Created by admin on 10/12/18.
 */

public interface BaseApi {

    @GET("latestProfile/male/{pageId}")
    Observable<RecentProfileResponseEntity> getRecentProfiles(@Path("pageId") String pageId);

    @GET("latestProfile/male/{pageId}")
    Observable<RecentProfileResponseEntity> getAddresstakenProfiles(@Path("pageId") String pageId);
}
