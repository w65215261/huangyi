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
import hl.hyzx.manage.dto.TeamMemberManageDTO;
import hl.hyzx.manage.service.TeamMemberManageService;

@Controller
@RequestMapping("manage/teamMember")
public class TeamMemberManageController {
	@Autowired
	TeamMemberManageService teamMemberManageService;

	@RequestMapping("getTeamMemberList")
	@ResponseBody
	public Map<String, Object> getTeamMemberList(int iDisplayStart, int iDisplayLength) {
		List<TeamMemberManageDTO> list = teamMemberManageService.getTeamMemberList(iDisplayStart, iDisplayLength);
		int size = teamMemberManageService.getTeamMemberCount().size();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("iTotalRecords", size);
		map.put("iTotalDisplayRecords", size);
		map.put("aaData", list);
		return map;
	}

	@RequestMapping("save")
	@ResponseBody
	public R save(String name, String position, int id, int imgId, String positionalTitles, int teamType) {
		int result = 0;
		if (id == 0)
			result = teamMemberManageService.save(name, position, imgId, positionalTitles,teamType);
		else
			result = teamMemberManageService.update(id, name, position, imgId, positionalTitles,teamType);

		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障！");
	}

	@RequestMapping("getTeamMember/{id}")
	@ResponseBody
	public R getTeamMember(@PathVariable("id") int id) {
		TeamMemberManageDTO teamMember = teamMemberManageService.getTeamMember(id);
		return R.ok().put("teamMember", teamMember);
	}

	@RequestMapping("del/{id}")
	@ResponseBody
	public R del(@PathVariable("id") int id) {
		int result = teamMemberManageService.del(id);
		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障");
	}
}