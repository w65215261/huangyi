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
import hl.hyzx.manage.dto.NoticesManageDTO;
import hl.hyzx.manage.service.NoticesManageService;

@Controller
@RequestMapping("manage/notice")
public class NoticesManageController {
	@Autowired
	NoticesManageService noticesManageService;

	@RequestMapping("getNoticeList")
	@ResponseBody
	public Map<String, Object> getNoticeList(int iDisplayStart, int iDisplayLength) {
		List<NoticesManageDTO> list = noticesManageService.getNoticeList(iDisplayStart, iDisplayLength);
		int size = noticesManageService.getNoticeCount().size();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("iTotalRecords", size);
		map.put("iTotalDisplayRecords", size);
		map.put("aaData", list);
		return map;
	}
	
	@RequestMapping("save")
	@ResponseBody
	public R save(String title, int id, int imgId, String content, int noticeType, String typeName) {
		int result = 0;
		if (id == 0)
			result = noticesManageService.save(title, imgId, content, noticeType, typeName);
		else
			result = noticesManageService.update(id, title, imgId, content, noticeType, typeName);

		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障！");
	}

	@RequestMapping("getNotice/{id}")
	@ResponseBody
	public R getNotice(@PathVariable("id") int id) {
		NoticesManageDTO notices = noticesManageService.getNotice(id);
		return R.ok().put("notices", notices);
	}
	
	@RequestMapping("del/{id}")
	@ResponseBody
	public R del(@PathVariable("id") int id) {
		int result = noticesManageService.del(id);
		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障");
	}
}