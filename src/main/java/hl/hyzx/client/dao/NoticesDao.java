package hl.hyzx.client.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hl.hyzx.client.dto.NoticesDTO;

public interface NoticesDao {
	List<NoticesDTO> getNoticeList(@Param("noticeType") int noticeType, @Param("start") int start,
			@Param("pageSize") int pageSize);
	int getNoticeCount(int columnId);
}