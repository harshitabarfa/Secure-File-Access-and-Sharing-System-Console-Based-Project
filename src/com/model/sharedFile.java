package com.model;

import java.sql.*;

public class sharedFile {
	private int shareId;
	private int fileId;
	private int sharedWith;
	private boolean canDownload;
	private Timestamp sharedAt;

	public int getShareId() {
		return shareId;
	}

	public void setShareId(int shareId) {
		this.shareId = shareId;
	}

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public int getSharedWith() {
		return sharedWith;
	}

	public void setSharedWith(int sharedWith) {
		this.sharedWith = sharedWith;
	}

	public boolean isCanDownload() {
		return canDownload;
	}

	public void setCanDownload(boolean canDownload) {
		this.canDownload = canDownload;
	}

	public Timestamp getSharedAt() {
		return sharedAt;
	}

	public void setSharedAt(Timestamp sharedAt) {
		this.sharedAt = sharedAt;
	}

	public sharedFile() {
		super();
	}

	public sharedFile(int shareId, int fileId, int sharedWith, boolean canDownload, Timestamp sharedAt) {
		super();
		this.shareId = shareId;
		this.fileId = fileId;
		this.sharedWith = sharedWith;
		this.canDownload = canDownload;
		this.sharedAt = sharedAt;
	}

	public String toString() {
		return "sharedFile [shareId=" + shareId + ", fileId=" + fileId + ", sharedWith=" + sharedWith + ", canDownload="
				+ canDownload + ", sharedAt=" + sharedAt + "]";
	}
}
