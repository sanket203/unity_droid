package unity.com.unityapp.unity.com.unityapp.base.networking;

import io.reactivex.Observable;
import retrofit2.http.GET;
import unity.com.unityapp.unity.com.unityapp.base.data.model.request.RecentProfileRequestEntity;
import unity.com.unityapp.unity.com.unityapp.base.data.model.response.RecentProfileResponseEntity;

/**
 * Created by admin on 10/12/18.
 */

public interface BaseApi {

    @GET("/get")
    Observable<RecentProfileResponseEntity> getData(RecentProfileRequestEntity recentProfileRequestEntity);
}
