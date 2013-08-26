package by.itransition.fanfic.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Role {
	
	public static final String ROLE_USER = "ROLE_USER";
	
	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	
	public static final String ROLE_ANONYMOUS = "ROLE_ANONYMOUS";

	@Id
	@GeneratedValue
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Role other = (Role) obj;
		return name.equals(other.getName());
	}
}
