package de.wwu.wfm.g2.data;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Jobsheet {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String roleTitle;
	private String jobDescription;
	private String startDate;
	private String salaryRange;
	private String[] requiredQualifications;
	
	@OneToMany(mappedBy="jobsheet")
	@Column(name = "application")
	private Set<Application>application;
	
	
	public Jobsheet() {
		super();
	}
	
	public String getRoleTitle() {
		return roleTitle;
	}
	public void setRoleTitle(String roleTitle) {
		this.roleTitle = roleTitle;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getSalaryRange() {
		return salaryRange;
	}
	public void setSalaryRange(String salaryRange) {
		this.salaryRange = salaryRange;
	}
	public String[] getRequiredQualifications() {
		return requiredQualifications;
	}
	public void setRequiredQualifications(String[] requiredQualifications) {
		this.requiredQualifications = requiredQualifications;
	}

	public Set<Application> getApplication() {
		return application;
	}

	public void setApplication(Set<Application> application) {
		this.application = application;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}	
	
}
