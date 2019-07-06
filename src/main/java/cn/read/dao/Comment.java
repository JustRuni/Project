package cn.read.dao;

public class Comment {
	private Integer id;
	private String bookUrl;
	private String imageUrl;
	private String grade;
	private String commentNumber;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBookUrl() {
		return bookUrl;
	}
	public void setBookUrl(String bookUrl) {
		this.bookUrl = bookUrl;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getCommentNumber() {
		return commentNumber;
	}
	public void setCommentNumber(String commentNumber) {
		this.commentNumber = commentNumber;
	}
	
}
