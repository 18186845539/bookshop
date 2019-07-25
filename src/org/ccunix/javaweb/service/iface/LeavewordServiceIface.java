package org.ccunix.javaweb.service.iface;

import java.util.List;

import org.ccunix.javaweb.model.LeaveWordModel;
import org.ccunix.javaweb.vo.LeaveWordVO;

public interface LeavewordServiceIface {
	/**
	 * 发表留言
	 * @param title 标题
	 * @param content 内容
	 * @param member  会员id
	 * @return 
	 */
	public boolean addLeaveword(String title,String content,int member);
	/**
	 *  获得全部留言列表
	 * @return
	 */
	public List<LeaveWordVO> getLeaveWordModelList();
}
