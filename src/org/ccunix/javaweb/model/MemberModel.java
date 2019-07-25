package org.ccunix.javaweb.model;

import java.io.Serializable;
import java.util.Set;

public class MemberModel implements Serializable{
	
	    private static final long serialVersionUID = -776232935745573935L;
		private int id;  //用户id
		private int memberLevel;//会员级别
		private String memberName; //用户姓名
		private String loginName; //用户登录名
		private String loginPwd; //用户登录密码
		private String phone;   //电话号
		private String address;  //地址
		private String zip;   //邮编
		private String regDate; //注册时间
		private String lastDate; //最后登录时间
		private int loginTimes; //登录次数
		private String email;  //电子邮箱
		
		
		private MemberLevelModel levelModel;
		private Set<OrderModel> ordersSet ;
		
		
		public MemberLevelModel getLevelModel() {
			return levelModel;
		}
		public void setLevelModel(MemberLevelModel levelModel) {
			this.levelModel = levelModel;
		}
		public MemberModel() {
			
		}
		public MemberModel( int memberLevel, String memberName, String loginName, String loginPwd, String phone,
				String address, String zip,String email) {
			this.memberLevel = memberLevel;
			this.memberName = memberName;
			this.loginName = loginName;
			this.loginPwd = loginPwd;
			this.phone = phone;
			this.address = address;
			this.zip = zip;
			this.email = email;
		}
		public MemberModel(int id, int memberLevel, String memberName, String loginName, String loginPwd, String phone,
				String address, String zip, String regDate, String lastDate, int loginTimes, String email) {
			this.id = id;
			this.memberLevel = memberLevel;
			this.memberName = memberName;
			this.loginName = loginName;
			this.loginPwd = loginPwd;
			this.phone = phone;
			this.address = address;
			this.zip = zip;
			this.regDate = regDate;
			this.lastDate = lastDate;
			this.loginTimes = loginTimes;
			this.email = email;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getMemberLevel() {
			return memberLevel;
		}
		public void setMemberLevel(int memberLevel) {
			this.memberLevel = memberLevel;
		}
		public String getMemberName() {
			return memberName;
		}
		public void setMemberName(String menberName) {
			this.memberName = menberName;
		}
		public String getLoginName() {
			return loginName;
		}
		public void setLoginName(String loginName) {
			this.loginName = loginName;
		}
		public String getLoginPwd() {
			return loginPwd;
		}
		public void setLoginPwd(String loginPwd) {
			this.loginPwd = loginPwd;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getZip() {
			return zip;
		}
		public void setZip(String zip) {
			this.zip = zip;
		}
		public String getRegDate() {
			return regDate;
		}
		public void setRegDate(String regDate) {
			this.regDate = regDate;
		}
		public String getLastDate() {
			return lastDate;
		}
		public void setLastDate(String lastDate) {
			this.lastDate = lastDate;
		}
		public int getLoginTimes() {
			return loginTimes;
		}
		public void setLoginTimes(int loginTimes) {
			this.loginTimes = loginTimes;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Set<OrderModel> getOrdersSet() {
			return ordersSet;
		}
		public void setOrdersSet(Set<OrderModel> ordersSet) {
			this.ordersSet = ordersSet;
		}
		
}

