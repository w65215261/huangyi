package hl.hyzx.client.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hl.hyzx.client.dao.HomeDao;
import hl.hyzx.client.dto.HomeDTO;
import hl.hyzx.manage.dto.CaseManageDTO;
import hl.hyzx.manage.dto.ModuleResumeManageDTO;
import hl.hyzx.manage.dto.NewsConsultationManageDTO;
import hl.hyzx.manage.dto.OpinionManageDTO;
import hl.hyzx.manage.dto.SynopsisManageDTO;
import hl.hyzx.manage.dto.TeamMemberManageDTO;

@Service
public class HomeService {
	@Autowired
	HomeDao homeDao;

	public List<HomeDTO> getBanners() {
		return homeDao.getBanners();
	}

	public List<CaseManageDTO> getCaseList() {
		return homeDao.getCaseList();
	}

	public void getModuleResumeList(Model model) {
		List<ModuleResumeManageDTO> mrms = homeDao.getModuleResumeList();
		for (ModuleResumeManageDTO mrm : mrms) {
			int moduleType = mrm.getModuleType();
			if (moduleType == 1) {
				model.addAttribute("moduleCase", mrm);
			} else if (moduleType == 2) {
				model.addAttribute("moduleTeam", mrm);
			} else if (moduleType == 3) {
				model.addAttribute("moduleOpinion", mrm);
			} else {
				model.addAttribute("moduleNews", mrm);
			}

		}
	}

	public List<TeamMemberManageDTO> getTeamMemberList() {
		return homeDao.getTeamMemberList();
	}

	public void getTeamMemberTitlesList(Model model) {
		List<TeamMemberManageDTO> tmms = homeDao.getTeamMemberList();
		List<TeamMemberManageDTO> leads = new ArrayList<TeamMemberManageDTO>();
		List<TeamMemberManageDTO> staffs = new ArrayList<TeamMemberManageDTO>();
		for (TeamMemberManageDTO tmm : tmms) {
			if (tmm.getTeamType() == 1) {
				leads.add(tmm);
			} else {
				staffs.add(tmm);
			}
		}
		model.addAttribute("leads", leads);
		model.addAttribute("staffs", staffs);
	}

	public SynopsisManageDTO getSynopsis() {
		List<SynopsisManageDTO> synopsisManageDTOList = new ArrayList<SynopsisManageDTO>();
		synopsisManageDTOList = homeDao.getSynopsisList();
		if (synopsisManageDTOList.size() != 0) {
			return synopsisManageDTOList.get(0);
		} else {
			return new SynopsisManageDTO();
		}

	}
	
	public OpinionManageDTO getOpinion() {
		List<OpinionManageDTO> opinionManageDTOList = new ArrayList<OpinionManageDTO>();
		opinionManageDTOList = homeDao.getOpinionList();
		if (opinionManageDTOList.size() != 0) {
			return opinionManageDTOList.get(0);
		} else {
			return new OpinionManageDTO();
		}

	}
	
	public List<NewsConsultationManageDTO> getNewsConsultationList() {

		String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
		String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
		String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式

		Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
		Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
		Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);

		Calendar cal = Calendar.getInstance();
		List<NewsConsultationManageDTO> newsConsultationList = homeDao.getNewsConsultationList();
		for (NewsConsultationManageDTO nc : newsConsultationList) {
			String content = nc.getContent();
			Matcher m_script = p_script.matcher(content);
			content = m_script.replaceAll("");// 过滤script标签
			Matcher m_style = p_style.matcher(content);
			content = m_style.replaceAll(""); // 过滤style标签
			Matcher m_html = p_html.matcher(content);
			content = m_html.replaceAll(""); // 过滤html标签
			if (content.length() > 100) {
				content = content.substring(0, 100);
			}
			nc.setContentCutOut(content + "......");

			cal.setTime(nc.getNewsTime());
			nc.setDateMonth(cal.get(Calendar.MONTH) + 1 + "月");
			nc.setDateDay(cal.get(Calendar.DATE) + "");
		}
		return newsConsultationList;
	}
}