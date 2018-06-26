package hl.hyzx.manage.dto;

import java.util.Date;

public class SignUpShowManageDTO {

	private int id;
	private String signName;
	private String signPhone;
	private String signQq;
	private String signWechat;
	private String signMailbox;
	private String signContent;
	private String signTitle;
	Date createTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSignName() {
		return signName;
	}

	public void setSignName(String signName) {
		this.signName = signName;
	}

	public String getSignPhone() {
		return signPhone;
	}

	public void setSignPhone(String signPhone) {
		this.signPhone = signPhone;
	}

	public String getSignQq() {
		return signQq;
	}

	public void setSignQq(String signQq) {
		this.signQq = signQq;
	}

	public String getSignWechat() {
		return signWechat;
	}

	public void setSignWechat(String signWechat) {
		this.signWechat = signWechat;
	}

	public String getSignMailbox() {
		return signMailbox;
	}

	public void setSignMailbox(String signMailbox) {
		this.signMailbox = signMailbox;
	}

	public String getSignContent() {
		return signContent;
	}

	public void setSignContent(String signContent) {
		this.signContent = signContent;
	}

	public String getSignTitle() {
		return signTitle;
	}

	public void setSignTitle(String signTitle) {
		this.signTitle = signTitle;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
