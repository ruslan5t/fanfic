package by.itransition.fanfic.dao;

import java.util.List;

import by.itransition.fanfic.domain.Tag;

public interface TagDao {

	List<Tag> getAllTags();
	
	Tag getTagByName(String name);
	
	void save(Tag tag);
	
}
