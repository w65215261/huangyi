package hl.hyzx.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hl.hyzx.client.service.HomeService;
import hl.hyzx.manage.dto.OpinionManageDTO;
import hl.hyzx.manage.dto.SynopsisManageDTO;


@Controller
public class IntoController {
	@Autowired
	HomeService homeService;
	
	@RequestMapping("intoClient")
	public String intoClient(Model model) {
		SynopsisManageDTO synopsis = homeService.getSynopsis();
		OpinionManageDTO opinion = homeService.getOpinion();
		model.addAttribute("synopsis", synopsis);
		model.addAttribute("opinion", opinion);
		return "client/into";
	}
}