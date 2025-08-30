package com.service;

import java.sql.SQLException;
import java.util.List;
import com.dao.usersDao;
import com.model.users;

public class usersService {
	usersDao dao = new usersDao();

	public users login(String username, String passward) throws SQLException {
        return dao.login(username, passward);
    }

	public void addUser(users u) throws SQLException {
		dao.addUser(u);
	}

	public List<users> getAllUsers() throws SQLException {
		return dao.getAllUsers();
	}

	public users getUsersById(int id) throws SQLException {
		return dao.getUsersById(id);
	}

	public boolean authenticateUser(String username, String password) throws SQLException {
		users u = dao.getUserByUsername(username);
		if (u != null) {
			return u.getPassward().equals(password);
		}
		return false;
	}

	public void updateUsers(users u) throws SQLException {
		dao.updateUsers(u);
	}

	public void deleteUsers(int id) throws SQLException {
		dao.deleteUsers(id);
	}

	public void updateUser(int id, String username, String email, String passward, int roleId) throws SQLException {
	    users u = new users();
	    u.setUserId(id);
	    u.setUsername(username);
	    u.setEmail(email);
	    u.setPassward(passward);
	    u.setRoleId(roleId);
	    dao.updateUsers(u);
	}

	public void addUser(String username, String email, String passward, int roleId) throws SQLException {
		users u = new users();
	    u.setUsername(username);
	    u.setEmail(email);
	    u.setPassward(passward);
	    u.setRoleId(roleId);
	    dao.addUser(u);
	}
}
