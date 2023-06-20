package de.wwu.wfm.g2.data;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.*;

import javax.persistence.OneToMany;
import de.wwu.wfm.g2.data.*;

import javax.persistence.Column;

@Entity
public class Application {
	@Id
	@Column(name = "email")
	private String email;
	@Column(name = "name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "motivaiton")
	private String motivation;
	@Column(name = "expSalary")
	private String expSalary;
	@Column(name="qualifications")
	private String[]qualifications;
	@Column(name="certificates")
	private String[]certificates;
	
	@OneToMany(mappedBy="application")
	@Column(name = "cv")
	private Set<Cv>cv;
	
	@Column(name = "appliedOn")
	private LocalDateTime appliedOn;
	
	@ManyToOne
	private Jobsheet jobsheet;
	
	public Application() {
		super();
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMotivation() {
		return motivation;
	}
	public void setMotivation(String motivation) {
		this.motivation = motivation;
	}
	public String getExpSalary() {
		return expSalary;
	}
	public void setExpSalary(String expSalary) {
		this.expSalary = expSalary;
	}

	public String[] getQualifications() {
		return qualifications;
	}

	public void setQualifications(String[] qualifications) {
		this.qualifications = qualifications;
	}

	public String[] getCertificates() {
		return certificates;
	}

	public void setCertificates(String[] certificates) {
		this.certificates = certificates;
	}

	public Set<Cv> getCv() {
		return cv;
	}

	public void setCv(Set<Cv> cv) {
		this.cv = cv;
	}

	public LocalDateTime getAppliedOn() {
		return appliedOn;
	}

	public void setAppliedOn(LocalDateTime appliedOn) {
		this.appliedOn = appliedOn;
	}

	public Jobsheet getJobsheet() {
		return jobsheet;
	}

	public void setJobsheet(Jobsheet jobsheet) {
		this.jobsheet = jobsheet;
	}

	@Override
	public String toString() {
		return "Application [qualifications=" + Arrays.toString(qualifications) + ", certificates="
				+ Arrays.toString(certificates) + "]";
	}
	
	
	
}