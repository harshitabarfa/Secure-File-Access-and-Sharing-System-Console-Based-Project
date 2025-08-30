package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import com.model.activityLog;
import com.service.activityLogService;

public class activityLogController {
	Scanner sc = new Scanner(System.in);
	activityLogService al = new activityLogService();

	public void addLog() throws SQLException {
		System.out.print("Enter user id: ");
		int userId = Integer.parseInt(sc.nextLine());

		System.out.print("Enter file id: ");
		int fileId = Integer.parseInt(sc.nextLine());

		System.out.print("Enter action description: ");
		String action = sc.nextLine();

		activityLog log = new activityLog();
		log.setUserId(userId);
		log.setFileId(fileId);
		log.setAction(action);

		al.addActivityLog(log);
		System.out.println("Activity log added successfully!");
	}

	public void viewAllLogs() throws SQLException {
		List<activityLog> list = al.getAllActivityLogs();
		for (activityLog log : list) {
			System.out.println(log);
		}
	}

	public void searchLogById() throws SQLException {
		System.out.print("Enter activity log id: ");
		int id = Integer.parseInt(sc.nextLine());

		activityLog log = al.getActivityLogsById(id);
		if (log != null) {
			System.out.println(log);
		} else {
			System.out.println("Activity log not found.");
		}
	}

	public void updateActivityLog() throws SQLException {
		System.out.print("Enter activity log id to update: ");
		int uid = Integer.parseInt(sc.nextLine());

		activityLog log = al.getActivityLogsById(uid);
		if (log == null) {
			System.out.println("Activity log not found.");
			return;
		}

		System.out.print("Enter new user id: ");
		int nUserId = Integer.parseInt(sc.nextLine());

		System.out.print("Enter new file id: ");
		int nFileId = Integer.parseInt(sc.nextLine());

		System.out.print("Enter new action description: ");
		String nAction = sc.nextLine();

		log.setUserId(nUserId);
		log.setFileId(nFileId);
		log.setAction(nAction);
		al.updateActivityLogs(log);
		System.out.println("Activity log updated successfully!");
	}

	public void deleteLog() throws SQLException {
		System.out.print("Enter activity log id to delete: ");
		int did = Integer.parseInt(sc.nextLine());

		al.deleteActivityLog(did);
		System.out.println("Activity log deleted successfully!");
	}
}
