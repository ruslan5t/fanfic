package by.itransition.fanfic.dao;

import by.itransition.fanfic.domain.Comment;

public interface CommentDao {

	void save(Comment comment);

	void remove(Comment comment);
	
}
