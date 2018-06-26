package hl.hyzx.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hl.hyzx.manage.dto.ConsultManageDTO;

public interface ConsultManageDao {

	List<ConsultManageDTO> getConsultList(@Param("iDisplayStart") int iDisplayStart,
			@Param("iDisplayLength") int iDisplayLength);

	List<ConsultManageDTO> getConsultByState(@Param("state") int state, @Param("iDisplayStart") int iDisplayStart,
			@Param("iDisplayLength") int iDisplayLength);
	
	List<ConsultManageDTO> getConsultCount();
	
	List<ConsultManageDTO> getConsultCountByState(@Param("state") int state);

	int update(@Param("id") int id, @Param("state") int state);
	
	ConsultManageDTO getConsult(int id);
	
	int del(int id);

}