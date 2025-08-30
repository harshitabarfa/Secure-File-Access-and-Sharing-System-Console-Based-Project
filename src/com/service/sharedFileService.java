package com.service;

import java.sql.SQLException;
import java.util.List;

import com.model.sharedFile;
import com.dao.*;

public class sharedFileService {
	sharedFileDao dao = new sharedFileDao();

	public void addSharedFile(sharedFile sf) throws SQLException {
		dao.addSharedFile(sf);
	}

	public List<sharedFile> getAllSharedFiles() throws SQLException {
		return dao.getAllSharedFiles();
	}

	public sharedFile getSharedFileById(int id) throws SQLException {
		return dao.getSharedFileById(id);
	}

	public void updateSharedFile(sharedFile sf) throws SQLException {
		dao.updateSharedFile(sf);
	}

	public void deleteSharedFile(int id) throws SQLException {
		dao.deleteSharedFile(id);
	}
}
