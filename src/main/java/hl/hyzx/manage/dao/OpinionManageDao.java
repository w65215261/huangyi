package hl.hyzx.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hl.hyzx.manage.dto.OpinionManageDTO;

public interface OpinionManageDao {
	int save(@Param("imgId") int imgId, @Param("content") String content);

	int update(@Param("id") int id, @Param("imgId") int imgId, @Param("content") String content);

	OpinionManageDTO getOpinion(int id);

	List<OpinionManageDTO> getOpinionList();
}