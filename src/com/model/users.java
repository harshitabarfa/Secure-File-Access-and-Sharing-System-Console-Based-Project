package com.model;
import java.sql.*;

public class users {
	private int userId;
	private String username;
	private String email;
	private String passward;
	private int roleId;
	private Timestamp createdAt;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassward() {
		return passward;
	}

	public void setPassward(String passward) {
		this.passward = passward;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public users() {
		super();
	}

	public users(int userId, String username, String email, String passward, int roleId, Timestamp createdAt) {
		super();
		this.userId = userId;
		this.username = username;
		this.email = email;
		this.passward = passward;
		this.roleId = roleId;
		this.createdAt = createdAt;
	}

	public String toString() {
		return "users [userId=" + userId + ", username=" + username + ", email=" + email + ", passward=" + passward
				+ ", roleId=" + roleId + ", createdAt=" + createdAt + "]";
	}
}
