package hl.hyzx.manage.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import hl.hyzx.manage.dto.NewsConsultationManageDTO;

public interface NewsConsultationManageDao {

	List<NewsConsultationManageDTO> getNewsConsultationList(@Param("iDisplayStart") int iDisplayStart, @Param("iDisplayLength") int iDisplayLength);
	
	List<NewsConsultationManageDTO> getNewsConsultationCount();

	int save(@Param("newsTitle") String newsTitle, @Param("author") String author, @Param("imgId") int imgId,
			@Param("content") String content, @Param("newsTime") Date newsTime);

	int update(@Param("id") int id, @Param("newsTitle") String newsTitle, @Param("author") String author,
			@Param("imgId") int imgId, @Param("content") String content, @Param("newsTime") Date newsTime);

	NewsConsultationManageDTO getNewsConsultation(int id);
	
	int del(int id);
}