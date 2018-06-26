package hl.hyzx.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hl.hyzx.common.R;
import hl.hyzx.manage.dto.OpinionManageDTO;
import hl.hyzx.manage.service.OpinionManageService;

@Controller
@RequestMapping("manage/opinion")
public class OpinionManageController {
	@Autowired
	OpinionManageService opinionManageService;

	@RequestMapping("save")
	@ResponseBody
	public R save(int id, int imgId, String content) {
		int result = 0;
		if (id == 0)
			result = opinionManageService.save(imgId, content);
		else
			result = opinionManageService.update(id, imgId, content);

		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障！");
	}
	
	@RequestMapping("getOpinion/{id}")
	@ResponseBody
	public R getOpinion(@PathVariable("id") int id) {
		OpinionManageDTO opinion = opinionManageService.getOpinion(id);
		return R.ok().put("opinion", opinion);
	}
}