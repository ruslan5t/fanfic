package by.itransition.fanfic.dao;

import java.util.List;

import by.itransition.fanfic.domain.Tag;

/**
 * Class that represent interface for TagDao. 
 */
public interface TagDao {

	List<Tag> getAllTags();
	
	Tag getTagByName(String name);
	
	Tag getTagById(int id);
	
	void save(Tag tag);
	
}
