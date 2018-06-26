package hl.hyzx.manage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hl.hyzx.common.R;
import hl.hyzx.manage.dto.ServiceMenuManageDTO;
import hl.hyzx.manage.service.ServiceMenuManageService;

@Controller
@RequestMapping("manage/serviceMenu")
public class ServiceMenuManageController {
	@Autowired
	ServiceMenuManageService serviceMenuManageService;

	@RequestMapping("getServiceMenuList")
	@ResponseBody
	public Map<String, Object> getServiceMenuList(int iDisplayStart, int iDisplayLength) {
		List<ServiceMenuManageDTO> list = serviceMenuManageService.getServiceMenuList(iDisplayStart, iDisplayLength);
		int size = serviceMenuManageService.getServiceMenuCount().size();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("iTotalRecords", size);
		map.put("iTotalDisplayRecords", size);
		map.put("aaData", list);
		return map;
	}

	@RequestMapping("save")
	@ResponseBody
	public R save(String title, int id, String content, int serviceMenuType, String typeName) {
		int result = 0;
		if (id == 0) {
			int count = serviceMenuManageService.getServiceMenuByType(serviceMenuType);
			if (count > 0) {
				return R.error("一个服务菜单下只能有一个菜单内容");
			}
			result = serviceMenuManageService.save(title, content, serviceMenuType, typeName);
		} else {
			result = serviceMenuManageService.update(id, title, content, serviceMenuType, typeName);
		}
		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障！");
	}

	@RequestMapping("getServiceMenu/{id}")
	@ResponseBody
	public R getServiceMenu(@PathVariable("id") int id) {
		ServiceMenuManageDTO serviceMenu = serviceMenuManageService.getServiceMenu(id);
		return R.ok().put("serviceMenu", serviceMenu);
	}

	@RequestMapping("del/{id}")
	@ResponseBody
	public R del(@PathVariable("id") int id) {
		int result = serviceMenuManageService.del(id);
		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障");
	}
}