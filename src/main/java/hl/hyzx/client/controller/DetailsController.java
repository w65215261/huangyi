package hl.hyzx.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hl.hyzx.client.dto.DetailsDTO;
import hl.hyzx.client.service.DetailsService;


@Controller
public class DetailsController {
	@Autowired
	DetailsService detailsService;

	@RequestMapping("caseClient")
	public String caseClient(int id,Model model) {
		DetailsDTO details = detailsService.getCase(id);
		model.addAttribute("details", details);
		model.addAttribute("flag", 0);
		model.addAttribute("title", "案例详情");
		return "client/details";
	}
	
	@RequestMapping("newsConsultationClient")
	public String newsConsultationClient(int id,Model model) {
		DetailsDTO details = detailsService.getNewsConsultation(id);
		model.addAttribute("details", details);
		model.addAttribute("flag", 0);
		model.addAttribute("title", "详情");
		return "client/details";
	}
	
	@RequestMapping("noticesClient")
	public String noticesClient(int id,Model model) {
		DetailsDTO details = detailsService.getNotices(id);
		model.addAttribute("details", details);
		model.addAttribute("flag", 1);
		model.addAttribute("menuUrl", "noticeClient?parentId=2");
		model.addAttribute("fTitle", "皇壹动态");
		model.addAttribute("title", "详情");
		return "client/details";
	}
	
	@RequestMapping("videosClient")
	public String videosClient(int id,Model model) {
		DetailsDTO details = detailsService.getVideos(id);
		model.addAttribute("details", details);
		model.addAttribute("video", 1);
		model.addAttribute("flag", 1);
		model.addAttribute("menuUrl", "videoClient?parentId=1");
		model.addAttribute("fTitle", "皇壹商学院");
		model.addAttribute("title", "详情");
		return "client/details";
	}
	
	@RequestMapping("signUpsClient")
	public String signUpsClient(int id,Model model) {
		DetailsDTO details = detailsService.getSignUps(id);
		model.addAttribute("details", details);
		model.addAttribute("flag", 1);
		model.addAttribute("signId", id);
		model.addAttribute("menuUrl", "consultClient");
		model.addAttribute("fTitle", "咨询报名");
		model.addAttribute("title", "详情");
		return "client/consultdetails";
	}
}