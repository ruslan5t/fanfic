package by.itransition.fanfic.model.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.itransition.fanfic.dao.ChapterDao;

public class Fanfic {

	private int id;

	private double rating;

	private String name;

	private String description;

	private List<String> tags = new ArrayList<String>();

	private List<String> categories = new ArrayList<String>();

	private List<Chapter> chapters = new ArrayList<Chapter>();
	
	private List<Comment> comments = new ArrayList<Comment>();
	
	private Map<User, Integer> vote = new HashMap<User, Integer>();

	private User author;
	
	private ChapterDao chapterDao;

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List <String> getTags() {
		return tags;
	}

	public void setTags(List <String> tags) {
		this.tags = tags;
	}

	public List <String> getCategories() {
		return categories;
	}

	public void setCategories(List <String> categories) {
		this.categories = categories;
	}

	public List <Chapter> getChapters() {
		return chapters;
	}

	public void addChapter(Chapter chapter) {
		chapters.add(chapter);
		chapterDao.addChapter(chapter);
	}

	public void addComment(Comment comment) {
		comments.add(comment);
	}
	
	public List<Comment> getComments() {
		return comments;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public ChapterDao getChapterDao() {
		return chapterDao;
	}

	public void setChapterDao(ChapterDao chapterDao) {
		this.chapterDao = chapterDao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public void vote(int rating, User user) {
		if (vote.containsKey(user)) {
			vote.remove(user);
		}
		vote.put(user, rating);
		this.rating = 0;
		for (User userKey : vote.keySet()) {
			this.rating += vote.get(userKey);
		}
		this.rating /= vote.size();
	}

}
