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
import hl.hyzx.manage.dto.VideoManageDTO;
import hl.hyzx.manage.service.VideoManageService;

@Controller
@RequestMapping("manage/video")
public class VideoManageController {
	@Autowired
	VideoManageService videoManageService;

	@RequestMapping("getVideoList")
	@ResponseBody
	public Map<String, Object> getVideoList(int iDisplayStart, int iDisplayLength) {
		List<VideoManageDTO> list = videoManageService.getVideoList(iDisplayStart, iDisplayLength);
		int size = videoManageService.getVideoCount().size();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("iTotalRecords", size);
		map.put("iTotalDisplayRecords", size);
		map.put("aaData", list);
		return map;
	}

	@RequestMapping("save")
	@ResponseBody
	public R save(String name, String resume, String videoName, int id, int videoId, int imgId, int classification,
			String classificationName, String content) {
		int result = 0;
		if (id == 0)
			result = videoManageService.save(name, resume, videoName, videoId, imgId, classification,
					classificationName, content);
		else
			result = videoManageService.update(id, name, resume, videoName, videoId, imgId, classification,
					classificationName, content);

		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障！");
	}

	@RequestMapping("getVideo/{id}")
	@ResponseBody
	public R getVideo(@PathVariable("id") int id) {
		VideoManageDTO video = videoManageService.getVideo(id);
		return R.ok().put("video", video);
	}

	@RequestMapping("del/{id}")
	@ResponseBody
	public R del(@PathVariable("id") int id) {
		int result = videoManageService.del(id);
		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障");
	}
}