package by.itransition.fanfic.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.itransition.fanfic.dao.CategoryDao;
import by.itransition.fanfic.dao.CommentDao;
import by.itransition.fanfic.dao.FanficDao;
import by.itransition.fanfic.dao.TagDao;
import by.itransition.fanfic.dao.UserDao;
import by.itransition.fanfic.dao.VoteDao;
import by.itransition.fanfic.domain.Category;
import by.itransition.fanfic.domain.Comment;
import by.itransition.fanfic.domain.Fanfic;
import by.itransition.fanfic.domain.User;
import by.itransition.fanfic.domain.Vote;
import by.itransition.fanfic.service.FanficService;

/**
 * Class that represent implementation of FanficService. 
 */
@Service
public class FanficServiceImpl implements FanficService {

	@Autowired
	private FanficDao fanficDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private TagDao tagDao;
	
	@Autowired
	private CommentDao commentDao;
	
	@Autowired
	private VoteDao voteDao;
	
	@Override
	@Transactional
	public void addFanfic(Fanfic fanfic) {
		fanficDao.addFanfic(fanfic);
	}

	@Override
	@Transactional
	public List<Fanfic> getAllFanfics() {
		return fanficDao.getAllFanfics();
	}

	@Override
	@Transactional
	public void save(Fanfic fanfic) {
		fanficDao.save(fanfic);
	}

	@Override
	@Transactional
	public List<Fanfic> search(String searchQuery) {
		return fanficDao.search(searchQuery);
	}

	@Override
	@Transactional
	public void removeFanficById(int id) {
		fanficDao.removeFanficById(id);
	}

	@Override
	@Transactional
	public Fanfic getFanficById(int id) {
		return fanficDao.getFanficById(id);
	}
	
	@Override
	@Transactional
	public List<Fanfic> getFanficsByCategory(Category category, int first, int count) {
		return fanficDao.getFanficsByCategory(category, first, count);
	}
	
	@Override
	@Transactional
	public List<Fanfic> getFanficsByCategoryName(String name, int first, int count) {
		return fanficDao.getFanficsByCategory(categoryDao.getCategoryByName(name), first, count);
	}
	
	@Override
	@Transactional
	public List<Fanfic> getFanficsByCategoryId(int id) {
		return fanficDao.getFanficsByCategory(categoryDao.getCategoryById(id), 0, Integer.MAX_VALUE);
	}
	
	@Override
	@Transactional
	public List<Fanfic> getFanficsByCategoryId(int id, int first, int count) {
		return fanficDao.getFanficsByCategory(categoryDao.getCategoryById(id), first, count);
	}
	
	@Override
	@Transactional
	public List<Fanfic> getFanficsByDate(int first, int count) {
		return fanficDao.getFanficsByDate(first, count);
	}

	@Override
	@Transactional
	public List<Fanfic> getFanficsByRating(int first, int count) {
		return fanficDao.getFanficsByRating(first, count);
	}
	
	@Override
	@Transactional
	public List<Fanfic> getFanficsByTagId(int id, int first, int count) {
		return fanficDao.getFanficsByTag(tagDao.getTagById(id), first, count);
	}
	
	@Override
	@Transactional
	public List<Fanfic> getFanficsByTagId(int id) {
		return fanficDao.getFanficsByTag(tagDao.getTagById(id), 0, Integer.MAX_VALUE);
	}
	
	@Override
	@Transactional
	public void removeFanficById(User user, int fanficId) {
		Fanfic fanfic = getFanficById(fanficId);
		user.getFanfics().remove(fanfic);
		userDao.save(user);
		for (Comment comment : fanfic.getComments()) {
			User author = comment.getAuthor();
			author.getComments().remove(comment);
			comment.setAuthor(null);
			comment.setFanfic(null);
			userDao.save(author);
			commentDao.save(comment);
		}
		List<Comment> comments = fanfic.getComments();
		fanfic.setComments(null);
		for (Comment comment : comments) {
			commentDao.remove(comment);
		}
		for (Vote vote : fanfic.getVotes()) {
			User author = vote.getUser();
			author.getVotes().remove(vote);
			vote.setUser(null);
			vote.setFanfic(null);
			userDao.save(author);
			voteDao.save(vote);
		}
		List<Vote> votes = fanfic.getVotes();
		fanfic.setComments(null);
		for (Vote vote : votes) {
			voteDao.remove(vote);
		}
		fanficDao.save(fanfic);
		fanficDao.removeFanficById(fanfic.getId());
	}
	
}
