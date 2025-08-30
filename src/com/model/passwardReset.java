package com.model;

import java.sql.*;

public class passwardReset {
	private int resetId;
	private int userId;
	private String resetToken;
	private Timestamp expiresAt;

	public int getResetId() {
		return resetId;
	}

	public void setResetId(int resetId) {
		this.resetId = resetId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getResetToken() {
		return resetToken;
	}

	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}

	public Timestamp getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Timestamp expiresAt) {
		this.expiresAt = expiresAt;
	}

	public passwardReset() {
		super();
	}

	public passwardReset(int resetId, int userId, String resetToken, Timestamp expiresAt) {
		super();
		this.resetId = resetId;
		this.userId = userId;
		this.resetToken = resetToken;
		this.expiresAt = expiresAt;
	}

	public String toString() {
		return "passwardReset [resetId=" + resetId + ", userId=" + userId + ", resetToken=" + resetToken
				+ ", expiresAt=" + expiresAt + "]";
	}
}
