package hl.hyzx.manage.dto;

public class ModuleResumeManageDTO {
	private int id;
	private int moduleType;
	private String resume;
	private int imgId;
	private String imgPath;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getModuleType() {
		return moduleType;
	}

	public void setModuleType(int moduleType) {
		this.moduleType = moduleType;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
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

}
