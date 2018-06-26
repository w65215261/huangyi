package hl.hyzx.manage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hl.hyzx.manage.dto.FileDTO;

public interface FileDao {
	void saveFile(FileDTO file);

	FileDTO getPath(int id);

	List<String> getAlbum(@Param("ids") String ids[]);
}
