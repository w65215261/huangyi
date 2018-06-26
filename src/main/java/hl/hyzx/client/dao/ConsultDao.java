package hl.hyzx.client.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hl.hyzx.manage.dto.ModuleResumeManageDTO;
import hl.hyzx.manage.dto.SignUpManageDTO;

public interface ConsultDao {
	List<SignUpManageDTO> getSignList();
	
	int save(@Param("name") String name, @Param("phone") String phone, @Param("qq") String qq, @Param("wechat") String wechat,
			@Param("mailbox") String mailbox, @Param("content") String content, @Param("state") int state);

	int saveSignUp(@Param("signName") String signName, @Param("signPhone") String signPhone, @Param("signQq") String signQq, @Param("signWechat") String signWechat,
			@Param("signMailbox") String signMailbox, @Param("signContent") String signContent);
	
	int update(@Param("id") int id, @Param("state") int state);
	
	ModuleResumeManageDTO getModuleResume(@Param("moduleType") int moduleType);
	
	List<SignUpManageDTO> getSignUpList(@Param("start") int start,
			@Param("pageSize") int pageSize);
	int getSignUpCount();
	int getSignListByPhone(@Param("signPhone") String signPhone, @Param("signContent") String signContent);
	
}