package by.itransition.fanfic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.itransition.fanfic.dao.ChapterDao;
import by.itransition.fanfic.domain.Chapter;
import by.itransition.fanfic.service.ChapterService;

@Service
public class ChapterServiceImpl implements ChapterService {

	@Autowired
	private ChapterDao chapterDao;

	@Transactional
	public void addChapter(Chapter chapter) {
		chapterDao.addChapter(chapter);
	}

	@Transactional
	public List<Chapter> getAllChapters() {
		return chapterDao.getAllChapters();
	}

	@Transactional
	public List<Chapter> search(String searchQuery) {
		return chapterDao.search(searchQuery);
	}

	@Transactional
	public void save(Chapter chapter) {
		chapterDao.save(chapter);
	}

}
