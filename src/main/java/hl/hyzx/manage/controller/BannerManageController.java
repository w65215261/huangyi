package hl.hyzx.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hl.hyzx.common.R;
import hl.hyzx.manage.dto.BannerManageDTO;
import hl.hyzx.manage.service.BannerManageService;

@Controller
@RequestMapping("manage/banner")
public class BannerManageController {

	@Autowired
	BannerManageService bannerManageService;

	@RequestMapping("save")
	@ResponseBody
	public R save(int id, String name, String bannerLink, String state, int imgId) {
		int result = 0;
		if (id == 0)
			result = bannerManageService.save(name, bannerLink, state, imgId);
		else
			result = bannerManageService.update(id, name, bannerLink, state, imgId);

		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障");
	}
	
	@RequestMapping("getBanner/{bannerId}")
	@ResponseBody
	public R getBanner(@PathVariable("bannerId") int id) {
		BannerManageDTO banner = bannerManageService.getBanner(id);
		return R.ok().put("banner", banner);
	}

	@RequestMapping("del/{id}")
	@ResponseBody
	public R del(@PathVariable("id") int id) {
		int result = bannerManageService.del(id);
		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障");
	}
}