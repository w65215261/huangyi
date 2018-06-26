package hl.hyzx.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hl.hyzx.common.R;
import hl.hyzx.manage.dto.SynopsisManageDTO;
import hl.hyzx.manage.service.SynopsisManageService;

@Controller
@RequestMapping("manage/synopsis")
public class SynopsisManageController {
	@Autowired
	SynopsisManageService synopsisManageService;

	@RequestMapping("save")
	@ResponseBody
	public R save(int id, int imgId, String content) {
		int result = 0;
		if (id == 0)
			result = synopsisManageService.save(imgId, content);
		else
			result = synopsisManageService.update(id, imgId, content);

		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障！");
	}
	
	@RequestMapping("getSynopsis/{id}")
	@ResponseBody
	public R getSynopsis(@PathVariable("id") int id) {
		SynopsisManageDTO synopsis = synopsisManageService.getSynopsis(id);
		return R.ok().put("synopsis", synopsis);
	}
}