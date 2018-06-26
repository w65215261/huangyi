package hl.hyzx.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hl.hyzx.manage.dto.BannerManageDTO;

public interface BannerManageDao {

	int save(@Param("name") String name, @Param("bannerLink") String bannerLink,
			@Param("state") String state, @Param("imgId") int imgId);

	List<BannerManageDTO> getBannerList();

	BannerManageDTO getBanner(int id);

	int del(int id);

	int update(@Param("id") int id, @Param("name") String name,
			@Param("bannerLink") String bannerLink, @Param("state") String state, @Param("imgId") int imgId);
}