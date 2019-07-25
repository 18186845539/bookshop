package org.ccunix.javaweb.vo;

import org.ccunix.javaweb.model.MemberModel;

public class MemberVO extends MemberModel{

	private String levelName;
	private int favourable;
	
	public MemberVO(int id, int memberLevel, String memberName, String loginName, String loginPwd, String phone,
			String address, String zip, String regDate, String lastDate, int loginTimes, String email,String levelName,int favourable) {
		super(id, memberLevel, memberName, loginName, loginPwd, phone, address, zip, regDate, lastDate, loginTimes, email);
		this.levelName = levelName;
		this.favourable = favourable;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public int getFavourable() {
		return favourable;
	}

	public void setFavourable(int favourable) {
		this.favourable = favourable;
	}
	
}
