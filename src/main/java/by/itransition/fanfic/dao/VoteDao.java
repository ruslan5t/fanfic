package by.itransition.fanfic.dao;

import by.itransition.fanfic.domain.Vote;

public interface VoteDao {

	void save(Vote vote);
	
	void remove(Vote vote);
	
}
