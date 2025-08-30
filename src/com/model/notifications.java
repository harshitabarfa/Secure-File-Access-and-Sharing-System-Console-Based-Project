package com.model;

import java.sql.*;

public class notifications {
	private int notificationId;
	private int userId;
	private String message;
	private boolean isRead;
	private Timestamp createdAt;

	public int getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isRead() {
		return isRead;
	}

	public void setRead(boolean isRead) {
		this.isRead = isRead;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public notifications() {
		super();
	}

	public notifications(int notificationId, int userId, String message, boolean isRead, Timestamp createdAt) {
		super();
		this.notificationId = notificationId;
		this.userId = userId;
		this.message = message;
		this.isRead = isRead;
		this.createdAt = createdAt;
	}

	public String toString() {
		return "notifications [notificationId=" + notificationId + ", userId=" + userId + ", message=" + message
				+ ", isRead=" + isRead + ", createdAt=" + createdAt + "]";
	}
}
