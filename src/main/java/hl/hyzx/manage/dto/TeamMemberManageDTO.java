package hl.hyzx.manage.dto;

import java.util.Date;

public class TeamMemberManageDTO {
	private int id;
	private String name;
	private String position;
	private String positionalTitles;
	private String cutTitles;
	private int imgId;
	private String imgPath;
	private int teamType;
	private Date createTime;

	public int getTeamType() {
		return teamType;
	}

	public void setTeamType(int teamType) {
		this.teamType = teamType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPositionalTitles() {
		return positionalTitles;
	}

	public void setPositionalTitles(String positionalTitles) {
		this.positionalTitles = positionalTitles;
	}

	public String getCutTitles() {
		return cutTitles;
	}

	public void setCutTitles(String cutTitles) {
		this.cutTitles = cutTitles;
	}

	public int getImgId() {
		return imgId;
	}

	public void setImgId(int imgId) {
		this.imgId = imgId;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}