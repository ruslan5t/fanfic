package by.itransition.fanfic.dao;

import java.util.List;

import by.itransition.fanfic.domain.Chapter;

public interface ChapterDao {

	void addChapter(Chapter chapter);

	List<Chapter> getAllChapters();

	List<Chapter> search(String searchQuery);

	void save(Chapter chapter);

}
