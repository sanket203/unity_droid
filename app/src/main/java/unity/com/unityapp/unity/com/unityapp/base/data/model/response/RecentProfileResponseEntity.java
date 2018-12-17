package unity.com.unityapp.unity.com.unityapp.base.data.model.response;

import com.squareup.moshi.Json;

import java.util.List;

/**
 * Created by admin on 11/12/18.
 */

public class RecentProfileResponseEntity {

    @Json(name = "object")
    private List<ProfileResponseEntity> profileResponseEntities;

    @Json(name = "status")
    private String status;

    @Json(name = "message")
    private String message;

    public List<ProfileResponseEntity> getProfileResponseEntities() {
        return profileResponseEntities;
    }

    public void setProfileResponseEntities(List<ProfileResponseEntity> profileResponseEntities) {
        this.profileResponseEntities = profileResponseEntities;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
