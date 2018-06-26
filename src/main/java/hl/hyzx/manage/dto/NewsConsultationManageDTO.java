package hl.hyzx.manage.dto;

import java.util.Date;

public class NewsConsultationManageDTO {
	private int id;
	private String newsTitle;
	private String author;
	private Date newsTime;
	private int imgId;
	private String content;
	private String imgPath;
	private String contentCutOut;
	private String dateMonth;
	private String dateDay;
	private Date createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNewsTitle() {
		return newsTitle;
	}

	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getNewsTime() {
		return newsTime;
	}

	public void setNewsTime(Date newsTime) {
		this.newsTime = newsTime;
	}

	public int getImgId() {
		return imgId;
	}

	public void setImgId(int imgId) {
		this.imgId = imgId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getContentCutOut() {
		return contentCutOut;
	}

	public void setContentCutOut(String contentCutOut) {
		this.contentCutOut = contentCutOut;
	}

	public String getDateMonth() {
		return dateMonth;
	}

	public void setDateMonth(String dateMonth) {
		this.dateMonth = dateMonth;
	}

	public String getDateDay() {
		return dateDay;
	}

	public void setDateDay(String dateDay) {
		this.dateDay = dateDay;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}