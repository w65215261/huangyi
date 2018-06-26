package hl.hyzx.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hl.hyzx.manage.dao.SynopsisManageDao;
import hl.hyzx.manage.dto.SynopsisManageDTO;

@Service
public class SynopsisManageService {
	@Autowired
	SynopsisManageDao synopsisManageDao;

	public int save(int imgId, String content) {
		return synopsisManageDao.save(imgId, content);
	}

	public int update(int id, int imgId, String content) {
		return synopsisManageDao.update(id, imgId, content);
	}

	public List<SynopsisManageDTO> getSynopsisList() {
		return synopsisManageDao.getSynopsisList();
	}

	public SynopsisManageDTO getSynopsis(int id) {
		return synopsisManageDao.getSynopsis(id);
	}
}