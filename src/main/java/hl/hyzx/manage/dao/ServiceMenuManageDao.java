package hl.hyzx.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hl.hyzx.manage.dto.ServiceMenuManageDTO;

public interface ServiceMenuManageDao {

	List<ServiceMenuManageDTO> getServiceMenuList(@Param("iDisplayStart") int iDisplayStart,
			@Param("iDisplayLength") int iDisplayLength);

	List<ServiceMenuManageDTO> getServiceMenuCount();

	int save(@Param("title") String title, @Param("content") String content,
			@Param("serviceMenuType") int serviceMenuType, @Param("typeName") String typeName);

	int update(@Param("id") int id, @Param("title") String title, @Param("content") String content,
			@Param("serviceMenuType") int serviceMenuType, @Param("typeName") String typeName);

	ServiceMenuManageDTO getServiceMenu(int id);

	int del(int id);
	
	int getServiceMenuByType(@Param("serviceMenuType") int serviceMenuType);
}