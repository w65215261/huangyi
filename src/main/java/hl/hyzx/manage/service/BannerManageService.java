package hl.hyzx.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hl.hyzx.manage.dao.BannerManageDao;
import hl.hyzx.manage.dto.BannerManageDTO;

@Service
public class BannerManageService {
	@Autowired
	BannerManageDao bannerManageDao;

	public int save(String name, String bannerLink, String state, int imgId) {
		return bannerManageDao.save(name, bannerLink, state, imgId);
	}

	public List<BannerManageDTO> getBannerList() {
		return bannerManageDao.getBannerList();
	}

	public BannerManageDTO getBanner(int id) {
		return bannerManageDao.getBanner(id);
	}

	public int del(int id) {
		return bannerManageDao.del(id);
	}

	public int update(int id, String name, String bannerLink, String state, int imgId) {
		return bannerManageDao.update(id, name, bannerLink, state, imgId);
	}
}