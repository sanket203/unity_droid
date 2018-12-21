package unity.com.unityapp.unity.com.unityapp.base.data.model.request;

import com.squareup.moshi.Json;

/**
 * Created by admin on 20/12/18.
 */

public class LoginUserRequestEntity {

    @Json(name = "user_name")
    private String userName;

    @Json(name = "password")
    private String password;

    @Json(name = "payment")
    private String payment;

    @Json(name = "transactionId")
    private String transactionId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}
