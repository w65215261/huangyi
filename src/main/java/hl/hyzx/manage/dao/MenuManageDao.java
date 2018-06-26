package hl.hyzx.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hl.hyzx.manage.dto.MenuManageDTO;

public interface MenuManageDao {

	List<MenuManageDTO> getMenuList(@Param("iDisplayStart") int iDisplayStart,
			@Param("iDisplayLength") int iDisplayLength);

	List<MenuManageDTO> getMenuCount();

	int save(@Param("parentId") int parentId, @Param("parentName") String parentName, @Param("name") String name);

	int update(@Param("id") int id, @Param("parentId") int parentId, @Param("parentName") String parentName,
			@Param("name") String name);

	MenuManageDTO getMenu(int id);

	int del(int id);

	List<MenuManageDTO> getMenuSelect();
	
	List<MenuManageDTO> getSelect(@Param("parentId") int parentId);

}