package com.dao;

import java.sql.*;
import java.util.*;
import com.connection.*;
import com.model.*;

public class usersDao {
	DBConnection db = new DBConnection();

	public users login(String username, String passward) throws SQLException {
		users u = null;
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username=? AND passward=?");
		ps.setString(1, username);
		ps.setString(2, passward);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			u = new users();
			u.setUserId(rs.getInt("user_id"));
			u.setUsername(rs.getString("username"));
			u.setRoleId(rs.getInt("role_id"));
		}
		return u;
	}

	public void addUser(users u) throws SQLException {
		String sql = "insert into users (username, email, passward, role_id) values (?,?,?,?)";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		ps.setString(1, u.getUsername());
		ps.setString(2, u.getEmail());
		ps.setString(3, u.getPassward());
		ps.setInt(4, u.getRoleId());
		ps.executeUpdate();

		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			int generatedId = rs.getInt(1);
			u.setUserId(generatedId);
		}
	}

	public List<users> getAllUsers() throws SQLException {
		List<users> list = new ArrayList<>();
		String sql = "select * from users";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			users u = new users();
			u.setUsername(rs.getString("username"));
			u.setEmail(rs.getString("email"));
			u.setPassward(rs.getString("passward"));
			u.setRoleId(rs.getInt("role_id"));
			u.setCreatedAt(rs.getTimestamp("created_At"));
			u.setUserId(rs.getInt("user_id"));
			list.add(u);
		}
		return list;
	}

	public users getUserByUsername(String username) throws SQLException {
		users user = null;
		String sql = "SELECT * FROM users WHERE username = ?";
		Connection con = new DBConnection().getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			user = new users();
			user.setUserId(rs.getInt("user_id"));
			user.setUsername(rs.getString("username"));
			user.setEmail(rs.getString("email"));
			user.setPassward(rs.getString("passward"));
			user.setRoleId(rs.getInt("role_id"));
			user.setCreatedAt(rs.getTimestamp("created_at"));
		}
		return user;
	}

	public users getUsersById(int id) throws SQLException {
		users u = null;

		String sql = "select * from users where user_id = ?";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			u = new users();
			u.setUsername(rs.getString("username"));
			u.setEmail(rs.getString("email"));
			u.setPassward(rs.getString("passward"));
			u.setRoleId(rs.getInt("role_id"));
			u.setCreatedAt(rs.getTimestamp("created_At"));
			u.setUserId(rs.getInt("user_id"));
		}
		return u;
	}

	public void updateUsers(users u) throws SQLException {
		String sql = "update users set username = ?, email = ?, passward = ?, role_id = ? where user_id = ?";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, u.getUsername());
		ps.setString(2, u.getEmail());
		ps.setString(3, u.getPassward());
		ps.setInt(4, u.getRoleId());
		ps.setInt(5, u.getUserId());
		ps.executeUpdate();
	}

	public void deleteUsers(int id) throws SQLException {
		String sql = "delete from users where user_id = ?";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, id);
		ps.executeUpdate();
	}
}
