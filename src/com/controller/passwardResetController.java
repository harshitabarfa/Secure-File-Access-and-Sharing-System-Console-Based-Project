package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import com.model.passwardReset;
import com.service.passwardResetService;

public class passwardResetController {
	Scanner sc = new Scanner(System.in);
	passwardResetService pr = new passwardResetService();

	public void requestReset() throws SQLException {
		System.out.print("Enter user id: ");
		int userId = Integer.parseInt(sc.nextLine());

		System.out.print("Enter reset token: ");
		String resetToken = sc.nextLine();

		passwardReset pr1 = new passwardReset();
		pr1.setUserId(userId);
		pr1.setResetToken(resetToken);

		pr.addPasswardReset(pr1);
		System.out.println("Password reset request added successfully!");
	}

	public void viewAllRequests() throws SQLException {
		List<passwardReset> list = pr.getAllPasswardResets();
		for (passwardReset pr2 : list) {
			System.out.println(pr2);
		}
	}

	public void searchRequestById() throws SQLException {
		System.out.print("Enter reset id: ");
		int id = Integer.parseInt(sc.nextLine());

		passwardReset pr3 = pr.getPasswardResetById(id);
		if (pr3 != null) {
			System.out.println(pr3);
		} else {
			System.out.println("Password reset request not found.");
		}
	}

	public void processRequest() throws SQLException {
		System.out.print("Enter reset id to update: ");
		int uid = Integer.parseInt(sc.nextLine());

		passwardReset pr4 = pr.getPasswardResetById(uid);
		if (pr4 == null) {
			System.out.println("Password reset request not found.");
			return;
		}

		System.out.print("Enter new user id: ");
		int nUserId = Integer.parseInt(sc.nextLine());

		System.out.print("Enter new reset token: ");
		String nTokenReset = sc.nextLine();

		pr4.setUserId(nUserId);
		pr4.setResetToken(nTokenReset);
		pr.updatePasswardReset(pr4);
		System.out.println("Password reset request updated successfully!");
	}

	public void deleteRequest() throws SQLException {
		System.out.print("Enter reset id to delete: ");
		int did = Integer.parseInt(sc.nextLine());

		pr.deletePasswardReset(did);
		System.out.println("Password reset request deleted successfully!");
	}
}
