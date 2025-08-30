package com.service;

import java.sql.SQLException;
import java.util.List;

import com.model.notifications;
import com.dao.*;

public class notificationsService {
	notificationsDao dao = new notificationsDao();

	public void addNotification(notifications n) throws SQLException {
		dao.addNotification(n);
	}

	public List<notifications> getAllNotifications() throws SQLException {
		return dao.getAllNotifications();
	}

	public boolean markAsRead(int id) throws SQLException {
		return dao.markAsRead(id);
	}

	public boolean deleteNotification(int id) throws SQLException {
		return dao.deleteNotification(id);
	}
}
