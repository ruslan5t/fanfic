package by.itransition.fanfic.model.bean;

public class Comment {

	private User author;
	
	private Fanfic fanfic;
	
	private String content;

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Fanfic getFanfic() {
		return fanfic;
	}

	public void setFanfic(Fanfic fanfic) {
		this.fanfic = fanfic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}	
}
