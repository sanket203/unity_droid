package unity.com.unityapp.unity.com.unityapp.base.domain.model;

/**
 * Created by admin on 20/12/18.
 */

public class LoginUserResponseDataModel {
    private String status;

    private String message;

    private UserResponseDataModel userResponseDataModel;

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

    public UserResponseDataModel getUserResponseDataModel() {
        return userResponseDataModel;
    }

    public void setUserResponseDataModel(UserResponseDataModel userResponseDataModel) {
        this.userResponseDataModel = userResponseDataModel;
    }
}
