package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import com.model.files;
import com.service.filesService;

public class filesController {
	Scanner sc = new Scanner(System.in);
	filesService fs = new filesService();

	public void addFile() throws SQLException {
		System.out.print("Enter file name: ");
		String name = sc.nextLine();

		System.out.print("Enter file path: ");
		String path = sc.nextLine();

		System.out.print("Enter uploaded by (user id): ");
		int uploadedBy = Integer.parseInt(sc.nextLine());

		files f = new files();
		f.setFileName(name);
		f.setFilePath(path);
		f.setUploadedBy(uploadedBy);

		fs.addFiles(f);
		System.out.println("File added successfully!");
	}

	public void viewAllFiles() throws SQLException {
		List<files> list = fs.getAllFiles();
		for (files f1 : list) {
			System.out.println(f1);
		}
	}

	public void viewFileById() throws SQLException {
		System.out.print("Enter file id: ");
		int id = Integer.parseInt(sc.nextLine());

		files f2 = fs.getFilesById(id);
		if (f2 != null) {
			System.out.println(f2);
		} else {
			System.out.println("File not found.");
		}
	}

	public void updateFile() throws SQLException {
		System.out.print("Enter file id to update: ");
		int uid = Integer.parseInt(sc.nextLine());

		files f3 = fs.getFilesById(uid);
		if (f3 == null) {
			System.out.println("File not found.");
			return;
		}

		System.out.print("Enter new file name: ");
		String nName = sc.nextLine();

		System.out.print("Enter new file path: ");
		String nPath = sc.nextLine();

		System.out.print("Enter new uploaded by (user id): ");
		int nUploadedBy = Integer.parseInt(sc.nextLine());

		f3.setFileName(nName);
		f3.setFilePath(nPath);
		f3.setUploadedBy(nUploadedBy);
		fs.updateFiles(f3);
		System.out.println("File updated successfully!");
	}

	public void deleteFile() throws SQLException {
		System.out.print("Enter file id to delete: ");
		int did = Integer.parseInt(sc.nextLine());

		fs.deleteFiles(did);
		System.out.println("File deleted successfully!");
	}
}
