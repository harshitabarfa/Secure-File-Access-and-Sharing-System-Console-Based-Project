package com.dao;

import java.sql.*;
import java.util.*;
import com.connection.DBConnection;
import com.model.*;

public class passwardResetDao {
	DBConnection db = new DBConnection();

	public void addPasswardReset(passwardReset pr) throws SQLException {
		String sql = "insert into passward_resets (user_id, reset_token, expires_at) values (?,?,?)";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		if (pr.getExpiresAt() == null) {
			pr.setExpiresAt(new Timestamp(System.currentTimeMillis() + (30 * 60 * 1000)));
		}

		ps.setInt(1, pr.getUserId());
		ps.setString(2, pr.getResetToken());
		ps.setTimestamp(3, pr.getExpiresAt());
		ps.executeUpdate();

		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			int generatedId = rs.getInt(1);
			pr.setResetId(generatedId);
		}
	}

	public List<passwardReset> getAllPasswardResets() throws SQLException {
		List<passwardReset> list = new ArrayList<>();
		String sql = "select * from passward_resets";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			passwardReset pr = new passwardReset();
			pr.setResetId(rs.getInt("reset_id"));
			pr.setUserId(rs.getInt("user_id"));
			pr.setResetToken(rs.getString("reset_token"));
			pr.setExpiresAt(rs.getTimestamp("expires_at"));
			list.add(pr);
		}
		return list;
	}

	public passwardReset getPasswardResetById(int id) throws SQLException {
		passwardReset pr = null;

		String sql = "select * from passward_resets  where reset_id = ?";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pr = new passwardReset();
			pr.setResetId(rs.getInt("reset_id"));
			pr.setUserId(rs.getInt("user_id"));
			pr.setResetToken(rs.getString("reset_token"));
			pr.setExpiresAt(rs.getTimestamp("expires_at"));
		}
		return pr;
	}

	public void updatePasswardReset(passwardReset pr) throws SQLException {
		String sql = "update passward_resets set user_id = ?, reset_token = ?, expires_at = ? where reset_id = ?";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		if (pr.getExpiresAt() == null) {
			pr.setExpiresAt(new Timestamp(System.currentTimeMillis() + (30 * 60 * 1000)));
		}

		ps.setInt(1, pr.getUserId());
		ps.setString(2, pr.getResetToken());
		ps.setTimestamp(3, pr.getExpiresAt());
		ps.setInt(4, pr.getResetId());
		ps.executeUpdate();
	}

	public void deletePasswardReset(int id) throws SQLException {
		String sql = "delete from passward_resets where reset_id = ?";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, id);
		ps.executeUpdate();
	}
}
