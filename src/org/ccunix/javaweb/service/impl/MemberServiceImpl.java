package org.ccunix.javaweb.service.impl;

import java.util.Date;

import org.ccunix.javaweb.dao.iface.MemberDAO_Iface;
import org.ccunix.javaweb.dao.impl_sql.MemberDAO;
import org.ccunix.javaweb.dao.impl_sql.MemberDAO_HBR;
import org.ccunix.javaweb.model.MemberModel;
import org.ccunix.javaweb.service.iface.MemberServiceIface;
import org.ccunix.javaweb.util.DateFormatUtil;
import org.ccunix.javaweb.vo.MemberVO;

public class MemberServiceImpl implements MemberServiceIface{
    //MemberDAO_Iface memberDAO_Iface = new MemberDAO_HBR();
	
    private  MemberDAO memberDAO = new MemberDAO();
//    private MemberDAO_HBR memberdao_hbm = new MemberDAO_HBR();
    
	public MemberVO loginValidate(String loginName, String loginPwd) {
		
		return memberDAO.loginValidate(loginName, loginPwd);
		//return memberDAO_Iface.loginValidate(loginName, loginPwd);
	}

	@Override
	public boolean regedit(int memberLevel, String memberName, String loginName, String loginPwd, String phone,
			String address, String zip, String email) {
		MemberModel model = new MemberModel();
		model.setMemberName(memberName);
		model.setMemberLevel(memberLevel);
		
		//return memberDAO_Iface.regedit(model);
		return memberDAO.regedit(model);
	}

	@Override
	public boolean exitUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(int id, int memberLevel, String memberName, String loginName, String loginPwd, String phone,
			String address, String zip, String email) {
		MemberModel model = new MemberModel(memberLevel, memberName, loginName, loginPwd, phone, address, zip, email);
		Date date = new Date();
		//2018-09-11 16:55:58
		String regDate = DateFormatUtil.getParseDate(date, "yyyy-MM-dd HH:mm:ss");
		model.setRegDate(regDate);
		
//		return memberDAO.update(id, model);
		return false;
	}

}
