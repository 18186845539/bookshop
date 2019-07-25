package org.ccunix.javaweb.model;

import java.io.Serializable;
import java.util.Set;

public class MemberLevelModel  implements Serializable{
	private int id;
	private String levelName;
	private int favourable;
    //加集合
	private Set<MemberModel> memberSet;//1:m
	public MemberLevelModel() {

	}

	public MemberLevelModel(int id, String levelName, int favourable) {
		super();
		this.id = id;
		this.levelName = levelName;
		this.favourable = favourable;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Set<MemberModel> getMemberSet() {
		return memberSet;
	}

	public void setMemberSet(Set<MemberModel> memberSet) {
		this.memberSet = memberSet;
	}

}
