package unity.com.unityapp.unity.com.unityapp.base;

/**
 * Created by admin on 18/12/18.
 */

public class UserInfo {

    private static UserInfo userInfo;

    private String gender;
    private String userName;
    private String firstName;
    private String email;
    private String anonyMousToken;
    private int candidateId;
    private int addressCount;


    public static UserInfo getUserInfo() {
        if (userInfo == null) {
            userInfo = new UserInfo();
        }
        return userInfo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAnonyMousToken() {
        return anonyMousToken;
    }

    public void setAnonyMousToken(String anonyMousToken) {
        this.anonyMousToken = anonyMousToken;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public int getAddressCount() {
        return addressCount;
    }

    public void setAddressCount(int addressCount) {
        this.addressCount = addressCount;
    }
}
