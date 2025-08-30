package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import com.model.notifications;
import com.service.notificationsService;

public class notificationsController {
	Scanner sc = new Scanner(System.in);
	notificationsService n = new notificationsService();

	public void addNotification() throws SQLException {
		System.out.print("Enter user id: ");
		int userId = Integer.parseInt(sc.nextLine());

		System.out.print("Enter message: ");
		String message = sc.nextLine();

		System.out.print("Is read? (true/false): ");
		boolean isRead = Boolean.parseBoolean(sc.nextLine());

		notifications n1 = new notifications();
		n1.setUserId(userId);
		n1.setMessage(message);
		n1.setRead(isRead);

		n.addNotification(n1);
		System.out.println("Notification added successfully!");
	}

	public void viewAllNotifications() throws SQLException {
		List<notifications> list = n.getAllNotifications();
		for (notifications n2 : list) {
			System.out.println(n2);
		}
	}

	public void markAsRead() throws SQLException {
		System.out.print("Enter notification id to mark as read: ");
		int id = Integer.parseInt(sc.nextLine());

		n.markAsRead(id);
		System.out.println("Notification marked as read!");
	}

	public void deleteNotification() throws SQLException {
		System.out.print("Enter notification id to delete: ");
		int did = Integer.parseInt(sc.nextLine());

		n.deleteNotification(did);
		System.out.println("Notification deleted!");
	}
}
