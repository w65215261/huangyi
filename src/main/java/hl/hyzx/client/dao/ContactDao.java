package hl.hyzx.client.dao;

import java.util.List;

import hl.hyzx.client.dto.ContactDTO;

public interface ContactDao {
	List<ContactDTO> getContactList();
}