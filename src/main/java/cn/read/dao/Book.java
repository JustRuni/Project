package cn.read.dao;

public class Book {
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", grade=" + grade + ", title=" + title + ", bookurl=" + bookurl + ", imgurl="
				+ imgurl + ", ratingNums=" + ratingNums + ", commentNums=" + commentNums + ", biaoqian=" + biaoqian
				+ "]";
	}
	private int id;
	private float grade;
	private String title;
	private String bookurl;
	private String imgurl;
	private float ratingNums;
	private Integer commentNums;
	private String biaoqian;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getGrade() {
		return grade;
	}
	public void setGrade(float grade) {
		this.grade = grade;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBookurl() {
		return bookurl;
	}
	public void setBookurl(String bookurl) {
		this.bookurl = bookurl;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public float getRatingNums() {
		return ratingNums;
	}
	public void setRatingNums(float ratingNums) {
		this.ratingNums = ratingNums;
	}
	public Integer getCommentNums() {
		return commentNums;
	}
	public void setCommentNums(Integer commentNums) {
		this.commentNums = commentNums;
	}
	public String getBiaoqian() {
		return biaoqian;
	}
	public void setBiaoqian(String biaoqian) {
		this.biaoqian = biaoqian;
	}
	
	
}