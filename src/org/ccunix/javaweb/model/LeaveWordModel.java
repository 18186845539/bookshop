package org.ccunix.javaweb.model;

import java.io.Serializable;

public class LeaveWordModel implements Serializable{

	private int id; 
	private int member;  
	private int admin;
	private String title; 
	private String content;  
	private String leaveDate;  
	private String answerContent; 
	private String answerDate; 
	
	private MemberModel memberModel;//m:1
	public LeaveWordModel() {
		
	}
	public LeaveWordModel(int id, int member,int admin, String title, String content, String leaveDate, String answerContent,
			String answerDate) {
		this.id = id;
		this.member = member;
		this.admin=admin;
		this.title = title;
		this.content = content;
		this.leaveDate = leaveDate;
		this.answerContent = answerContent;
		this.answerDate = answerDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMember() {
		return member;
	}
	public void setMember(int member) {
		this.member = member;
	}
	
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	public String getAnswerDate() {
		return answerDate;
	}
	public void setAnswerDate(String answerDate) {
		this.answerDate = answerDate;
	}
	public MemberModel getMemberModel() {
		return memberModel;
	}
	public void setMemberModel(MemberModel memberModel) {
		this.memberModel = memberModel;
	}
	
    
}
