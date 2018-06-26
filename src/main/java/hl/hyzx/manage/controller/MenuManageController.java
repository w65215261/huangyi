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
import hl.hyzx.manage.dto.MenuManageDTO;
import hl.hyzx.manage.service.MenuManageService;

@Controller
@RequestMapping("manage/menu")
public class MenuManageController {
	@Autowired
	MenuManageService menuManageService;

	@RequestMapping("getMenuList")
	@ResponseBody
	public Map<String, Object> getMenuList(int iDisplayStart, int iDisplayLength) {
		List<MenuManageDTO> list = menuManageService.getMenuList(iDisplayStart, iDisplayLength);
		int size = menuManageService.getMenuCount().size();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("iTotalRecords", size);
		map.put("iTotalDisplayRecords", size);
		map.put("aaData", list);
		return map;
	}

	@RequestMapping("save")
	@ResponseBody
	public R save(int id, int parentId, String parentName, String name) {
		int result = 0;
		if (id == 0)
			result = menuManageService.save(parentId, parentName, name);
		else
			result = menuManageService.update(id, parentId, parentName, name);

		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障！");
	}

	@RequestMapping("getMenu/{id}")
	@ResponseBody
	public R getMenu(@PathVariable("id") int id) {
		MenuManageDTO menu = menuManageService.getMenu(id);
		return R.ok().put("menu", menu);
	}

	@RequestMapping("del/{id}")
	@ResponseBody
	public R del(@PathVariable("id") int id) {
		int result = menuManageService.del(id);
		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障");
	}
	
	@RequestMapping("getMenuSelect")
	@ResponseBody
	public Map<String, Object> getMenu1Select() {
		List<MenuManageDTO> menuSelect = menuManageService.getMenuSelect();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("menuSelect", menuSelect);
		return map;
	}
	
}