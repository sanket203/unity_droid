package unity.com.unityapp.unity.com.unityapp.base.data.model.response;

import com.squareup.moshi.Json;


public class ExpectationsEntity {


    @Json(name = "id")
    private int id;

    @Json(name = "candidateId")
    private int candidateId;

    @Json(name = "minHeight")
    private String minHeight;

    @Json(name = "maxHeight")
    private String maxHeight;

    @Json(name = "minAge")
    private String minAge;

    @Json(name = "maxAge")
    private String maxAge;

    @Json(name = "subCaste")
    private String subCaste;

    @Json(name = "degree")
    private String degree;

    @Json(name = "workingLocation")
    private String workingLocation;

    @Json(name = "parentsLocation")
    private String parentsLocation;

    @Json(name = "packageLimit")
    private String packageLimit;

    @Json(name = "patrikaMatching")
    private String patrikaMatching;

    @Json(name = "other")
    private String other;

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

    public String getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(String minHeight) {
        this.minHeight = minHeight;
    }

    public String getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(String maxHeight) {
        this.maxHeight = maxHeight;
    }

    public String getMinAge() {
        return minAge;
    }

    public void setMinAge(String minAge) {
        this.minAge = minAge;
    }

    public String getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(String maxAge) {
        this.maxAge = maxAge;
    }

    public String getSubCaste() {
        return subCaste;
    }

    public void setSubCaste(String subCaste) {
        this.subCaste = subCaste;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getWorkingLocation() {
        return workingLocation;
    }

    public void setWorkingLocation(String workingLocation) {
        this.workingLocation = workingLocation;
    }

    public String getParentsLocation() {
        return parentsLocation;
    }

    public void setParentsLocation(String parentsLocation) {
        this.parentsLocation = parentsLocation;
    }

    public String getPackageLimit() {
        return packageLimit;
    }

    public void setPackageLimit(String packageLimit) {
        this.packageLimit = packageLimit;
    }

    public String getPatrikaMatching() {
        return patrikaMatching;
    }

    public void setPatrikaMatching(String patrikaMatching) {
        this.patrikaMatching = patrikaMatching;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }


}
