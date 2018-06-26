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
import hl.hyzx.manage.dto.ContactManageDTO;
import hl.hyzx.manage.service.ContactManageService;

@Controller
@RequestMapping("manage/contact")
public class ContactManageController {
	@Autowired
	ContactManageService contactManageService;

	@RequestMapping("getContactList")
	@ResponseBody
	public Map<String, Object> getContactList(int iDisplayStart, int iDisplayLength) {
		List<ContactManageDTO> list = contactManageService.getContactList(iDisplayStart, iDisplayLength);
		int size = contactManageService.getContactCount().size();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("iTotalRecords", size);
		map.put("iTotalDisplayRecords", size);
		map.put("aaData", list);
		return map;
	}

	@RequestMapping("save")
	@ResponseBody
	public R save(int id, String content, String address, String phone, String mailbox, String x, String y) {
		int result = 0;
		if (id == 0)
			result = contactManageService.save(content, address, phone, mailbox, x, y);
		else
			result = contactManageService.update(id, content, address, phone, mailbox, x, y);

		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障！");
	}

	@RequestMapping("getContact/{id}")
	@ResponseBody
	public R getContact(@PathVariable("id") int id) {
		ContactManageDTO contactDate = contactManageService.getContact(id);
		return R.ok().put("contactDate", contactDate);
	}

	@RequestMapping("del/{id}")
	@ResponseBody
	public R del(@PathVariable("id") int id) {
		int result = contactManageService.del(id);
		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障");
	}
	
	@RequestMapping("noPlus")
	@ResponseBody
	public R noPlus() {
		int size = contactManageService.getContactCount().size();
		return R.ok().put("size", size);
	}
}