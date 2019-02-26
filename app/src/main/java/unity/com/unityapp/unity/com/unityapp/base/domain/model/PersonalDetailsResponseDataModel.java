package unity.com.unityapp.unity.com.unityapp.base.domain.model;

import unity.com.unityapp.unity.com.unityapp.base.data.model.response.PersonalDetailsEntity;

public class PersonalDetailsResponseDataModel {


    private String status;


    private String message;

    private PersonalDetailsDataModel personalDetailsDataModel;

    public PersonalDetailsDataModel getPersonalDetailsDataModel() {
        return personalDetailsDataModel;
    }

    public void setPersonalDetailsDataModel(PersonalDetailsDataModel personalDetailsDataModel) {
        this.personalDetailsDataModel = personalDetailsDataModel;
    }

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

}
