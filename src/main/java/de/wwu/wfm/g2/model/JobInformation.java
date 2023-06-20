package de.wwu.wfm.g2.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class JobInformation implements Serializable {

    @NotNull
    private String roleTitle;
    @NotNull
    @Positive
    private int numberOfOpenPositions;
    @NotBlank
    private String responsibilities;

    @Positive
    private int minSalary;
    @Positive
    private int maxSalary;
    @NotBlank
    private String jobTenure;
    @NotBlank
    private String incentives;
    @NotBlank
    private String companyDescription;
    @NotBlank
    private String contactData;
    @NotBlank
    private String requiredQualification;
    @NotBlank
    private String applicationInformation; //documents and other information
    
    public String getRoleTitle() {
        return roleTitle;
    }
    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }
    public int getNumberOfOpenPositions() {
        return numberOfOpenPositions;
    }
    public void setNumberOfOpenPositions(int numberOfOpenPositions) {
        this.numberOfOpenPositions = numberOfOpenPositions;
    }
    public String getResponsibilities() {
        return responsibilities;
    }
    public void setResponsibilities(String responsibilities) {
        this.responsibilities = responsibilities;
    }
    public int getMinSalary() {
        return minSalary;
    }
    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }
    public int getMaxSalary() {
        return maxSalary;
    }
    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }
    public String getJobTenure() {
        return jobTenure;
    }
    public void setJobTenure(String jobTenure) {
        this.jobTenure = jobTenure;
    }
    public String getIncentives() {
        return incentives;
    }
    public void setIncentives(String incentives) {
        this.incentives = incentives;
    }
    public String getCompanyDescription() {
        return companyDescription;
    }
    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }
    public String getContactData() {
        return contactData;
    }
    public void setContactData(String contactData) {
        this.contactData = contactData;
    }
    public String getRequiredQualification() {
        return requiredQualification;
    }
    public void setRequiredQualification(String requiredQualification) {
        this.requiredQualification = requiredQualification;
    }
    public String getApplicationInformation() {
        return applicationInformation;
    }
    public void setApplicationInformation(String applicationInformation) {
        this.applicationInformation = applicationInformation;
    }
    
    @Override
    public String toString() {
        return "JobInformation: \nroleTitle=" + roleTitle + "\nnumberOfOpenPositions=" + numberOfOpenPositions
                + "\nresponsibilities=" + responsibilities + "\nminSalary=" + minSalary + "\nmaxSalary=" + maxSalary
                + "\njobTenure=" + jobTenure + "\nincentives=" + incentives + "\ncompanyDescription="
                + companyDescription + "\ncontactData=" + contactData + "\nrequiredQualification="
                + requiredQualification + "\napplicationInformation=" + applicationInformation + "]";
    }


    
}
