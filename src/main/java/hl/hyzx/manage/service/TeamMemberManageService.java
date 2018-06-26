package hl.hyzx.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hl.hyzx.manage.dao.TeamMemberManageDao;
import hl.hyzx.manage.dto.TeamMemberManageDTO;

@Service
public class TeamMemberManageService {
	@Autowired
	TeamMemberManageDao teamMemberManageDao;

	public int save(String name, String position, int imgId, String positionalTitles, int teamType) {
		return teamMemberManageDao.save(name, position, imgId, positionalTitles,teamType);
	}

	public int update(int id, String name, String position, int imgId, String positionalTitles, int teamType) {
		return teamMemberManageDao.update(id, name, position, imgId, positionalTitles,teamType);
	}
	
	public List<TeamMemberManageDTO> getTeamMemberList(int iDisplayStart, int iDisplayLength) {
		return teamMemberManageDao.getTeamMemberList(iDisplayStart,iDisplayLength);
	}
	
	public List<TeamMemberManageDTO> getTeamMemberCount() {
		return teamMemberManageDao.getTeamMemberCount();
	}

	public TeamMemberManageDTO getTeamMember(int id) {
		return teamMemberManageDao.getTeamMember(id);
	}
	
	public int del(int id) {
		return teamMemberManageDao.del(id);
	}
	
}