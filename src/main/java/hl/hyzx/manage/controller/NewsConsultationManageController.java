package hl.hyzx.manage.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hl.hyzx.common.R;
import hl.hyzx.manage.dto.NewsConsultationManageDTO;
import hl.hyzx.manage.service.NewsConsultationManageService;

@Controller
@RequestMapping("manage/newsConsultation")
public class NewsConsultationManageController {
	@Autowired
	NewsConsultationManageService newsConsultationManageService;

	@RequestMapping("getNewsConsultationList")
	@ResponseBody
	public Map<String, Object> getNewsConsultationList(int iDisplayStart, int iDisplayLength) {
		List<NewsConsultationManageDTO> list = newsConsultationManageService.getNewsConsultationList(iDisplayStart, iDisplayLength);
		int size = newsConsultationManageService.getNewsConsultationCount().size();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("iTotalRecords", size);
		map.put("iTotalDisplayRecords", size);
		map.put("aaData", list);
		return map;
	}
	
	@RequestMapping("save")
	@ResponseBody
	public R save(String newsTitle, String author, int id, int imgId, String content, String newsTime) throws ParseException {
		int result = 0;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = sdf.parse(newsTime);  
		if (id == 0)
			result = newsConsultationManageService.save(newsTitle, author, imgId, content, date);
		else
			result = newsConsultationManageService.update(id, newsTitle, author, imgId, content, date);

		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障！");
	}

	@RequestMapping("getNewsConsultation/{id}")
	@ResponseBody
	public R getNewsConsultation(@PathVariable("id") int id) {
		NewsConsultationManageDTO newsConsultation = newsConsultationManageService.getNewsConsultation(id);
		return R.ok().put("newsConsultation", newsConsultation);
	}
	
	@RequestMapping("del/{id}")
	@ResponseBody
	public R del(@PathVariable("id") int id) {
		int result = newsConsultationManageService.del(id);
		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障");
	}
}