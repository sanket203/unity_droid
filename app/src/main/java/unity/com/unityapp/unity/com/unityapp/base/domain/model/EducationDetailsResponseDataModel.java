package unity.com.unityapp.unity.com.unityapp.base.domain.model;

public class EducationDetailsResponseDataModel {

    private String status;


    private String message;

    private EducationalDetailsEntity educationalDetailsDataModel;

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

    public EducationalDetailsEntity getEducationalDetailsDataModel() {
        return educationalDetailsDataModel;
    }

    public void setEducationalDetailsDataModel(EducationalDetailsEntity educationalDetailsDataModel) {
        this.educationalDetailsDataModel = educationalDetailsDataModel;
    }
}
