package hl.hyzx.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hl.hyzx.client.dao.ContactDao;
import hl.hyzx.client.dto.ContactDTO;

@Service
public class ContactService {
	@Autowired
	ContactDao contactDao;

	public List<ContactDTO> getContactList() {
		return contactDao.getContactList();
	}
	
}