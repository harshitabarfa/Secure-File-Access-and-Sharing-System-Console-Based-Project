package com.service;

import java.sql.SQLException;
import java.util.List;

import com.model.activityLog;
import com.dao.*;

public class activityLogService {
	activityLogDao dao = new activityLogDao();

	public void addActivityLog(activityLog log) throws SQLException {
		dao.addActivityLog(log);
	}

	public List<activityLog> getAllActivityLogs() throws SQLException {
		return dao.getAllActivityLogs();
	}

	public activityLog getActivityLogsById(int id) throws SQLException {
		return dao.getActivityLogsById(id);
	}

	public void updateActivityLogs(activityLog log) throws SQLException {
		dao.updateActivityLogs(log);
	}

	public void deleteActivityLog(int id) throws SQLException {
		dao.deleteActivityLog(id);
	}
}
