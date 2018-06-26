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
import hl.hyzx.manage.dto.ConsultManageDTO;
import hl.hyzx.manage.service.ConsultManageService;

@Controller
@RequestMapping("manage/consult")
public class ConsultManageController {
	@Autowired
	ConsultManageService consultManageService;
	
	@RequestMapping("getConsultByState")
	@ResponseBody
	public Map<String, Object> getConsultByState(int state,int iDisplayStart, int iDisplayLength) {
		List<ConsultManageDTO> list = consultManageService.getConsultByState(state,iDisplayStart, iDisplayLength);
		int size = consultManageService.getConsultCountByState(state).size();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("iTotalRecords", size);
		map.put("iTotalDisplayRecords", size);
		map.put("aaData", list);
		return map;
	}

	@RequestMapping("save")
	@ResponseBody
	public R save(int id, int state) {
		int result = 0;
		result = consultManageService.update(id, state);
		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障！");
	}

	@RequestMapping("getConsult/{id}")
	@ResponseBody
	public R getConsult(@PathVariable("id") int id) {
		ConsultManageDTO consultDate = consultManageService.getConsult(id);
		return R.ok().put("consultDate", consultDate);
	}

	@RequestMapping("del/{id}")
	@ResponseBody
	public R del(@PathVariable("id") int id) {
		int result = consultManageService.del(id);
		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障");
	}
}