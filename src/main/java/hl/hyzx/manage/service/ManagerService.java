package hl.hyzx.manage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hl.hyzx.manage.dao.ManagerDao;
import hl.hyzx.manage.dto.ManagerDTO;

@Service
public class ManagerService {

	@Autowired
	ManagerDao managerDao;

	public ManagerDTO getManager(String username, String password) {
		return managerDao.getManager(username, password);
	}
}
