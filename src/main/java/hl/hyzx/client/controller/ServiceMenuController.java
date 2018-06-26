package hl.hyzx.client.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hl.hyzx.client.dto.ServiceMenuDTO;
import hl.hyzx.client.service.ServiceMenuService;
import hl.hyzx.common.Base;
import hl.hyzx.common.R;
import hl.hyzx.manage.dto.MenuManageDTO;
import hl.hyzx.manage.service.MenuManageService;


@Controller
public class ServiceMenuController extends Base {
	@Autowired
	ServiceMenuService serviceMenuService;
	
	@Autowired
	MenuManageService menuManageService;
	
	
	@RequestMapping("serviceMenuClient")
	public String manageConsultClient(Model model,int parentId) {
		List<MenuManageDTO> menuSelect =  menuManageService.getSelect(parentId);
		model.addAttribute("menuSelect", menuSelect);
		return "client/serviceMenu";
	}
	
	@RequestMapping("serviceMenuShow")
	@ResponseBody
	public R serviceMenuShow(int serviceMenuType) {
		ServiceMenuDTO serviceMenu =  serviceMenuService.getServiceMenu(serviceMenuType);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("serviceMenu", serviceMenu);
		return R.ok(map);
	}
	
}