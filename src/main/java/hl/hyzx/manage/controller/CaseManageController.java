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
import hl.hyzx.manage.dto.CaseManageDTO;
import hl.hyzx.manage.service.CaseManageService;

@Controller
@RequestMapping("manage/case")
public class CaseManageController {
	@Autowired
	CaseManageService caseManageService;

	@RequestMapping("getCaseList")
	@ResponseBody
	public Map<String, Object> getCaseList(int iDisplayStart, int iDisplayLength) {
		List<CaseManageDTO> list = caseManageService.getCaseList(iDisplayStart, iDisplayLength);
		int size = caseManageService.getCaseCount().size();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("iTotalRecords", size);
		map.put("iTotalDisplayRecords", size);
		map.put("aaData", list);
		return map;
	}
	
	@RequestMapping("save")
	@ResponseBody
	public R save(String name, String resume, int id, int imgId, String content) {
		int result = 0;
		if (id == 0)
			result = caseManageService.save(name, resume, imgId, content);
		else
			result = caseManageService.update(id, name, resume, imgId, content);

		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障！");
	}

	@RequestMapping("getCase/{id}")
	@ResponseBody
	public R getCase(@PathVariable("id") int id) {
		CaseManageDTO caseDate = caseManageService.getCase(id);
		return R.ok().put("caseDate", caseDate);
	}
	
	@RequestMapping("del/{id}")
	@ResponseBody
	public R del(@PathVariable("id") int id) {
		int result = caseManageService.del(id);
		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障");
	}
}