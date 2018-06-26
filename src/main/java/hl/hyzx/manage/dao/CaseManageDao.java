package hl.hyzx.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hl.hyzx.manage.dto.CaseManageDTO;

public interface CaseManageDao {

	List<CaseManageDTO> getCaseList(@Param("iDisplayStart") int iDisplayStart, @Param("iDisplayLength") int iDisplayLength);
	
	List<CaseManageDTO> getCaseCount();

	int save(@Param("name") String name, @Param("resume") String resume, @Param("imgId") int imgId,
			@Param("content") String content);

	int update(@Param("id") int id, @Param("name") String name, @Param("resume") String resume,
			@Param("imgId") int imgId, @Param("content") String content);

	CaseManageDTO getCase(int id);
	
	int del(int id);
}