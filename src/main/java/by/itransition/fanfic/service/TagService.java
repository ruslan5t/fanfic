package by.itransition.fanfic.service;

import java.util.List;

import by.itransition.fanfic.domain.Tag;

public interface TagService {

	List<Tag> getAllTags();
	
	Tag getTagByName(String name);
	
	Tag getTagById(int id);
	
}
