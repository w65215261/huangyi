package hl.hyzx.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hl.hyzx.manage.dao.ConsultManageDao;
import hl.hyzx.manage.dto.ConsultManageDTO;

@Service
public class ConsultManageService {
	@Autowired
	ConsultManageDao consultManageDao;

	public List<ConsultManageDTO> getConsultCount() {
		return consultManageDao.getConsultCount();
	}
	
	public List<ConsultManageDTO> getConsultList(int iDisplayStart, int iDisplayLength) {
		return consultManageDao.getConsultList(iDisplayStart, iDisplayLength);
	}

	public List<ConsultManageDTO> getConsultByState(int state, int iDisplayStart, int iDisplayLength) {
		if(state == 0) {
			return consultManageDao.getConsultList(iDisplayStart, iDisplayLength);
		}else {
			return consultManageDao.getConsultByState(state, iDisplayStart, iDisplayLength);
		}
		
	}
	
	public int update(int id, int state) {
		return consultManageDao.update(id, state);
	}
	public ConsultManageDTO getConsult(int id) {
		return consultManageDao.getConsult(id);
	}
	
	public int del(int id) {
		return consultManageDao.del(id);
	}
	
	public List<ConsultManageDTO> getConsultCountByState(int state) {
		if(state == 0) {
			return consultManageDao.getConsultCount();
		}else {
			return consultManageDao.getConsultCountByState(state);
		}
		
	}

}