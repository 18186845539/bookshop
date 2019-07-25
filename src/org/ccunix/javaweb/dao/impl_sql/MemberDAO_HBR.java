package org.ccunix.javaweb.dao.impl_sql;

import java.util.List;

import org.ccunix.javaweb.dao.iface.MemberDAO_Iface;
import org.ccunix.javaweb.model.MemberLevelModel;
import org.ccunix.javaweb.model.MemberModel;
import org.ccunix.javaweb.util.DBManager;
import org.ccunix.javaweb.vo.MemberVO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MemberDAO_HBR implements MemberDAO_Iface {

	public MemberVO loginValidate(String loginName, String loginPwd) {

		MemberVO memberModelVO = null;
		Session session = DBManager.getSession();
		Query query = null;
		//String hql = " from MemberModel where loginName='" + loginName + "' and loginPwd='" + loginPwd + "'";
		//String hql1= " from MemberModel where loginName=? and  loginPwd=?";
//		query.setParameter(0, loginName);
//		query.setParameter(1, loginPwd);
		String hql2 = " from MemberModel where loginName=:aaa and  loginPwd=:bbb";
		query = session.createQuery(hql2);
		
		query.setParameter("aaa", loginName);
		query.setParameter("bbb", loginPwd);
		
	  /*	List<MemberModel> list = query.list();
		
		
		if (list.size() > 0) {
			MemberModel member = list.get(0);
			MemberLevelModel levelModel = member.getLevelModel();
			memberModel = new MemberVO(member.getId(), member.getMemberLevel(), member.getMemberName(),
					member.getLoginName(), member.getLoginPwd(), member.getPhone(), member.getAddress(),
					member.getZip(), member.getRegDate(), member.getLastDate(), member.getLoginTimes(),
					member.getEmail(), levelModel.getLevelName(), 123);
		}*/
		
		//针对只返回单个对象时
		MemberModel member = (MemberModel) query.uniqueResult();
		memberModelVO = new MemberVO(member.getId(), member.getMemberLevel(), member.getMemberName(),
				member.getLoginName(), member.getLoginPwd(), member.getPhone(), member.getAddress(),
				member.getZip(), member.getRegDate(), member.getLastDate(), member.getLoginTimes(),
				member.getEmail(),member.getLevelModel().getLevelName(), 123);
		return memberModelVO;
	}

	@Override
	public boolean regedit(MemberModel model) {
		Session session =DBManager.getSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(model);
			transaction.commit();
			session.close();
			return true;
		}catch(Exception e) {
			transaction.rollback();
			return false;
		}
		
	}

	@Override
	public boolean exitUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(int id, MemberModel model) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {
		/*MemberVO memberVO = new MemberDAO_HBR().loginValidate("steven", "123");
		System.out.println(memberVO);*/
		
		
		Session session = DBManager.getSession();
		//通过主键获得对象
		//Object obj = session.get(MemberModel.class, 119);
		//Object obj = session.load(MemberModel.class, 119);
				
		//System.out.println(obj);
		//hibernate对象的三种状态     操作的是对象   存到数据库中   持久化
		//瞬时对象
		MemberModel memberModel = new MemberModel();
		memberModel.setLoginName("steven111");
		memberModel.setLoginPwd("123");
		
		
		session.beginTransaction();
		//持久化对象   存在hibernate的session会话中
		session.save(memberModel);
		
		memberModel.setMemberLevel(1);
		memberModel.setEmail("123@qq.com");
		memberModel.setLoginName("bobo111");
		memberModel.setLoginPwd("123456");
		

		session.getTransaction().commit();
		//托管对象
		memberModel.setLoginName("bobobobob111");
	}
}
