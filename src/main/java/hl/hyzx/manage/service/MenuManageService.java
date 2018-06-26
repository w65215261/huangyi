package hl.hyzx.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hl.hyzx.manage.dao.MenuManageDao;
import hl.hyzx.manage.dto.MenuManageDTO;

@Service
public class MenuManageService {
	@Autowired
	MenuManageDao menuManageDao;

	public int save(int parentId, String parentName, String name) {
		return menuManageDao.save(parentId, parentName, name);
	}

	public int update(int id, int parentId, String parentName, String name) {
		return menuManageDao.update(id, parentId, parentName, name);
	}

	public List<MenuManageDTO> getMenuList(int iDisplayStart, int iDisplayLength) {
		return menuManageDao.getMenuList(iDisplayStart, iDisplayLength);
	}

	public List<MenuManageDTO> getMenuCount() {
		return menuManageDao.getMenuCount();
	}

	public MenuManageDTO getMenu(int id) {
		return menuManageDao.getMenu(id);
	}

	public int del(int id) {
		return menuManageDao.del(id);
	}
	
	public List<MenuManageDTO> getMenuSelect() {
		return menuManageDao.getMenuSelect();
	}
	
	public List<MenuManageDTO> getSelect(int parentId) {
		return menuManageDao.getSelect(parentId);
	}
	
}