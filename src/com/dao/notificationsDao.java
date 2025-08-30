package com.dao;

import java.sql.*;
import java.util.*;
import com.connection.DBConnection;
import com.model.*;

public class notificationsDao {
	DBConnection db = new DBConnection();

	public void addNotification(notifications n) throws SQLException {
		String sql = "insert into notifications (user_id, message, is_read) values (?,?,?)";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		
		ps.setInt(1, n.getUserId());
		ps.setString(2, n.getMessage());
		ps.setBoolean(3, n.isRead());
		ps.executeUpdate();

		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			int generatedId = rs.getInt(1);
			n.setNotificationId(generatedId);;
		}
	}

	public List<notifications> getAllNotifications() throws SQLException {
		List<notifications> list = new ArrayList<>();
		String sql = "select * from notifications";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			notifications n = new notifications();
			n.setNotificationId(rs.getInt("notification_id"));
            n.setUserId(rs.getInt("user_id"));
            n.setMessage(rs.getString("message"));
            n.setRead(rs.getBoolean("is_read"));
            n.setCreatedAt(rs.getTimestamp("created_at"));
            list.add(n);
		}
		return list;
	}

	public boolean markAsRead(int id) throws SQLException {
		String sql = "update notifications set is_read = true where notification_id = ?";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, id);
		return ps.executeUpdate() > 0;
	}

	public boolean deleteNotification(int id) throws SQLException {
		String sql = "delete from notifications where notification_id = ?";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, id);
		return ps.executeUpdate() > 0;
	}
}
