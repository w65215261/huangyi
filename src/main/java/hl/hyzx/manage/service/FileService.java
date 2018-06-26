package hl.hyzx.manage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hl.hyzx.manage.dao.FileDao;
import hl.hyzx.manage.dto.FileDTO;

@Service
public class FileService {
	@Autowired
	FileDao fileDao;

	public void saveFile(FileDTO file) {
		fileDao.saveFile(file);
	}

	public FileDTO getPath(int id) {
		return fileDao.getPath(id);
	}

	public List<String> getAlbum(String ids[]) {
		return fileDao.getAlbum(ids);
	}
}
