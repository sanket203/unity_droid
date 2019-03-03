package unity.com.unityapp.unity.com.unityapp.base.domain.model;

public class EducationDetailsResponseDataModel {

    private String status;


    private String message;

    private EducationalDetailsDataModel educationalDetailsDataModel;

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

    public EducationalDetailsDataModel getEducationalDetailsDataModel() {
        return educationalDetailsDataModel;
    }

    public void setEducationalDetailsDataModel(EducationalDetailsDataModel educationalDetailsDataModel) {
        this.educationalDetailsDataModel = educationalDetailsDataModel;
    }
}
