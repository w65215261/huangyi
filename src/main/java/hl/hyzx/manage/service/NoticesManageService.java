package hl.hyzx.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hl.hyzx.manage.dao.NoticesManageDao;
import hl.hyzx.manage.dto.NoticesManageDTO;

@Service
public class NoticesManageService {
	@Autowired
	NoticesManageDao noticesManageDao;

	public int save(String title, int imgId, String content, int noticeType, String typeName) {
		return noticesManageDao.save(title, imgId, content, noticeType, typeName);
	}

	public int update(int id, String title, int imgId, String content, int noticeType, String typeName) {
		return noticesManageDao.update(id, title, imgId, content, noticeType, typeName);
	}

	public List<NoticesManageDTO> getNoticeList(int iDisplayStart, int iDisplayLength) {
		return noticesManageDao.getNoticeList(iDisplayStart, iDisplayLength);
	}

	public List<NoticesManageDTO> getNoticeCount() {
		return noticesManageDao.getNoticeCount();
	}

	public NoticesManageDTO getNotice(int id) {
		return noticesManageDao.getNotice(id);
	}

	public int del(int id) {
		return noticesManageDao.del(id);
	}
	
}