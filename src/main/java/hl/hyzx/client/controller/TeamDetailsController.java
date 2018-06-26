package hl.hyzx.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import hl.hyzx.client.service.HomeService;

@Controller
public class TeamDetailsController {

	@Autowired
	HomeService homeService;

	@RequestMapping("teamDetails")
	public String teamDetails(Model model) {
		homeService.getTeamMemberTitlesList(model);
		return "client/teamDetails";
	}

}