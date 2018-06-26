package hl.hyzx.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hl.hyzx.manage.dto.SignUpManageDTO;
import hl.hyzx.manage.dto.SignUpShowManageDTO;

public interface SignUpManageDao {

	List<SignUpManageDTO> getSignUpList(@Param("iDisplayStart") int iDisplayStart,
			@Param("iDisplayLength") int iDisplayLength);

	List<SignUpManageDTO> getSignUpCount();
	
	int save(@Param("title") String title, @Param("content") String content, @Param("imgId") int imgId);
	
	int update(@Param("id") int id, @Param("title") String title, @Param("content") String content, @Param("imgId") int imgId);
	
	SignUpManageDTO getSignUp(int id);
	
	int del(int id);
	
	List<SignUpShowManageDTO> getSignUpShowList(@Param("iDisplayStart") int iDisplayStart,
			@Param("iDisplayLength") int iDisplayLength);

	List<SignUpShowManageDTO> getSignUpShowCount();
	
	SignUpShowManageDTO getSignUpShow(int id);
	
	int delShow(int id);
	
	List<SignUpShowManageDTO> getSignUpShowListByTiaojian(@Param("tiaojian") String tiaojian, @Param("iDisplayStart") int iDisplayStart,
			@Param("iDisplayLength") int iDisplayLength);
	
	List<SignUpShowManageDTO> getSignUpShowCountByTiaojian(@Param("tiaojian") String tiaojian);
	
	List<SignUpShowManageDTO> getSignListByTiaojian(@Param("tiaojian") String tiaojian);
	List<SignUpShowManageDTO> getSignList();

}