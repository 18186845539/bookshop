package org.ccunix.javaweb.service.iface;

import java.sql.SQLException;

public interface UsersServiceIface {
    

	
	
	
	public boolean regedit(String username,String password,String sex,String hobby,int age,String photo) throws SQLException;
}
