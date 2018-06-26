package hl.hyzx.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hl.hyzx.common.Base;
import hl.hyzx.manage.dto.BannerManageDTO;
import hl.hyzx.manage.dto.MenuManageDTO;
import hl.hyzx.manage.dto.OpinionManageDTO;
import hl.hyzx.manage.dto.SynopsisManageDTO;
import hl.hyzx.manage.service.BannerManageService;
import hl.hyzx.manage.service.MenuManageService;
import hl.hyzx.manage.service.OpinionManageService;
import hl.hyzx.manage.service.SynopsisManageService;

@Controller
@RequestMapping("manage")
public class CenterController extends Base {

	@Autowired
	BannerManageService bannerManageService;

	@Autowired
	SynopsisManageService synopsisManageService;
	
	@Autowired
	OpinionManageService opinionManageService;
	
	@Autowired
	MenuManageService menuManageService;

	@RequestMapping("index")
	public String index() {
		return "manage/index";
	}

	@RequestMapping("center")
	public String center() {
		return "manage/center";
	}

	@RequestMapping("bannerManage")
	public String shouyeguanli(Model model) {
		List<BannerManageDTO> banners = bannerManageService.getBannerList();
		model.addAttribute("banners", banners);
		return "manage/bannerManage";
	}

	@RequestMapping("synopsisManage")
	public String synopsis(Model model) {
		List<SynopsisManageDTO> synopsiss = synopsisManageService.getSynopsisList();
		model.addAttribute("synopsiss", synopsiss);
		model.addAttribute("size", synopsiss.size());
		return "manage/synopsisManage";
	}

	@RequestMapping("caseManage")
	public String caseManage() {
		return "manage/caseManage";
	}

	@RequestMapping("teamMemberManage")
	public String teamMemberManage() {
		return "manage/teamMemberManage";
	}

	@RequestMapping("newsConsultationManage")
	public String newsConsultationManage() {
		return "manage/newsConsultationManage";
	}

	@RequestMapping("moduleResumeManage")
	public String moduleResumeManage() {
		return "manage/moduleResumeManage";
	}

	@RequestMapping("videoManage")
	public String videoManage(Model model,int parentId) {
		List<MenuManageDTO> videoSelect = menuManageService.getSelect(parentId);
		model.addAttribute("videoSelect", videoSelect);
		return "manage/videoManage";
	}

	@RequestMapping("opinionManage")
	public String opinionManage(Model model) {
		List<OpinionManageDTO> opinions = opinionManageService.getOpinionList();
		model.addAttribute("opinions", opinions);
		model.addAttribute("size", opinions.size());
		return "manage/opinionManage";
	}
	
	@RequestMapping("menuManage")
	public String menuManage() {
		return "manage/menuManage";
	}
	
	@RequestMapping("consultManage")
	public String consultManage() {
		return "manage/consultManage";
	}
	
	@RequestMapping("noticeManage")
	public String noticeManage(Model model,int parentId) {
		List<MenuManageDTO> noticeSelect = menuManageService.getSelect(parentId);
		model.addAttribute("noticeSelect", noticeSelect);
		return "manage/noticeManage";
	}
	
	@RequestMapping("serviceMenuManage")
	public String serviceMenuManage(Model model,int parentId) {
		List<MenuManageDTO> serviceMenuSelect = menuManageService.getSelect(parentId);
		model.addAttribute("serviceMenuSelect", serviceMenuSelect);
		return "manage/serviceMenuManage";
	}
	
	@RequestMapping("contactManage")
	public String contactManage() {
		return "manage/contactManage";
	}
	@RequestMapping("signUpManage")
	public String signUpManage() {
		return "manage/signUpManage";
	}
	
	@RequestMapping("signUpShowManage")
	public String signUpShowManage() {
		return "manage/signUpShowManage";
	}
	
}