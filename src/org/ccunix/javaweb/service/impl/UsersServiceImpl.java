package org.ccunix.javaweb.service.impl;

import java.sql.SQLException;

import org.ccunix.javaweb.dao.impl_sql.UsersDAO;
import org.ccunix.javaweb.model.UsersModel;
import org.ccunix.javaweb.service.iface.UsersServiceIface;

public class UsersServiceImpl implements UsersServiceIface{

	@Override
	public boolean regedit(String username, String password, String sex,
			String hobby, int age,String photo) throws SQLException {
		UsersDAO usersDAO = new UsersDAO();
		UsersModel usersModel = new UsersModel(username, password, age, sex, hobby, photo);
		boolean b = usersDAO.regedit(usersModel);
		return b;
	}

}
