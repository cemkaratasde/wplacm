package de.wwu.wfm.g2.model;

import java.util.Arrays;

public class Candidate {
    private int id;
    private String name;
    private String email;
    private String[] qualification;
    private String[] cv;
    private String[] certificates;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String[] getQualification() {
        return qualification;
    }
    public void setQualification(String[] qualification) {
        this.qualification = qualification;
    }
    public String[] getCv() {
        return cv;
    }
    public void setCv(String[] cv) {
        this.cv = cv;
    }
    public String[] getCertificates() {
        return certificates;
    }
    public void setCertificates(String[] certificates) {
        this.certificates = certificates;
    }
    @Override
    public String toString() {
        return "Candidate " + id + " [name=" + name + ", email=" + email + ", qualification=" + Arrays.toString(qualification)
                + ", cv=" + Arrays.toString(cv) + ", certificates=" + Arrays.toString(certificates) + "]";
    }

    
}
