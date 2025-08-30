package com.dao;

import java.sql.*;
import java.util.*;
import com.connection.DBConnection;
import com.model.*;

public class activityLogDao {
	DBConnection db = new DBConnection();

	public void addActivityLog(activityLog log) throws SQLException {
		String sql = "insert into activity_logs (user_id, file_id, action) values (?,?,?)";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		ps.setInt(1, log.getUserId());
		ps.setInt(2, log.getFileId());
		ps.setString(3, log.getAction());
		ps.executeUpdate();

		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			int generatedId = rs.getInt(1);
			log.setLogId(generatedId);
		}
	}

	public List<activityLog> getAllActivityLogs() throws SQLException {
		List<activityLog> list = new ArrayList<>();
		String sql = "select * from activity_logs";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			activityLog log = new activityLog();
			log.setLogId(rs.getInt("log_id"));
			log.setUserId(rs.getInt("user_id"));
			log.setFileId(rs.getInt("file_id"));
			log.setAction(rs.getString("action"));
			log.setTimestamp(rs.getTimestamp("timestamp"));
			list.add(log);
		}
		return list;
	}

	public activityLog getActivityLogsById(int id) throws SQLException {
		activityLog log = null;

		String sql = "select * from activity_logs where log_id = ?";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			log = new activityLog();
			log.setLogId(rs.getInt("log_id"));
			log.setUserId(rs.getInt("user_id"));
			log.setFileId(rs.getInt("file_id"));
			log.setAction(rs.getString("action"));
			log.setTimestamp(rs.getTimestamp("timestamp"));
		}
		return log;
	}

	public void updateActivityLogs(activityLog log) throws SQLException {
		String sql = "update activity_logs set user_id = ?, file_id = ?, action = ?, timestamp = ? where log_id = ?";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, log.getUserId());
		ps.setInt(2, log.getFileId());
		ps.setString(3, log.getAction());
		ps.setTimestamp(4, log.getTimestamp());
		ps.setInt(5, log.getLogId());
		ps.executeUpdate();
	}

	public void deleteActivityLog(int id) throws SQLException {
		String sql = "delete from activity_logs where log_id = ?";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, id);
		ps.executeUpdate();
	}
}
