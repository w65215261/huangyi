package hl.hyzx.manage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hl.hyzx.common.Base;
import hl.hyzx.common.R;
import hl.hyzx.manage.dto.ManagerDTO;
import hl.hyzx.manage.service.ManagerService;
import hl.hyzx.util.SecretUtil;

@Controller
@RequestMapping("manage")
public class ManageController extends Base {

	@Autowired
	ManagerService managerService;

	@RequestMapping("login")
	public String login() {
		return "manage/login";
	}

	@RequestMapping("managerLogin")
	@ResponseBody
	public R managerLogin(String username, String password) {
		ManagerDTO manager = managerService.getManager(username, SecretUtil.encrypt(password));
		if (manager != null) {
			addSession("manager", manager);
			return R.ok();
		}
		return R.error("用户名或密码错误！");
	}

}