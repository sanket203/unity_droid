package unity.com.unityapp.unity.com.unityapp.base.view.model;

/**
 * Created by admin on 11/12/18.
 */

public class RecentProfileRequestViewModel {

    private String name;
    private String height;
    private String salary;

    public RecentProfileRequestViewModel(String name, String height, String salary) {
        this.name = name;
        this.height = height;
        this.salary = salary;
    }

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
