package hl.hyzx.client.dao;

import org.apache.ibatis.annotations.Param;

import hl.hyzx.client.dto.ServiceMenuDTO;

public interface ServiceMenuDao {
	ServiceMenuDTO getServiceMenu(@Param("serviceMenuType") int serviceMenuType);
}