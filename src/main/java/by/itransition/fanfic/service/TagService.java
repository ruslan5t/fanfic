package by.itransition.fanfic.service;

import java.util.List;

import by.itransition.fanfic.domain.Tag;

/**
 * Class that represent interface of TagService. 
 */
public interface TagService {

	List<Tag> getAllTags();
	
	Tag getTagByName(String name);
	
	Tag getTagById(int id);
	
	List<Tag> getTags(int count);
	
}
