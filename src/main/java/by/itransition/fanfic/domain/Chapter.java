package by.itransition.fanfic.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.Field;

@Entity
public class Chapter {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Field
	@Analyzer(definition="FanficAnalyzer")
	private String name;

	@Field
	@Analyzer(definition="FanficAnalyzer")
	private String content;
	
	@ManyToOne
	private Fanfic fanfic;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public Fanfic getFanfic() {
		return fanfic;
	}

	public void setFanfic(Fanfic fanfic) {
		this.fanfic = fanfic;
	}
	
}
