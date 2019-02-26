package unity.com.unityapp.unity.com.unityapp.base.domain.model;

public class ServiceDetailsResponseDataModel {


    private String status;


    private String message;


    ServiceDetailsDataModel serviceDetailsDataModel;

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

    public ServiceDetailsDataModel getServiceDetailsDataModel() {
        return serviceDetailsDataModel;
    }

    public void setServiceDetailsDataModel(ServiceDetailsDataModel serviceDetailsDataModel) {
        this.serviceDetailsDataModel = serviceDetailsDataModel;
    }
}
