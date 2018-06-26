package hl.hyzx.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hl.hyzx.manage.dao.ContactManageDao;
import hl.hyzx.manage.dto.ContactManageDTO;

@Service
public class ContactManageService {
	@Autowired
	ContactManageDao contactManageDao;

	public List<ContactManageDTO> getContactCount() {
		return contactManageDao.getContactCount();
	}

	public List<ContactManageDTO> getContactList(int iDisplayStart, int iDisplayLength) {
		return contactManageDao.getContactList(iDisplayStart, iDisplayLength);
	}

	public int update(int id, String content, String address, String phone, String mailbox, String x, String y) {
		return contactManageDao.update(id, content, address, phone, mailbox, x, y);
	}

	public int save(String content, String address, String phone, String mailbox, String x, String y) {
		return contactManageDao.save(content, address, phone, mailbox, x, y);
	}

	public ContactManageDTO getContact(int id) {
		return contactManageDao.getContact(id);
	}

	public int del(int id) {
		return contactManageDao.del(id);
	}

}