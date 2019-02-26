package unity.com.unityapp.unity.com.unityapp.base.data.model.response;

import com.squareup.moshi.Json;

public class ServiceDetailsResponseEntity {

    @Json(name = "status")
    private String status;

    @Json(name = "message")
    private String message;

    @Json(name = "object")
    ServiceDetailsEntity serviceDetailsEntity;

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

    public ServiceDetailsEntity getServiceDetailsEntity() {
        return serviceDetailsEntity;
    }

    public void setServiceDetailsEntity(ServiceDetailsEntity serviceDetailsEntity) {
        this.serviceDetailsEntity = serviceDetailsEntity;
    }
}
