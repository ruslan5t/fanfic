package by.itransition.fanfic.dao;

import java.util.List;

import by.itransition.fanfic.model.bean.Chapter;

public interface ChapterDao {

	void addChapter(Chapter chapter);

	List<Chapter> getChapters();

	List<Chapter> search(String searchQuery);
	
	void save(Chapter chapter);
	
}
