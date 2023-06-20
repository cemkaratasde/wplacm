package de.wwu.wfm.g2.data;

import javax.persistence.*;

@Entity
public class Qualification {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "name")
	private String name;

	public Qualification() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(long l) {
		this.id = l;
	}
	
	
}
