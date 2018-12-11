package unity.com.unityapp.unity.com.unityapp.base.data.model.response;

import com.squareup.moshi.Json;

/**
 * Created by admin on 11/12/18.
 */

public class ProfileResponseEntity {

    @Json(name = "name")
    String name;

    @Json(name = "height")
    String height;

    @Json(name = "salary")
    String salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
}
