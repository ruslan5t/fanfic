package by.itransition.fanfic.dao;

import java.util.List;

import by.itransition.fanfic.model.bean.Chapter;
import by.itransition.fanfic.model.bean.Fanfic;

public interface ChapterDao {

	void addChapter(Chapter chapter);

	List<Chapter> getChapters();

}
