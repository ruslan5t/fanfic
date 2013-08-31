package by.itransition.fanfic.service;

import java.util.List;

import by.itransition.fanfic.domain.Chapter;

/**
 * Class that represent interface of ChapterService. 
 */
public interface ChapterService {

	void addChapter(Chapter chapter);

	List<Chapter> getAllChapters();

	List<Chapter> search(String searchQuery);

	void save(Chapter chapter);

}
