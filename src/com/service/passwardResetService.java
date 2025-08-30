package com.service;

import java.sql.SQLException;
import java.util.List;

import com.model.passwardReset;
import com.dao.*;

public class passwardResetService {
	passwardResetDao dao = new passwardResetDao();

	public void addPasswardReset(passwardReset pr) throws SQLException {
		dao.addPasswardReset(pr);
	}

	public List<passwardReset> getAllPasswardResets() throws SQLException {
		return dao.getAllPasswardResets();
	}

	public passwardReset getPasswardResetById(int id) throws SQLException {
		return dao.getPasswardResetById(id);
	}

	public void updatePasswardReset(passwardReset pr) throws SQLException {
		dao.updatePasswardReset(pr);
	}

	public void deletePasswardReset(int id) throws SQLException {
		dao.deletePasswardReset(id);
	}
}
