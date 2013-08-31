package by.itransition.fanfic.dao;

import by.itransition.fanfic.domain.Vote;

/**
 * Class that represent interface for VoteDao. 
 */
public interface VoteDao {

	void save(Vote vote);
	
	void remove(Vote vote);
	
}
