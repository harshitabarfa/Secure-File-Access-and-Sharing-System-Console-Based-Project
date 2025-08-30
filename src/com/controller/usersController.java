package com.controller;

import java.sql.*;
import java.util.*;
import com.model.*;
import com.service.usersService;

public class usersController {
    Scanner sc = new Scanner(System.in);
    usersService us = new usersService();

    public users login() throws SQLException {
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter passward: ");
        String passward = sc.nextLine();

        users u = us.login(username, passward);
        if (u != null) {
            System.out.println("Login successful! Welcome, " + u.getUsername());
        } else {
            System.out.println("Invalid username or passward!");
        }
        return u;
    }

    public void addUser() throws SQLException {
        System.out.print("\nEnter user name: ");
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        System.out.print("Enter role id: ");
        int roleId = Integer.parseInt(sc.nextLine());

        users u = new users();
        u.setUsername(name);
        u.setEmail(email);
        u.setPassward(password);
        u.setRoleId(roleId);

        us.addUser(u);
        System.out.println("User added successfully!");
    }

    public void getAllUsers() throws SQLException {
        List<users> list = us.getAllUsers();
        if (list.isEmpty()) {
            System.out.println("No users found!");
        } else {
            for (users u : list) {
                System.out.println(u);
            }
        }
    }

    public void getUsersById() throws SQLException {
        System.out.print("Enter user id: ");
        int id = Integer.parseInt(sc.nextLine());
        users u = us.getUsersById(id);

        if (u != null) {
            System.out.println(u);
        } else {
            System.out.println("User not found!");
        }
    }

    public void updateUsers() throws SQLException {
        System.out.print("Enter user id to update: ");
        int uid = Integer.parseInt(sc.nextLine());
        users u = us.getUsersById(uid);

        if (u != null) {
            System.out.print("Enter new username: ");
            String nName = sc.nextLine();
            System.out.print("Enter new email: ");
            String nEmail = sc.nextLine();
            System.out.print("Enter new password: ");
            String nPassword = sc.nextLine();
            System.out.print("Enter new role id: ");
            int nRoleId = Integer.parseInt(sc.nextLine());

            u.setUsername(nName);
            u.setEmail(nEmail);
            u.setPassward(nPassword);
            u.setRoleId(nRoleId);

            us.updateUsers(u);
            System.out.println("User updated successfully!");
        } else {
            System.out.println("User not found!");
        }
    }

    public void deleteUsers() throws SQLException {
        System.out.print("Enter user id to delete: ");
        int did = Integer.parseInt(sc.nextLine());
        users u = us.getUsersById(did);

        if (u != null) {
            us.deleteUsers(did);
            System.out.println("User deleted successfully!");
        } else {
            System.out.println("User not found!");
        }
    }
}