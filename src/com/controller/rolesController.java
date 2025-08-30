package com.controller;

import java.sql.*;
import com.model.*;
import com.service.*;
import java.util.*;

public class rolesController {

	Scanner sc = new Scanner(System.in);
	rolesService rs = new rolesService();
	
	public void addRole() throws SQLException {
		System.out.print("\nEnter role name: ");
		String name = sc.nextLine();
		roles r = new roles();
		r.setRoleName(name);
		rs.addRoles(r);
		System.out.println("Role added successfully!");
	}

	public void viewAllRoles() throws SQLException {
		List<roles> list = rs.getAllRoles();
		if (list.isEmpty()) {
			System.out.println("No roles found!");
		} else {
			for (roles r : list) {
				System.out.println(r);
			}
		}
	}

	public void viewRoleById() throws SQLException {
		System.out.print("Enter role id: ");
		int id = Integer.parseInt(sc.nextLine());
		roles r = rs.getRolesById(id);
		if (r != null) {
			System.out.println(r);
		} else {
			System.out.println("Role not found!");
		}
	}

	public void updateRole() throws SQLException {
		System.out.print("Enter role id to update: ");
		int uid = Integer.parseInt(sc.nextLine());
		roles r = rs.getRolesById(uid);

		if (r != null) {
			System.out.print("Enter new role name: ");
			String newName = sc.nextLine();
			r.setRoleName(newName);
			rs.updateRoles(r);
			System.out.println("Role updated successfully!");
		} else {
			System.out.println("Role not found!");
		}
	}

	public void deleteRole() throws SQLException {
		System.out.print("Enter role id to delete: ");
		int did = Integer.parseInt(sc.nextLine());
		roles r = rs.getRolesById(did);

		if (r != null) {
			rs.deleteRoles(did);
			System.out.println("Role deleted successfully!");
		} else {
			System.out.println("Role not found!");
		}
	}
}