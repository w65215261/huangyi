package hl.hyzx.client.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hl.hyzx.client.dto.VideosDTO;

public interface VideosDao {

	List<VideosDTO> getVideoList(@Param("classification") int classification, @Param("start") int start,
			@Param("pageSize") int pageSize);

	int getVideoCount(int columnId);
}