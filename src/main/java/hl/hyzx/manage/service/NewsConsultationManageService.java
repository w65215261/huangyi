package hl.hyzx.manage.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hl.hyzx.manage.dao.NewsConsultationManageDao;
import hl.hyzx.manage.dto.NewsConsultationManageDTO;

@Service
public class NewsConsultationManageService {
	@Autowired
	NewsConsultationManageDao newsConsultationManageDao;

	public int save(String newsTitle, String author, int imgId, String content, Date newsTime) {
		return newsConsultationManageDao.save(newsTitle, author, imgId, content, newsTime);
	}

	public int update(int id, String newsTitle, String author, int imgId, String content, Date newsTime) {
		return newsConsultationManageDao.update(id, newsTitle, author, imgId, content, newsTime);
	}
	
	public List<NewsConsultationManageDTO> getNewsConsultationList(int iDisplayStart, int iDisplayLength) {
		return newsConsultationManageDao.getNewsConsultationList(iDisplayStart,iDisplayLength);
	}
	
	public List<NewsConsultationManageDTO> getNewsConsultationCount() {
		return newsConsultationManageDao.getNewsConsultationCount();
	}

	public NewsConsultationManageDTO getNewsConsultation(int id) {
		return newsConsultationManageDao.getNewsConsultation(id);
	}
	
	public int del(int id) {
		return newsConsultationManageDao.del(id);
	}
	
}