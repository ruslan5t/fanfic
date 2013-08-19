package by.itransition.fanfic.dao;

import java.util.List;

import by.itransition.fanfic.model.bean.Chapter;
import by.itransition.fanfic.model.bean.Fanfic;

public interface FanficDao {

	void addFanfic(Fanfic fanfic);
	
	List<Fanfic> getFanfics();

	void save(Fanfic fanfic);
	
	List<Fanfic> search(String searchQuery);
	
}
