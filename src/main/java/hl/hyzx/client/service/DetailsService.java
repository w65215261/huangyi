package hl.hyzx.client.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hl.hyzx.client.dao.DetailsDao;
import hl.hyzx.client.dto.DetailsDTO;
import hl.hyzx.client.dto.NoticesDTO;
import hl.hyzx.client.dto.VideosDTO;
import hl.hyzx.manage.dto.CaseManageDTO;
import hl.hyzx.manage.dto.NewsConsultationManageDTO;
import hl.hyzx.manage.dto.SignUpManageDTO;

@Service
public class DetailsService {
	@Autowired
	DetailsDao detailsDao;

	public DetailsDTO getCase(int id) {
		CaseManageDTO cm = detailsDao.getCase(id);
		DetailsDTO details = new DetailsDTO();
		details.setDetailsContent(cm.getContent());
		details.setDetailsImgPath(cm.getImgPath());
		details.setDetailsTitle(cm.getName());
		return details;
	}

	public DetailsDTO getNewsConsultation(int id) {
		NewsConsultationManageDTO nc = detailsDao.getNewsConsultation(id);
		DetailsDTO details = new DetailsDTO();
		details.setDetailsContent(nc.getContent());
		details.setDetailsImgPath(nc.getImgPath());
		details.setDetailsTitle(nc.getNewsTitle());
		return details;
	}

	public DetailsDTO getNotices(int id) {
		NoticesDTO notices = detailsDao.getNotices(id);
		DetailsDTO details = new DetailsDTO();
		details.setDetailsContent(notices.getContent());
		details.setDetailsImgPath(notices.getImgPath());
		details.setDetailsTitle(notices.getTitle());
		return details;
	}

	public DetailsDTO getVideos(int id) {
		VideosDTO videos = detailsDao.getVideos(id);
		DetailsDTO details = new DetailsDTO();
		details.setDetailsContent(videos.getContent());
		details.setDetailsImgPath(videos.getVideoPath());
		details.setDetailsTitle(videos.getVideoName());
		return details;
	}

	public DetailsDTO getSignUps(int id) {
		SignUpManageDTO signUps = detailsDao.getSignUps(id);
		DetailsDTO details = new DetailsDTO();
		details.setDetailsContent(signUps.getContent());
		details.setDetailsTitle(signUps.getTitle());
		return details;
	}
}