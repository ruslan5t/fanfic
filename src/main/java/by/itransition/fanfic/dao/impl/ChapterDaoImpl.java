package by.itransition.fanfic.dao.impl;

import java.util.ArrayList;
import java.util.List;

import by.itransition.fanfic.dao.ChapterDao;
import by.itransition.fanfic.model.bean.Chapter;

public class ChapterDaoImpl implements ChapterDao {

	private List<Chapter> chapters = new ArrayList<Chapter> ();
	private int curId = -1;
	
	@Override
	public void addChapter(Chapter chapter) {
		chapter.setId(++curId);
		chapters.add(chapter);
	}

	@Override
	public List<Chapter> getChapters() {
		return chapters;
	}

}
