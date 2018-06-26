package hl.hyzx.client.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hl.hyzx.client.dto.NoticesDTO;
import hl.hyzx.client.service.NoticesService;
import hl.hyzx.common.Base;
import hl.hyzx.common.R;
import hl.hyzx.manage.dto.MenuManageDTO;
import hl.hyzx.manage.service.MenuManageService;


@Controller
public class NoticesController extends Base {
	@Autowired
	NoticesService noticesService;
	
	@Autowired
	MenuManageService menuManageService;
	
	@RequestMapping("noticeClient")
	public String noticeClient(Model model,int parentId) {
		List<MenuManageDTO> menuSelect =  menuManageService.getSelect(parentId);
		model.addAttribute("menuSelect", menuSelect);
		return "client/notices";
	}
	
	@RequestMapping("noticeShow")
	@ResponseBody
	public R noticeShow(int noticeType,int currPage) {
		List<NoticesDTO> notices =  noticesService.getNoticeList(noticeType,(currPage - 1) * 6, 6);
		int count = noticesService.getNoticeCount(noticeType);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("notices", notices);
		map.put("noticeType", noticeType);
		map.put("currPage", currPage);
		map.put("count", count);
		map.put("pageCount", page(count, 6));
		return R.ok(map);
	}
	
}