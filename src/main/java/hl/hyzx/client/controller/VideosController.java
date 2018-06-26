package hl.hyzx.client.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hl.hyzx.client.dto.VideosDTO;
import hl.hyzx.client.service.VideosService;
import hl.hyzx.common.Base;
import hl.hyzx.common.R;
import hl.hyzx.manage.dto.MenuManageDTO;
import hl.hyzx.manage.service.MenuManageService;

@Controller
public class VideosController extends Base {
	@Autowired
	VideosService videosService;
	@Autowired
	MenuManageService menuManageService;

	@RequestMapping("videoClient")
	public String videoClient(Model model, int parentId) {
		List<MenuManageDTO> menuSelect = menuManageService.getSelect(parentId);
		model.addAttribute("menuSelect", menuSelect);
		return "client/videos";
	}

	@RequestMapping("videoShow")
	@ResponseBody
	public R videoShow(int classification, int currPage) {
		List<VideosDTO> videos = videosService.getVideoList(classification, (currPage - 1) * 6, 6);
		int count = videosService.getVideoCount(classification);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("videos", videos);
		map.put("classification", classification);
		map.put("currPage", currPage);
		map.put("count", count);
		map.put("pageCount", page(count, 6));
		return R.ok(map);
	}
}