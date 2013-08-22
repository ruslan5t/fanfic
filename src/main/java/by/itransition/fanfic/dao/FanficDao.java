package by.itransition.fanfic.dao;

import java.util.List;

import by.itransition.fanfic.domain.Category;
import by.itransition.fanfic.domain.Fanfic;

public interface FanficDao {

	void addFanfic(Fanfic fanfic);
	
	List<Fanfic> getAllFanfics();

	void save(Fanfic fanfic);
	
	List<Fanfic> search(String searchQuery);
	
	void removeFanficById(int id);
	
	Fanfic getFanficById(int id);
	
	List<Fanfic> getFanficsByCategory(Category category);
	
}
