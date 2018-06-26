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
import hl.hyzx.manage.dto.ModuleResumeManageDTO;
import hl.hyzx.manage.service.ModuleResumeManageService;

@Controller
@RequestMapping("manage/moduleResume")
public class ModuleResumeManageController {
	@Autowired
	ModuleResumeManageService moduleResumeManageService;

	@RequestMapping("getModuleResumeList")
	@ResponseBody
	public Map<String, Object> getModuleResumeList(int iDisplayStart, int iDisplayLength) {
		List<ModuleResumeManageDTO> list = moduleResumeManageService.getModuleResumeList(iDisplayStart, iDisplayLength);
		int size = moduleResumeManageService.getModuleResumeCount().size();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("iTotalRecords", size);
		map.put("iTotalDisplayRecords", size);
		map.put("aaData", list);
		return map;
	}

	@RequestMapping("save")
	@ResponseBody
	public R save(int moduleType, String resume, int id, int imgId) {
		int result = 0;
		if (id == 0)
			result = moduleResumeManageService.save(moduleType, resume, imgId);
		else
			result = moduleResumeManageService.update(id, moduleType, resume, imgId);

		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障！");
	}

	@RequestMapping("getModuleResume/{id}")
	@ResponseBody
	public R getModuleResume(@PathVariable("id") int id) {
		ModuleResumeManageDTO moduleResume = moduleResumeManageService.getModuleResume(id);
		return R.ok().put("moduleResume", moduleResume);
	}

	@RequestMapping("queryByModuleType")
	@ResponseBody
	public R queryByModuleType(int moduleType, int id) {
		if(id == 0) {
			int size = moduleResumeManageService.queryByModuleType(moduleType).size();
			if (size == 0) {
				return R.ok();
			} else {
				return R.error("该栏目已经存在,不能再次添加！");
			}
		}
		return R.ok();
	}

	@RequestMapping("del/{id}")
	@ResponseBody
	public R del(@PathVariable("id") int id) {
		int result = moduleResumeManageService.del(id);
		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障");
	}
}