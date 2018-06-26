package hl.hyzx.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hl.hyzx.manage.dto.NoticesManageDTO;

public interface NoticesManageDao {

	List<NoticesManageDTO> getNoticeList(@Param("iDisplayStart") int iDisplayStart,
			@Param("iDisplayLength") int iDisplayLength);

	List<NoticesManageDTO> getNoticeCount();

	int save(@Param("title") String title, @Param("imgId") int imgId, @Param("content") String content,
			@Param("noticeType") int noticeType, @Param("typeName") String typeName);

	int update(@Param("id") int id, @Param("title") String title, @Param("imgId") int imgId,
			@Param("content") String content, @Param("noticeType") int noticeType, @Param("typeName") String typeName);

	NoticesManageDTO getNotice(int id);

	int del(int id);
}