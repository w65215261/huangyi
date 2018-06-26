package hl.hyzx.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hl.hyzx.manage.dao.CaseManageDao;
import hl.hyzx.manage.dto.CaseManageDTO;

@Service
public class CaseManageService {
	@Autowired
	CaseManageDao caseManageDao;

	public int save(String name, String resume, int imgId, String content) {
		return caseManageDao.save(name, resume, imgId, content);
	}

	public int update(int id, String name, String resume, int imgId, String content) {
		return caseManageDao.update(id, name, resume, imgId, content);
	}
	
	public List<CaseManageDTO> getCaseList(int iDisplayStart, int iDisplayLength) {
		return caseManageDao.getCaseList(iDisplayStart,iDisplayLength);
	}
	
	public List<CaseManageDTO> getCaseCount() {
		return caseManageDao.getCaseCount();
	}

	public CaseManageDTO getCase(int id) {
		return caseManageDao.getCase(id);
	}
	
	public int del(int id) {
		return caseManageDao.del(id);
	}
	
}