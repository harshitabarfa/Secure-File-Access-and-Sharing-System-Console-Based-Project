package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import com.model.sharedFile;
import com.service.sharedFileService;

public class sharedFileController {
	Scanner sc = new Scanner(System.in);
	sharedFileService sfs = new sharedFileService();

	public void addSharedFile() throws SQLException {
		System.out.print("Enter file id to share: ");
		int fileId = Integer.parseInt(sc.nextLine());

		System.out.print("Enter user id to share with: ");
		int sharedWith = Integer.parseInt(sc.nextLine());

		System.out.print("Can download? (true/false): ");
		boolean canDownload = Boolean.parseBoolean(sc.nextLine());

		sharedFile sf = new sharedFile();
		sf.setFileId(fileId);
		sf.setSharedWith(sharedWith);
		sf.setCanDownload(canDownload);

		sfs.addSharedFile(sf);
		System.out.println("Shared file added successfully!");
	}

	public void viewAllSharedFiles() throws SQLException {
		List<sharedFile> list = sfs.getAllSharedFiles();
		for (sharedFile sf1 : list) {
			System.out.println(sf1);
		}
	}

	public void searchSharedFileById() throws SQLException {
		System.out.print("Enter shared file id: ");
		int sfid = Integer.parseInt(sc.nextLine());

		sharedFile sf2 = sfs.getSharedFileById(sfid);
		if (sf2 != null) {
			System.out.println(sf2);
		} else {
			System.out.println("Shared file not found.");
		}
	}

	public void updateSharedFile() throws SQLException {
		System.out.print("Enter shared file id to update: ");
		int uid = Integer.parseInt(sc.nextLine());

		sharedFile sf3 = sfs.getSharedFileById(uid);
		if (sf3 == null) {
			System.out.println("Shared file not found.");
			return;
		}

		System.out.print("Enter new file id: ");
		int nFileId = Integer.parseInt(sc.nextLine());

		System.out.print("Enter new user id to share with: ");
		int nSharedWith = Integer.parseInt(sc.nextLine());

		System.out.print("Can download? (true/false): ");
		boolean nCanDownload = Boolean.parseBoolean(sc.nextLine());

		sf3.setFileId(nFileId);
		sf3.setSharedWith(nSharedWith);
		sf3.setCanDownload(nCanDownload);
		sfs.updateSharedFile(sf3);
		System.out.println("Shared file updated successfully!");
	}

	public void deleteSharedFile() throws SQLException {
		System.out.print("Enter shared file id to delete: ");
		int did = Integer.parseInt(sc.nextLine());

		sfs.deleteSharedFile(did);
		System.out.println("Shared file deleted successfully!");
	}
}
