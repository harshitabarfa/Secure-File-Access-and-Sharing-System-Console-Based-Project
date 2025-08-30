package com.service;

import java.sql.SQLException;
import java.util.List;

import com.model.*;
import com.dao.*;

public class rolesService {
	rolesDao dao = new rolesDao();

	public void addRoles(roles r) throws SQLException {
		dao.addRoles(r);
	}

	public List<roles> getAllRoles() throws SQLException {
		return dao.getAllRoles();
	}

	public roles getRolesById(int id) throws SQLException {
		return dao.getRolesById(id);
	}

	public void updateRoles(roles r) throws SQLException {
		dao.updateRoles(r);
	}

	public void deleteRoles(int id) throws SQLException {
		dao.deleteRoles(id);
	}

	public void updateRole(int id, String roleName) throws SQLException {
		dao.updateRole(id, roleName);
	}
	
	public void addRoles(String roleName) throws SQLException {
	    roles r = new roles();
	    r.setRoleName(roleName);
		addRoles(r);
	}

}
