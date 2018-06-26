package hl.hyzx.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hl.hyzx.manage.dao.SignUpManageDao;
import hl.hyzx.manage.dto.SignUpManageDTO;
import hl.hyzx.manage.dto.SignUpShowManageDTO;

@Service
public class SignUpManageService {
	@Autowired
	SignUpManageDao signUpManageDao;

	public List<SignUpManageDTO> getSignUpCount() {
		return signUpManageDao.getSignUpCount();
	}
	
	public List<SignUpManageDTO> getSignUpList(int iDisplayStart, int iDisplayLength) {
		return signUpManageDao.getSignUpList(iDisplayStart, iDisplayLength);
	}
	
	public int save(String title, String content, int imgId) {
		return signUpManageDao.save(title, content, imgId);
	}
	
	public int update(int id, String title, String content, int imgId) {
		return signUpManageDao.update(id, title, content, imgId);
	}
	
	public SignUpManageDTO getSignUp(int id) {
		return signUpManageDao.getSignUp(id);
	}
	
	public int del(int id) {
		return signUpManageDao.del(id);
	}
	public List<SignUpShowManageDTO> getSignUpShowList(int iDisplayStart, int iDisplayLength, String tiaojian) {
		if("".equals(tiaojian) || tiaojian == null) {
			return signUpManageDao.getSignUpShowList(iDisplayStart, iDisplayLength);
		}else {
			return signUpManageDao.getSignUpShowListByTiaojian(tiaojian, iDisplayStart, iDisplayLength);
		}
	}
	
	public List<SignUpShowManageDTO> getSignUpShowCount(String tiaojian) {
		if("".equals(tiaojian) || tiaojian == null) {
			return signUpManageDao.getSignUpShowCount();
		}else {
			return signUpManageDao.getSignUpShowCountByTiaojian(tiaojian);
		}
	}
	public SignUpShowManageDTO getSignUpShow(int id) {
		return signUpManageDao.getSignUpShow(id);
	}
	
	public int delShow(int id) {
		return signUpManageDao.delShow(id);
	}
	
	public List<SignUpShowManageDTO> getSignList(String tiaojian) {
		if("".equals(tiaojian) || tiaojian == null) {
			return signUpManageDao.getSignList();
		}else {
			return signUpManageDao.getSignListByTiaojian(tiaojian);
		}
		
	}

}