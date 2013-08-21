package by.itransition.fanfic.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Resolution;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String password;

	private String email;

	@DateBridge(resolution = Resolution.DAY)
	private Date dateOfRegistration;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Fanfic> fanfics;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Comment> comments;

	@OneToMany
	private List<Tag> tags;

	@OneToMany
	private List<Category> categories;

	public String getUsername() {
		return name;
	}

	public void setUsername(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Fanfic> getFanfics() {
		return fanfics;
	}

	public void addFanfic(Fanfic fanfic) {
		fanfic.setAuthor(this);
		fanfics.add(fanfic);
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public void setFanfics(List<Fanfic> fanfics) {
		this.fanfics = fanfics;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fanfics == null) ? 0 : fanfics.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (null == obj) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		return name.equals(other.getUsername());
	}

	public int getId() {
		return id;
	}

	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@PrePersist
	private void onCreate() {
		dateOfRegistration = new Date();
	}

}
