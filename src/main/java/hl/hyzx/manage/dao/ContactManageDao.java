package hl.hyzx.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hl.hyzx.manage.dto.ContactManageDTO;

public interface ContactManageDao {

	List<ContactManageDTO> getContactList(@Param("iDisplayStart") int iDisplayStart,
			@Param("iDisplayLength") int iDisplayLength);

	List<ContactManageDTO> getContactCount();

	int update(@Param("id") int id, @Param("content") String content, @Param("address") String address,
			@Param("phone") String phone, @Param("mailbox") String mailbox, @Param("x") String x, @Param("y") String y);

	int save(@Param("content") String content, @Param("address") String address, @Param("phone") String phone,
			@Param("mailbox") String mailbox, @Param("x") String x, @Param("y") String y);

	ContactManageDTO getContact(int id);

	int del(int id);

}