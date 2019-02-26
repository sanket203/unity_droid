package unity.com.unityapp.unity.com.unityapp.base.data.model.response;

import com.squareup.moshi.Json;

public class ExpectationDetailsResponseEntity {

    @Json(name = "status")
    private String status;

    @Json(name = "message")
    private String message;

    @Json(name = "object")
    private ExpectationsEntity expectationsEntity;

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

    public ExpectationsEntity getExpectationsEntity() {
        return expectationsEntity;
    }

    public void setExpectationsEntity(ExpectationsEntity expectationsEntity) {
        this.expectationsEntity = expectationsEntity;
    }
}
