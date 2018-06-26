package hl.hyzx.client.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import hl.hyzx.client.service.ConsultService;
import hl.hyzx.common.Base;
import hl.hyzx.common.R;
import hl.hyzx.manage.dto.SignUpManageDTO;


@Controller
public class ConsultController extends Base {
	@Autowired
	ConsultService consultService;
	
	@RequestMapping("consultClient")
	public String consultClient(Model model) {
		consultService.getModuleResumeList(model);
		return "client/consult";
	}
	
	@RequestMapping("signUpShow")
	@ResponseBody
	public R signUpShow(int currPage) {
		List<SignUpManageDTO> signUps =  consultService.getSignUpList((currPage - 1) * 6, 6);
		int count = consultService.getSignUpCount();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("signUps", signUps);
		map.put("currPage", currPage);
		map.put("count", count);
		map.put("pageCount", page(count, 6));
		return R.ok(map);
	}
	
	@RequestMapping("save")
	@ResponseBody
	public R save(String name, String phone, String qq, String wechat, String mailbox, String content, int state) {
		int result = 0;
		result = consultService.save(name, phone, qq, wechat, mailbox, content, state);
		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障！");
	}
	
	@RequestMapping("saveSignUp")
	@ResponseBody
	public R saveSignUp(String signName, String signPhone, String signQq, String signWechat, String signMailbox, String signContent) {
		
		int phone = consultService.getSignListByPhone(signPhone, signContent);
		if (phone > 0) {
			return R.error("不能用同一手机号报名同一个项目！");
		}
		int result = 0;
		result = consultService.saveSignUp(signName, signPhone, signQq, signWechat, signMailbox, signContent);
		if (result == 1)
			return R.ok();
		else
			return R.error("系统故障！");
	}
	
	@RequestMapping("getSignList")
	@ResponseBody
	public R getSignList() {
		List<SignUpManageDTO> signs = consultService.getSignList();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("signs", signs);
		return R.ok(map);
	}
	
}