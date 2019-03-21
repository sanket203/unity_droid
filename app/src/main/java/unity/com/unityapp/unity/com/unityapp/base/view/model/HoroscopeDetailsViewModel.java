
package unity.com.unityapp.unity.com.unityapp.base.view.model;

import java.io.Serializable;

public class HoroscopeDetailsViewModel implements Serializable {


    private int id;

    private int candidateId;


    private String caste;


    private String subCaste;


    private String shakha;


    private String upshakha;


    private String rashi;


    private String nakshatra;


    private String naadi;


    private String gana;


    private String charan;


    private String gotra;


    private String mangal;


    private String remarks;


    public int getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int candidateId) {
        this.candidateId = candidateId;
    }

    public String getCaste() {
        return caste;
    }

    public void setCaste(String caste) {
        this.caste = caste;
    }

    public String getSubCaste() {
        return subCaste;
    }

    public void setSubCaste(String subCaste) {
        this.subCaste = subCaste;
    }

    public String getShakha() {
        return shakha;
    }

    public void setShakha(String shakha) {
        this.shakha = shakha;
    }

    public String getRashi() {
        return rashi;
    }

    public void setRashi(String rashi) {
        this.rashi = rashi;
    }

    public String getNakshatra() {
        return nakshatra;
    }

    public void setNakshatra(String nakshatra) {
        this.nakshatra = nakshatra;
    }

    public String getNaadi() {
        return naadi;
    }

    public void setNaadi(String naadi) {
        this.naadi = naadi;
    }

    public String getGana() {
        return gana;
    }

    public void setGana(String gana) {
        this.gana = gana;
    }

    public String getCharan() {
        return charan;
    }

    public void setCharan(String charan) {
        this.charan = charan;
    }

    public String getGotra() {
        return gotra;
    }

    public void setGotra(String gotra) {
        this.gotra = gotra;
    }

    public String getMangal() {
        return mangal;
    }

    public void setMangal(String mangal) {
        this.mangal = mangal;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getUpshakha() {
        return upshakha;
    }

    public void setUpshakha(String upshakha) {
        this.upshakha = upshakha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("HoroscopeDetailsViewModel{");
        sb.append("candidateId=").append(candidateId);
        sb.append(", caste='").append(caste).append('\'');
        sb.append(", subCaste='").append(subCaste).append('\'');
        sb.append(", shakha='").append(shakha).append('\'');
        sb.append(", upshakha='").append(upshakha).append('\'');
        sb.append(", rashi='").append(rashi).append('\'');
        sb.append(", nakshatra='").append(nakshatra).append('\'');
        sb.append(", naadi='").append(naadi).append('\'');
        sb.append(", gana='").append(gana).append('\'');
        sb.append(", charan='").append(charan).append('\'');
        sb.append(", gotra='").append(gotra).append('\'');
        sb.append(", mangal='").append(mangal).append('\'');
        sb.append(", remarks='").append(remarks).append('\'');
        sb.append('}');
        return sb.toString();
    }


}
