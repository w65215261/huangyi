package hl.hyzx.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hl.hyzx.manage.dto.ModuleResumeManageDTO;

public interface ModuleResumeManageDao {

	List<ModuleResumeManageDTO> getModuleResumeList(@Param("iDisplayStart") int iDisplayStart,
			@Param("iDisplayLength") int iDisplayLength);

	List<ModuleResumeManageDTO> getModuleResumeCount();
	
	List<ModuleResumeManageDTO> queryByModuleType(@Param("moduleType") int moduleType);
	
	int save(@Param("moduleType") int moduleType, @Param("resume") String resume, @Param("imgId") int imgId);

	int update(@Param("id") int id, @Param("moduleType") int moduleType, @Param("resume") String resume,
			@Param("imgId") int imgId);

	ModuleResumeManageDTO getModuleResume(int id);

	int del(int id);
}