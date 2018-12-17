package unity.com.unityapp.unity.com.unityapp.base.domain.model;

import java.util.List;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.ProfileResponseEntity;

/**
 * Created by admin on 10/12/18.
 */

public class RecentProfileResponseDataModel {

    private List<ProfileResponseDataModel> profileResponseEntities;
    private String status;
    private String message;

    public List<ProfileResponseDataModel> getProfileResponseEntities() {
        return profileResponseEntities;
    }

    public void setProfileResponseEntities(List<ProfileResponseDataModel> profileResponseEntities) {
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
