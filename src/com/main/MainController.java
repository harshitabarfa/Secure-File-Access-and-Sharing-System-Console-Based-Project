package com.main;

import java.util.*;
import com.controller.*;
import com.model.users;

import java.sql.*;

public class MainController {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		usersController uc = new usersController();
		rolesController rc = new rolesController();
		filesController fc = new filesController();
		sharedFileController shc = new sharedFileController();
		activityLogController ac = new activityLogController();
		passwardResetController pc = new passwardResetController();
		notificationsController nc = new notificationsController();

		users loggedInUser = null;
		while (true) {
			loggedInUser = uc.login();
			if (loggedInUser != null) {
				break;
			} else {
				System.out.println("Please try again.");
			}
		}

		while (true) {
			System.out.println("\n----- Secure File Access & Sharing System -----");
			System.out.println("\n1. Role Management");
			System.out.println("2. User Management");
			System.out.println("3. File Management");
			System.out.println("4. Shared File Management");
			System.out.println("5. Activity Log Management");
			System.out.println("6. Password Reset Management");
			System.out.println("7. Notification Management");
			System.out.println("8. Exit");

			System.out.print("\nEnter choice: ");
			int mainChoice = Integer.parseInt(sc.nextLine());

			switch (mainChoice) {
				case 1:
					roleMenu(sc, rc);
					break;
				case 2:
					userMenu(sc, uc);
					break;
				case 3:
					fileMenu(sc, fc);
					break;
				case 4:
					sharedFileMenu(sc, shc);
					break;
				case 5:
					activityLogMenu(sc, ac);
					break;
				case 6:
					passwordResetMenu(sc, pc);
					break;
				case 7:
					notificationMenu(sc, nc);
					break;
				case 8:
					System.out.println("Exiting... Thank you!");
					System.exit(0);
				default:
					System.out.println("Invalid choice!");
			}
		}
	}

	public static void roleMenu(Scanner sc, rolesController rc) throws SQLException {
		while (true) {
			System.out.println("\n----- Role Menu -----");
			System.out.println("\n1. Add Role");
			System.out.println("2. View All Roles");
			System.out.println("3. Search Role by ID");
			System.out.println("4. Update Role");
			System.out.println("5. Delete Role");
			System.out.println("6. Back");

			System.out.print("\nEnter choice: ");
			int choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
				case 1:
					rc.addRole();
					break;
				case 2:
					rc.viewAllRoles();
					break;
				case 3:
					rc.viewRoleById();
					break;
				case 4:
					rc.updateRole();
					break;
				case 5:
					rc.deleteRole();
					break;
				case 6:
					return;
				default:
					System.out.println("Invalid choice!");
			}
		}
	}

	public static void userMenu(Scanner sc, usersController uc) throws SQLException {
		while (true) {
			System.out.println("\n----- User Menu -----");
			System.out.println("\n1. Add User");
			System.out.println("2. View All Users");
			System.out.println("3. Search User by ID");
			System.out.println("4. Update User");
			System.out.println("5. Delete User");
			System.out.println("6. Back");

			System.out.print("\nEnter choice: ");
			int choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
				case 1:
					uc.addUser();
					break;
				case 2:
					uc.getAllUsers();
					break;
				case 3:
					uc.getUsersById();
					break;
				case 4:
					uc.updateUsers();
					break;
				case 5:
					uc.deleteUsers();
					break;
				case 6:
					return;
				default:
					System.out.println("Invalid choice!");
			}
		}
	}

	public static void fileMenu(Scanner sc, filesController fc) throws SQLException {
		while (true) {
			System.out.println("\n----- File Menu -----");
			System.out.println("\n1. Upload File");
			System.out.println("2. View All Files");
			System.out.println("3. Search File by ID");
			System.out.println("4. Update File");
			System.out.println("5. Delete File");
			System.out.println("6. Back");

			System.out.print("\nEnter choice: ");
			int choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
				case 1:
					fc.addFile();
					break;
				case 2:
					fc.viewAllFiles();
					break;
				case 3:
					fc.viewFileById();
					break;
				case 4:
					fc.updateFile();
					break;
				case 5:
					fc.deleteFile();
					break;
				case 6:
					return;
				default:
					System.out.println("Invalid choice!");
			}
		}
	}

	public static void sharedFileMenu(Scanner sc, sharedFileController shc) throws SQLException {
		while (true) {
			System.out.println("\n----- Shared File Menu -----");
			System.out.println("\n1. Add Shared File");
			System.out.println("2. View All Shared Files");
			System.out.println("3. Search Shared File by ID");
			System.out.println("4. Update Shared File");
			System.out.println("5. Delete Shared File");
			System.out.println("6. Back");

			System.out.print("\nEnter choice: ");
			int choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
				case 1:
					shc.addSharedFile();
					break;
				case 2:
					shc.viewAllSharedFiles();
					break;
				case 3:
					shc.searchSharedFileById();
					break;
				case 4:
					shc.updateSharedFile();
					break;
				case 5:
					shc.deleteSharedFile();
					break;
				case 6:
					return;
				default:
					System.out.println("Invalid choice!");
			}
		}
	}

	public static void activityLogMenu(Scanner sc, activityLogController ac) throws SQLException {
		while (true) {
			System.out.println("\n----- Activity Log Menu -----");
			System.out.println("\n1. Add Log Entry");
			System.out.println("2. View All Logs");
			System.out.println("3. Search Log by ID");
			System.out.println("4. Delete Log");
			System.out.println("5. Back");

			System.out.print("\nEnter choice: ");
			int choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
				case 1:
					ac.addLog();
					break;
				case 2:
					ac.viewAllLogs();
					break;
				case 3:
					ac.searchLogById();
					break;
				case 4:
					ac.deleteLog();
					break;
				case 5:
					return;
				default:
					System.out.println("Invalid choice!");
			}
		}
	}

	public static void passwordResetMenu(Scanner sc, passwardResetController pc) throws SQLException {
		while (true) {
			System.out.println("\n----- Password Reset Menu -----");
			System.out.println("\n1. Request Password Reset");
			System.out.println("2. View All Reset Requests");
			System.out.println("3. Search Reset Request by ID");
			System.out.println("4. Approve/Reject Reset Request");
			System.out.println("5. Delete Reset Request");
			System.out.println("6. Back");

			System.out.print("\nEnter choice: ");
			int choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
				case 1:
					pc.requestReset();
					break;
				case 2:
					pc.viewAllRequests();
					break;
				case 3:
					pc.searchRequestById();
					break;
				case 4:
					pc.processRequest();
					break;
				case 5:
					pc.deleteRequest();
					break;
				case 6:
					return;
				default:
					System.out.println("Invalid choice!");
			}
		}
	}

	public static void notificationMenu(Scanner sc, notificationsController nc) throws SQLException {
		while (true) {
			System.out.println("\n----- Notification Menu -----");
			System.out.println("\n1. Send Notification");
			System.out.println("2. View All Notifications");
			System.out.println("3. Search Notification by ID");
			System.out.println("4. Delete Notification");
			System.out.println("5. Back");

			System.out.print("\nEnter choice: ");
			int choice = Integer.parseInt(sc.nextLine());

			switch (choice) {
				case 1:
					nc.addNotification();
					break;
				case 2:
					nc.viewAllNotifications();
					break;
				case 3:
					nc.markAsRead();
					break;
				case 4:
					nc.deleteNotification();
					break;
				case 5:
					return;
				default:
					System.out.println("Invalid choice!");
			}
		}
	}
}
