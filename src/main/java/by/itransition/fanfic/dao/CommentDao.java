package by.itransition.fanfic.dao;

import by.itransition.fanfic.domain.Comment;

/**
 * Class that represent interface for CommentDao. 
 */
public interface CommentDao {

	void save(Comment comment);

	void remove(Comment comment);
	
}
