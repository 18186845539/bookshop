package org.ccunix.javaweb.service.impl;

import java.util.Date;
import java.util.List;

import org.ccunix.javaweb.dao.impl_sql.LeavewordDAO;
import org.ccunix.javaweb.model.LeaveWordModel;
import org.ccunix.javaweb.service.iface.LeavewordServiceIface;
import org.ccunix.javaweb.util.DateFormatUtil;
import org.ccunix.javaweb.vo.LeaveWordVO;

public class LeavewordServiceImpl implements LeavewordServiceIface{
    private LeavewordDAO leavewordDAO = new LeavewordDAO();
	@Override
	public boolean addLeaveword(String title, String content,int member) {
		//业务层进行数据组装
		String leaveDate = DateFormatUtil.getParseDate(new Date(), "yyyy-MM-dd HH:mm:ss");
		return leavewordDAO.addLeaveword(title, content,member,leaveDate);
	}

	@Override
	public List<LeaveWordVO> getLeaveWordModelList() {
		return leavewordDAO.getLeaveWordModelList();
	}

}
