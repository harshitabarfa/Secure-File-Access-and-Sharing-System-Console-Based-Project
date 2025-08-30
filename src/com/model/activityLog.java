package com.model;

import java.sql.*;

public class activityLog {
	private int logId;
	private int userId;
	private int fileId;
	private String action;
	private Timestamp timestamp;

	public int getLogId() {
		return logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public activityLog() {
		super();
	}

	public activityLog(int logId, int userId, int fileId, String action, Timestamp timestamp) {
		super();
		this.logId = logId;
		this.userId = userId;
		this.fileId = fileId;
		this.action = action;
		this.timestamp = timestamp;
	}

	public String toString() {
		return "activityLog [logId=" + logId + ", userId=" + userId + ", fileId=" + fileId + ", action=" + action
				+ ", timestamp=" + timestamp + "]";
	}
}
