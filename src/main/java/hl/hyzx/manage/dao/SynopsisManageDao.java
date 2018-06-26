package hl.hyzx.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hl.hyzx.manage.dto.SynopsisManageDTO;

public interface SynopsisManageDao {
	int save(@Param("imgId") int imgId, @Param("content") String content);

	int update(@Param("id") int id, @Param("imgId") int imgId, @Param("content") String content);

	SynopsisManageDTO getSynopsis(int id);

	List<SynopsisManageDTO> getSynopsisList();
}