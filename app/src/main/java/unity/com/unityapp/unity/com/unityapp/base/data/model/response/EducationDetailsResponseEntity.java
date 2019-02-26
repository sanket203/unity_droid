package unity.com.unityapp.unity.com.unityapp.base.data.model.response;

import com.squareup.moshi.Json;

import unity.com.unityapp.unity.com.unityapp.base.domain.model.EducationalDetailsEntity;

public class EducationDetailsResponseEntity {

    @Json(name = "status")
    private String status;

    @Json(name = "message")
    private String message;

    @Json(name = "object")
    private EducationalDetailsEntity educationalDetailsEntity;

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

    public EducationalDetailsEntity getEducationalDetailsEntity() {
        return educationalDetailsEntity;
    }

    public void setEducationalDetailsEntity(EducationalDetailsEntity educationalDetailsEntity) {
        this.educationalDetailsEntity = educationalDetailsEntity;
    }
}
