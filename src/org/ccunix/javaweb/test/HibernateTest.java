package org.ccunix.javaweb.test;

import java.util.List;

import org.ccunix.javaweb.model.MemberModel;
import org.ccunix.javaweb.util.DBManager;
import org.hibernate.Query;
import org.hibernate.Session;

public class HibernateTest {

	public static void main(String[] args) {
		
		Session session = DBManager.getSession();
		//查单个
		/*MemberModel memberModel =(MemberModel) session.get(MemberModel.class, 19);
		System.out.println(memberModel.getMemberName());*/
		//查多个 
		Query query = session.createQuery("From MemberModel");
		List<MemberModel> memberList = query.list();
		System.out.println("-------------------"+memberList.size());
		System.out.println(session);
	}
}
