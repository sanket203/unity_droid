package unity.com.unityapp.unity.com.unityapp.base.view.model;

/**
 * Created by admin on 20/12/18.
 */

public class LoginResponseViewModel {


    private String userName;


    private String password;


    private String payment;


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
