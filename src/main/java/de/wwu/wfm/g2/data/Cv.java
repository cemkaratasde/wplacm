package de.wwu.wfm.g2.data;

import javax.persistence.*;

@Entity
public class Cv {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Integer Id;
	@Column(name = "previousCompany1")
	private String previousCompany1;
	@Column(name = "previousJobTitle1")
	private String previousJobTitle1;
	@Column(name = "previousJobDescription1")
	private String previousJobDescription1;
	@Column(name = "previousCompany2")
	private String previousCompany2;
	@Column(name = "previousJobTitle2")
	private String previousJobTitle2;
	@Column(name = "previousJobDescription2")
	private String previousJobDescription2;
	@ManyToOne
	private Application application;
	public Cv() {
		super();
	}
	public String getPreviousCompany1() {
		return previousCompany1;
	}
	public void setPreviousCompany1(String previousCompany1) {
		this.previousCompany1 = previousCompany1;
	}
	public String getPreviousJobTitle1() {
		return previousJobTitle1;
	}
	public void setPreviousJobTitle1(String previousJobTitle1) {
		this.previousJobTitle1 = previousJobTitle1;
	}
	public String getPreviousJobDescription1() {
		return previousJobDescription1;
	}
	public void setPreviousJobDescription1(String previousJobDescription1) {
		this.previousJobDescription1 = previousJobDescription1;
	}
	public String getPreviousCompany2() {
		return previousCompany2;
	}
	public void setPreviousCompany2(String previousCompany2) {
		this.previousCompany2 = previousCompany2;
	}
	public String getPreviousJobTitle2() {
		return previousJobTitle2;
	}
	public void setPreviousJobTitle2(String previousJobTitle2) {
		this.previousJobTitle2 = previousJobTitle2;
	}
	public String getPreviousJobDescription2() {
		return previousJobDescription2;
	}
	public void setPreviousJobDescription2(String previousJobDescription2) {
		this.previousJobDescription2 = previousJobDescription2;
	}
	public Application getApplication() {
		return application;
	}
	public void setApplication(Application application) {
		this.application = application;
	}
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}	
}
