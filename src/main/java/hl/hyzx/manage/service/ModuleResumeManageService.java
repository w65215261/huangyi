package hl.hyzx.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hl.hyzx.manage.dao.ModuleResumeManageDao;
import hl.hyzx.manage.dto.ModuleResumeManageDTO;

@Service
public class ModuleResumeManageService {
	@Autowired
	ModuleResumeManageDao moduleResumeManageDao;

	public int save(int moduleType, String resume, int imgId) {
		return moduleResumeManageDao.save(moduleType, resume, imgId);
	}

	public int update(int id, int moduleType, String resume, int imgId) {
		return moduleResumeManageDao.update(id, moduleType, resume, imgId);
	}
	
	public List<ModuleResumeManageDTO> getModuleResumeList(int iDisplayStart, int iDisplayLength) {
		return moduleResumeManageDao.getModuleResumeList(iDisplayStart,iDisplayLength);
	}
	
	public List<ModuleResumeManageDTO> getModuleResumeCount() {
		return moduleResumeManageDao.getModuleResumeCount();
	}
	
	public List<ModuleResumeManageDTO> queryByModuleType(int moduleType) {
		return moduleResumeManageDao.queryByModuleType(moduleType);
	}

	public ModuleResumeManageDTO getModuleResume(int id) {
		return moduleResumeManageDao.getModuleResume(id);
	}
	
	public int del(int id) {
		return moduleResumeManageDao.del(id);
	}
	
}