package hl.hyzx.manage.dao;

import org.apache.ibatis.annotations.Param;

import hl.hyzx.manage.dto.ManagerDTO;

public interface ManagerDao {

	ManagerDTO getManager(@Param("username") String username, @Param("password") String password);
}
