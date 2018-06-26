package hl.hyzx.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hl.hyzx.manage.dao.ServiceMenuManageDao;
import hl.hyzx.manage.dto.ServiceMenuManageDTO;

@Service
public class ServiceMenuManageService {
	@Autowired
	ServiceMenuManageDao serviceMenuManageDao;

	public int save(String title, String content, int serviceMenuType, String typeName) {
		return serviceMenuManageDao.save(title, content, serviceMenuType, typeName);
	}

	public int update(int id, String title, String content, int serviceMenuType, String typeName) {
		return serviceMenuManageDao.update(id, title, content, serviceMenuType, typeName);
	}

	public List<ServiceMenuManageDTO> getServiceMenuList(int iDisplayStart, int iDisplayLength) {
		return serviceMenuManageDao.getServiceMenuList(iDisplayStart, iDisplayLength);
	}

	public List<ServiceMenuManageDTO> getServiceMenuCount() {
		return serviceMenuManageDao.getServiceMenuCount();
	}

	public ServiceMenuManageDTO getServiceMenu(int id) {
		return serviceMenuManageDao.getServiceMenu(id);
	}

	public int del(int id) {
		return serviceMenuManageDao.del(id);
	}
	
	public int getServiceMenuByType(int serviceMenuType) {
		return serviceMenuManageDao.getServiceMenuByType(serviceMenuType);
	}
	
}