package hl.hyzx.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hl.hyzx.client.dao.VideosDao;
import hl.hyzx.client.dto.VideosDTO;

@Service
public class VideosService {
	@Autowired
	VideosDao videosDao;

	public List<VideosDTO> getVideoList(int classification, int start, int pageSize) {
		return videosDao.getVideoList(classification, start, pageSize);
	}

	public int getVideoCount(int columnId) {
		return videosDao.getVideoCount(columnId);
	}
}