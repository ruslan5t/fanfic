package by.itransition.fanfic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.itransition.fanfic.dao.TagDao;
import by.itransition.fanfic.domain.Tag;
import by.itransition.fanfic.service.TagService;

/**
 * Class that represent implementation of TagService. 
 */
@Service
public class TagServiceImpl implements TagService {

	@Autowired
	private TagDao tagDao;
	
	@Override
	@Transactional
	public List<Tag> getAllTags() {
		return tagDao.getAllTags();
	}
	
	@Override
	@Transactional
	public Tag getTagByName(String name) {
		Tag tag = tagDao.getTagByName(name);
		if (null == tag) {
			tag = new Tag(name);
			tagDao.save(tag);
			
		}
		return tag;
	}
	
	@Override
	@Transactional
	public Tag getTagById(int id) {
		return tagDao.getTagById(id);
	}
	
}
