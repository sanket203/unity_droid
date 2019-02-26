package unity.com.unityapp.unity.com.unityapp.base.domain.model;

import com.squareup.moshi.Json;


public class DietDetailsDataModel {


    private int id;

    @Json(name = "candidateId")
    private int candidateId;

    @Json(name = "dietType")
    private String dietType;

    @Json(name = "smoke")
    private String smoke;

    @Json(name = "drink")
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


}
