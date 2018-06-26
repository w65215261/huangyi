package hl.hyzx.client.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class FlowPathController {
	
	@RequestMapping("flowPathClient")
	public String flowPathClient(Model model) {
		return "client/flowPath";
	}
	
}