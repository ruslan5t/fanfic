package by.itransition.fanfic.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.Field;

@Entity
public class Category {

	@Id
	@Field
	@Analyzer(definition="FanficAnalyzer")
	private String name;
	
	public Category() {
		
	}
	
	public Category(String name) {
		setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}

}
