package hl.hyzx.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hl.hyzx.manage.dao.VideoManageDao;
import hl.hyzx.manage.dto.VideoManageDTO;

@Service
public class VideoManageService {
	@Autowired
	VideoManageDao videoManageDao;

	public int save(String name, String resume, String videoName, int videoId, int imgId, int classification,
			String classificationName, String content) {
		return videoManageDao.save(name, resume, videoName, videoId, imgId, classification, classificationName,
				content);
	}

	public int update(int id, String name, String resume, String videoName, int videoId, int imgId, int classification,
			String classificationName, String content) {
		return videoManageDao.update(id, name, resume, videoName, videoId, imgId, classification, classificationName,
				content);
	}

	public List<VideoManageDTO> getVideoList(int iDisplayStart, int iDisplayLength) {
		return videoManageDao.getVideoList(iDisplayStart, iDisplayLength);
	}

	public List<VideoManageDTO> getVideoCount() {
		return videoManageDao.getVideoCount();
	}

	public VideoManageDTO getVideo(int id) {
		return videoManageDao.getVideo(id);
	}

	public int del(int id) {
		return videoManageDao.del(id);
	}

}