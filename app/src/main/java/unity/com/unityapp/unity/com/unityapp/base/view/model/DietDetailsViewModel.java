package unity.com.unityapp.unity.com.unityapp.base.view.model;

import com.squareup.moshi.Json;

import java.io.Serializable;


public class DietDetailsViewModel implements Serializable {


    private int id;


    private int candidateId;


    private String dietType;


    private String smoke;


    private String drink;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public String getDietType() {
        return dietType;
    }

    public void setDietType(String dietType) {
        this.dietType = dietType;
    }

    public String getSmoke() {
        return smoke;
    }

    public void setSmoke(String smoke) {
        this.smoke = smoke;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("DietDetailsViewModel{");
        sb.append("id=").append(id);
        sb.append(", candidateId=").append(candidateId);
        sb.append(", dietType='").append(dietType).append('\'');
        sb.append(", smoke='").append(smoke).append('\'');
        sb.append(", drink='").append(drink).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
