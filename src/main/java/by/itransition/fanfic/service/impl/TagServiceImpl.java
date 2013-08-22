package by.itransition.fanfic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.itransition.fanfic.dao.TagDao;
import by.itransition.fanfic.domain.Tag;
import by.itransition.fanfic.service.TagService;

@Service
public class TagServiceImpl implements TagService {

	@Autowired
	private TagDao tagDao;
	
	@Override
	public List<Tag> getAllTags() {
		return tagDao.getAllTags();
	}
	
}
