package hl.hyzx.client.dto;

public class HomeDTO {
	private int id;
	private int state;
	private String bannerLink;
	private String bannerPath;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getBannerPath() {
		return bannerPath;
	}

	public void setBannerPath(String bannerPath) {
		this.bannerPath = bannerPath;
	}

	public String getBannerLink() {
		return bannerLink;
	}

	public void setBannerLink(String bannerLink) {
		this.bannerLink = bannerLink;
	}
	

}