package org.ccunix.javaweb.dao.iface;

import org.ccunix.javaweb.model.MemberModel;
import org.ccunix.javaweb.vo.MemberVO;

public interface MemberDAO_Iface {

	public MemberVO loginValidate(String loginName, String loginPwd);

	public boolean regedit(MemberModel model);
	public boolean exitUser() ;
	public boolean update(int id, MemberModel model);
	
}
