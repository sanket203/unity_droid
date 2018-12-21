package unity.com.unityapp.unity.com.unityapp.base.data.model.response;

import com.squareup.moshi.Json;

/**
 * Created by admin on 20/12/18.
 */

public class LoginUserResponseEntity {

    @Json(name = "status")
    private String status;

    @Json(name = "message")
    private String message;

    @Json(name = "payment")
    private String payment;

    @Json(name = "object")
    private UserResponseEntity userResponseEntity;

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

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public UserResponseEntity getUserResponseEntity() {
        return userResponseEntity;
    }

    public void setUserResponseEntity(UserResponseEntity userResponseEntity) {
        this.userResponseEntity = userResponseEntity;
    }
}
