package unity.com.unityapp.unity.com.unityapp.base.domain.model;

public class HoroscopeDetailsResponseDataModel {


    private String status;


    private String message;

    private HoroscopeDetailsDataModel horoscopeDetailsDataModel;

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

    public HoroscopeDetailsDataModel getHoroscopeDetailsDataModel() {
        return horoscopeDetailsDataModel;
    }

    public void setHoroscopeDetailsDataModel(HoroscopeDetailsDataModel horoscopeDetailsDataModel) {
        this.horoscopeDetailsDataModel = horoscopeDetailsDataModel;
    }
}
