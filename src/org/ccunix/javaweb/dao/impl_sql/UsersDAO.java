package org.ccunix.javaweb.dao.impl_sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.ccunix.javaweb.model.UsersModel;
import org.ccunix.javaweb.util.DBManager;

public class UsersDAO {

	public boolean regedit(UsersModel usersModel) throws SQLException{
		Connection connection = DBManager.getConnection();
		PreparedStatement statement = null;
		String sql="insert into users (username,password,sex,age,hobby) values (?,?,?,?,?)";
		statement = connection.prepareStatement(sql);
		statement.setString(1, usersModel.getUsername());
		statement.setString(2, usersModel.getPassword());
		statement.setString(3, usersModel.getSex());
		statement.setInt(4, usersModel.getAge());
		statement.setString(5, usersModel.getHobby());
		int row = statement.executeUpdate();
		
		if(row>0){
			return true;
		}
		return false;
	}
}
