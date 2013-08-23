package by.itransition.fanfic.service;

import java.util.List;

import by.itransition.fanfic.domain.Category;
import by.itransition.fanfic.domain.Fanfic;

public interface FanficService {

	void addFanfic(Fanfic fanfic);

	List<Fanfic> getAllFanfics();

	void save(Fanfic fanfic);

	List<Fanfic> search(String searchQuery);

	void removeFanficById(int id);

	Fanfic getFanficById(int id);

	List<Fanfic> getFanficsByCategory(Category category);

	List<Fanfic> getFanficsByCategoryName(String name);
	
	List<Fanfic> getFanficsByTagName(String name);

	List<Fanfic> getFanficsByDate(int first, int count);

	List<Fanfic> getFanficsByRating(int first, int count);

}
