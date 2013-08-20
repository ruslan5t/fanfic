package by.itransition.fanfic.model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.apache.solr.analysis.LowerCaseFilterFactory;
import org.apache.solr.analysis.SnowballPorterFilterFactory;
import org.apache.solr.analysis.StandardTokenizerFactory;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.AnalyzerDef;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Parameter;
import org.hibernate.search.annotations.TokenFilterDef;
import org.hibernate.search.annotations.TokenizerDef;

import by.itransition.fanfic.model.FanficModel;

@Entity
@Indexed
public class Chapter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Field
	private String name;

	@Field
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

	public void setId(int id) {
		this.id = id;
	}

	public Fanfic getFanfic() {
		return fanfic;
	}

	public void setFanfic(Fanfic fanfic) {
		this.fanfic = fanfic;
	}
	
}
