package hl.hyzx.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hl.hyzx.manage.dao.OpinionManageDao;
import hl.hyzx.manage.dto.OpinionManageDTO;

@Service
public class OpinionManageService {
	@Autowired
	OpinionManageDao opinionManageDao;

	public int save(int imgId, String content) {
		return opinionManageDao.save(imgId, content);
	}

	public int update(int id, int imgId, String content) {
		return opinionManageDao.update(id, imgId, content);
	}

	public List<OpinionManageDTO> getOpinionList() {
		return opinionManageDao.getOpinionList();
	}

	public OpinionManageDTO getOpinion(int id) {
		return opinionManageDao.getOpinion(id);
	}
	
}