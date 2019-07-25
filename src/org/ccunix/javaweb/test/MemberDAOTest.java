package org.ccunix.javaweb.test;

import org.ccunix.javaweb.dao.impl_sql.MemberDAO;
import org.ccunix.javaweb.model.MemberModel;

public class MemberDAOTest {
	
	public static void main(String[] args) {
		
		MemberDAO memberDAO = new MemberDAO();
		
		MemberModel model = memberDAO.loginValidate("steven", "123");
		System.out.println(model);
	}

}
