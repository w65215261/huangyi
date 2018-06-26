package hl.hyzx.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hl.hyzx.manage.dto.VideoManageDTO;

public interface VideoManageDao {

	List<VideoManageDTO> getVideoList(@Param("iDisplayStart") int iDisplayStart,
			@Param("iDisplayLength") int iDisplayLength);

	List<VideoManageDTO> getVideoCount();

	int save(@Param("name") String name, @Param("resume") String resume, @Param("videoName") String videoName,
			@Param("videoId") int videoId, @Param("imgId") int imgId, @Param("classification") int classification,
			@Param("classificationName") String classificationName, @Param("content") String content);

	int update(@Param("id") int id, @Param("name") String name, @Param("resume") String resume,
			@Param("videoName") String videoName, @Param("videoId") int videoId, @Param("imgId") int imgId,
			@Param("classification") int classification, @Param("classificationName") String classificationName,
			@Param("content") String content);

	VideoManageDTO getVideo(int id);

	int del(int id);
}