package org.ccunix.javaweb.vo;

import org.ccunix.javaweb.model.LeaveWordModel;

public class LeaveWordVO extends LeaveWordModel {
	// 会员姓名
	private String memberName;

	public LeaveWordVO(int id, int member, int admin, String title, String content, String leaveDate,
			String answerContent, String answerDate, String memberName) {
		super(id, member, admin, title, content, leaveDate, answerContent, answerDate);
        this.memberName = memberName;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

}
