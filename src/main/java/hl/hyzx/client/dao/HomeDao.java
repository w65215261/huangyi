package hl.hyzx.client.dao;

import java.util.List;

import hl.hyzx.client.dto.HomeDTO;
import hl.hyzx.manage.dto.CaseManageDTO;
import hl.hyzx.manage.dto.ModuleResumeManageDTO;
import hl.hyzx.manage.dto.NewsConsultationManageDTO;
import hl.hyzx.manage.dto.OpinionManageDTO;
import hl.hyzx.manage.dto.SynopsisManageDTO;
import hl.hyzx.manage.dto.TeamMemberManageDTO;

public interface HomeDao {

	List<HomeDTO> getBanners();
	List<SynopsisManageDTO> getSynopsisList();
	List<OpinionManageDTO> getOpinionList();
	List<CaseManageDTO> getCaseList();
	List<ModuleResumeManageDTO> getModuleResumeList();
	List<TeamMemberManageDTO> getTeamMemberList();
	List<NewsConsultationManageDTO> getNewsConsultationList();
}