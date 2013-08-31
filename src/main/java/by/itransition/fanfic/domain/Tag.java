package by.itransition.fanfic.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.Field;

/**
 * Class that represent tag for fanfic. 
 */
@Entity
public class Tag {

	@Id
	@GeneratedValue
	private int id;

	@Field
	@Analyzer(definition="FanficAnalyzer")
	@Column(columnDefinition = "TEXT")
	private String name;

	public Tag () {
		
	}
	
	public Tag(String name) {
		setName(name);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return name;
	}

}
