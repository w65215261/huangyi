package hl.hyzx.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hl.hyzx.client.dao.NoticesDao;
import hl.hyzx.client.dto.NoticesDTO;

@Service
public class NoticesService {
	@Autowired
	NoticesDao noticesDao;

	public List<NoticesDTO> getNoticeList(int noticeType, int start, int pageSize) {
		return noticesDao.getNoticeList(noticeType, start, pageSize);
	}
	
	public int getNoticeCount(int columnId) {
		return noticesDao.getNoticeCount(columnId);
	}
	
}