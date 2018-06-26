package hl.hyzx.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import hl.hyzx.client.dao.ConsultDao;
import hl.hyzx.manage.dto.ModuleResumeManageDTO;
import hl.hyzx.manage.dto.SignUpManageDTO;

@Service
public class ConsultService {
	@Autowired
	ConsultDao consultDao;

	public List<SignUpManageDTO> getSignList() {
		return consultDao.getSignList();
	}
	
	public List<SignUpManageDTO> getSignUpList(int start, int pageSize) {
		return consultDao.getSignUpList(start, pageSize);
	}
	
	public int getSignUpCount() {
		return consultDao.getSignUpCount();
	}
	
	public int save(String name, String phone, String qq, String wechat, String mailbox, String content, int state) {
		return consultDao.save(name, phone, qq, wechat, mailbox, content, state);
	}
	
	public int saveSignUp(String signName, String signPhone, String signQq, String signWechat, String signMailbox, String signContent) {
		return consultDao.saveSignUp(signName, signPhone, signQq, signWechat, signMailbox, signContent);
	}

	public int update(int id, int state) {
		return consultDao.update(id, state);
	}
	public int getSignListByPhone(String signPhone, String signContent) {
		return consultDao.getSignListByPhone(signPhone,signContent);
	}
	
	public void getModuleResumeList(Model model) {
		ModuleResumeManageDTO mrm = consultDao.getModuleResume(5);
		ModuleResumeManageDTO mr = consultDao.getModuleResume(6);
		model.addAttribute("moduleConsult", mrm);
		model.addAttribute("mr", mr);

	}

}