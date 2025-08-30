package com.dao;

import java.sql.*;
import java.util.*;
import com.connection.DBConnection;
import com.model.*;

public class filesDao {
	DBConnection db = new DBConnection();

	public void addFiles(files f) throws SQLException {
		String sql = "insert into files (file_name, file_path, uploaded_by) values (?,?,?)";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		ps.setString(1, f.getFileName());
		ps.setString(2, f.getFilePath());
		ps.setInt(3, f.getUploadedBy());
		ps.executeUpdate();

		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			int generatedId = rs.getInt(1);
			f.setFileId(generatedId);
		}
	}

	public List<files> getAllFiles() throws SQLException {
		List<files> list = new ArrayList<>();
		String sql = "select * from files";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			files f = new files();
			f.setFileId(rs.getInt("file_id"));
			f.setFileName(rs.getString("file_name"));
			f.setFilePath(rs.getString("file_path"));
			f.setUploadedBy(rs.getInt("uploaded_by"));
			f.setUploadTime(rs.getTimestamp("upload_time"));
			list.add(f);
		}
		return list;
	}

	public files getFilesById(int id) throws SQLException {
		files f = null;

		String sql = "select * from files where file_id = ?";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			f = new files();
            f.setFileId(rs.getInt("file_id"));
            f.setFileName(rs.getString("file_name"));
            f.setFilePath(rs.getString("file_path"));
            f.setUploadedBy(rs.getInt("uploaded_by"));
            f.setUploadTime(rs.getTimestamp("upload_time"));
		}
		return f;
	}

	public void updateFiles(files f) throws SQLException {
		String sql = "update files set file_name = ?, file_path = ?, uploaded_by = ? where file_id = ?";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, f.getFileName());
        ps.setString(2, f.getFilePath());
        ps.setInt(3, f.getUploadedBy());
        ps.setInt(4, f.getFileId());
		ps.executeUpdate();
	}

	public void deleteFiles(int id) throws SQLException {
		String sql = "delete from files where file_id = ?";
		Connection con = db.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, id);
		ps.executeUpdate();
	}
}
