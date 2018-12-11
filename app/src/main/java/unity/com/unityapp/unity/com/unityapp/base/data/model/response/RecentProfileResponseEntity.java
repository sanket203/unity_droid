package unity.com.unityapp.unity.com.unityapp.base.data.model.response;

import com.squareup.moshi.Json;

import java.util.List;

/**
 * Created by admin on 11/12/18.
 */

public class RecentProfileResponseEntity {

    @Json(name = "profiles")
    List<ProfileResponseEntity> profileResponseEntities;

    public List<ProfileResponseEntity> getProfileResponseEntities() {
        return profileResponseEntities;
    }

    public void setProfileResponseEntities(List<ProfileResponseEntity> profileResponseEntities) {
        this.profileResponseEntities = profileResponseEntities;
    }
}
