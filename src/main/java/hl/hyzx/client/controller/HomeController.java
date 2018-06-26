package hl.hyzx.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hl.hyzx.client.dto.HomeDTO;
import hl.hyzx.client.service.HomeService;
import hl.hyzx.manage.dto.CaseManageDTO;
import hl.hyzx.manage.dto.NewsConsultationManageDTO;
import hl.hyzx.manage.dto.SynopsisManageDTO;
import hl.hyzx.manage.dto.TeamMemberManageDTO;


@Controller
public class HomeController {
	@Autowired
	HomeService homeService;

	@RequestMapping("")
	public String queryBanners(Model model) {
		List<HomeDTO> banners = homeService.getBanners();
		List<CaseManageDTO> cases = homeService.getCaseList();
		homeService.getModuleResumeList(model);
		List<TeamMemberManageDTO> teamMembers = homeService.getTeamMemberList();
		List<NewsConsultationManageDTO> newsConsultations = homeService.getNewsConsultationList();
		SynopsisManageDTO synopsis = homeService.getSynopsis();
		model.addAttribute("banners", banners);
		model.addAttribute("synopsis", synopsis);
		model.addAttribute("cases", cases);
		model.addAttribute("teamMembers", teamMembers);
		model.addAttribute("newsConsultations", newsConsultations);
		return "client/index";
	}
}