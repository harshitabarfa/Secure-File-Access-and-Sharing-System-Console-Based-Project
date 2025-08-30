package com.dao;

import java.sql.*;
import com.model.*;
import com.connection.*;
import java.util.*;

public class rolesDao {

	DBConnection db = new DBConnection();

	public void addRoles(roles r) throws SQLException {
		String sql = "insert into roles (role_name) values (?)";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, r.getRoleName());
		ps.executeUpdate();
	}

	public List<roles> getAllRoles() throws SQLException {
		List<roles> list = new ArrayList<>();
		String sql = "select * from roles";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			roles r = new roles();
			r.setRoleId(rs.getInt("role_id"));
			r.setRoleName(rs.getString("role_name"));
			list.add(r);
		}
		return list;
	}

	public roles getRolesById(int id) throws SQLException {
		roles r = null;
		
		String sql = "select * from roles where role_id = ?";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			r = new roles();
			r.setRoleId(rs.getInt("role_id"));
			r.setRoleName(rs.getString("role_name"));
		}
		return r;
	}

	public void updateRoles(roles r) throws SQLException {
		String sql = "update roles set role_name = ? where role_id = ?";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, r.getRoleName());
		ps.setInt(2, r.getRoleId());
		ps.executeUpdate();
	}
	
	public void updateRole(int id, String name) throws SQLException {
	    String sql = "UPDATE roles SET role_name = ? WHERE role_id = ?";
	    try (Connection con = db.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {
	        ps.setString(1, name);
	        ps.setInt(2, id);
	        ps.executeUpdate();
	    }
	}

	public void deleteRoles(int id) throws SQLException {
		String sql = "delete from roles where role_id = ?";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, id);
		ps.executeUpdate();
	}
}
