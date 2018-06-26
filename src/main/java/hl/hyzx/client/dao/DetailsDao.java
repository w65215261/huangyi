package hl.hyzx.client.dao;

import hl.hyzx.client.dto.NoticesDTO;
import hl.hyzx.client.dto.VideosDTO;
import hl.hyzx.manage.dto.CaseManageDTO;
import hl.hyzx.manage.dto.NewsConsultationManageDTO;
import hl.hyzx.manage.dto.SignUpManageDTO;

public interface DetailsDao {

	CaseManageDTO getCase(int id);
	
	NewsConsultationManageDTO getNewsConsultation(int id);
	
	NoticesDTO getNotices(int id);
	
	VideosDTO getVideos(int id);
	
	SignUpManageDTO getSignUps(int id);
}