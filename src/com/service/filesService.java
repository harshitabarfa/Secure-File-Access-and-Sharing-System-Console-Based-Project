package com.service;

import java.sql.SQLException;
import java.util.List;
import com.model.files;
import com.dao.*;

public class filesService {
	filesDao dao = new filesDao();

	public void addFiles(files f) throws SQLException {
		dao.addFiles(f);
	}

	public List<files> getAllFiles() throws SQLException {
		return dao.getAllFiles();
	}

	public files getFilesById(int id) throws SQLException {
		return dao.getFilesById(id);
	}

	public void updateFiles(files f) throws SQLException {
		dao.updateFiles(f);
	}

	public void deleteFiles(int id) throws SQLException {
		dao.deleteFiles(id);
	}
}
