package by.itransition.fanfic.service;

import java.util.List;

import by.itransition.fanfic.domain.Category;
import by.itransition.fanfic.domain.Fanfic;
import by.itransition.fanfic.domain.User;

public interface FanficService {

	void addFanfic(Fanfic fanfic);

	List<Fanfic> getAllFanfics();

	void save(Fanfic fanfic);

	List<Fanfic> search(String searchQuery);

	void removeFanficById(int id);

	Fanfic getFanficById(int id);

	List<Fanfic> getFanficsByCategory(Category category, int first, int count);
	
	List<Fanfic> getFanficsByCategoryId(int id);

	List<Fanfic> getFanficsByCategoryName(String name, int first, int count);
	
	List<Fanfic> getFanficsByCategoryId(int id, int firts, int count);

	List<Fanfic> getFanficsByDate(int first, int count);

	List<Fanfic> getFanficsByRating(int first, int count);
	
	List<Fanfic> getFanficsByTagId(int id, int first, int count);
	
	List<Fanfic> getFanficsByTagId(int id);
	
	void removeFanficById(User user, int fanficId);

}
