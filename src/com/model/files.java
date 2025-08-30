package com.model;

import java.sql.*;

public class files {
	private int fileId;
	private String fileName;
	private String filePath;
	private int uploadedBy;
	private Timestamp uploadTime;

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(int uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	public Timestamp getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Timestamp uploadTime) {
		this.uploadTime = uploadTime;
	}

	public files() {
		super();
	}

	public files(int fileId, String fileName, String filePath, int uploadedBy, Timestamp uploadTime) {
		super();
		this.fileId = fileId;
		this.fileName = fileName;
		this.filePath = filePath;
		this.uploadedBy = uploadedBy;
		this.uploadTime = uploadTime;
	}

	public String toString() {
		return "files [fileId=" + fileId + ", fileName=" + fileName + ", filePath=" + filePath + ", uploadedBy="
				+ uploadedBy + ", uploadTime=" + uploadTime + "]";
	}
}
