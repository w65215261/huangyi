package hl.hyzx.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hl.hyzx.manage.dto.TeamMemberManageDTO;

public interface TeamMemberManageDao {

	List<TeamMemberManageDTO> getTeamMemberList(@Param("iDisplayStart") int iDisplayStart, @Param("iDisplayLength") int iDisplayLength);
	
	List<TeamMemberManageDTO> getTeamMemberCount();

	int save(@Param("name") String name, @Param("position") String position, @Param("imgId") int imgId,
			@Param("positionalTitles") String positionalTitles, @Param("teamType") int teamType);

	int update(@Param("id") int id, @Param("name") String name, @Param("position") String position,
			@Param("imgId") int imgId, @Param("positionalTitles") String positionalTitles, @Param("teamType") int teamType);

	TeamMemberManageDTO getTeamMember(int id);
	
	int del(int id);
}