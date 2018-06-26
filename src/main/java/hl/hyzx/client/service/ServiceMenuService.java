package hl.hyzx.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hl.hyzx.client.dao.ServiceMenuDao;
import hl.hyzx.client.dto.ServiceMenuDTO;

@Service
public class ServiceMenuService {
	@Autowired
	ServiceMenuDao serviceMenuDao;

	public ServiceMenuDTO getServiceMenu(int serviceMenuType) {
		return serviceMenuDao.getServiceMenu(serviceMenuType);
	}
}