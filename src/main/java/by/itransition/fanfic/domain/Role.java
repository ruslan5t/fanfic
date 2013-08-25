package by.itransition.fanfic.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Role {
	
	public final String ROLE_USER = "ROLE_USER";
	
	public final String ROLE_ADMIN = "ROLE_ADMIN";
	
	public final String ROLE_ANONYMOUS = "ROLE_ANONYMOUS";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;

	public Role() {
		
	}
	
	public Role(String name) {
		setName(name);
	}
	
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
	
}
