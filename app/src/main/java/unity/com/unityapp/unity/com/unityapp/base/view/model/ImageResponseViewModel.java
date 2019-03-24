package unity.com.unityapp.unity.com.unityapp.base.view.model;

import java.util.List;

public class ImageResponseViewModel {


    private String status;


    private String message;


    List<String> imageUrls;

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

    public List<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(List<String> imageUrls) {
        this.imageUrls = imageUrls;
    }
}
