package hl.hyzx.client.dto;

import java.util.Date;

public class ServiceMenuDTO {
	private int id;
	private int serviceMenuType;
	private String typeName;
	private String title;
	private String content;
	private Date createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getServiceMenuType() {
		return serviceMenuType;
	}

	public void setServiceMenuType(int serviceMenuType) {
		this.serviceMenuType = serviceMenuType;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}