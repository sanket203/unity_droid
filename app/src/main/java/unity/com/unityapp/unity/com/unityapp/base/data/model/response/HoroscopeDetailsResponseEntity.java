package unity.com.unityapp.unity.com.unityapp.base.data.model.response;

import com.squareup.moshi.Json;

public class HoroscopeDetailsResponseEntity {

    @Json(name = "status")
    private String status;

    @Json(name = "message")
    private String message;

    @Json(name = "object")
    HoroscopeDetailsEntity horoscopeDetailsEntity;

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

    public HoroscopeDetailsEntity getHoroscopeDetailsEntity() {
        return horoscopeDetailsEntity;
    }

    public void setHoroscopeDetailsEntity(HoroscopeDetailsEntity horoscopeDetailsEntity) {
        this.horoscopeDetailsEntity = horoscopeDetailsEntity;
    }
}
