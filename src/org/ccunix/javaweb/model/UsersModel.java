package org.ccunix.javaweb.model;

public class UsersModel {
	private int id;
	private String username;
	private String password;
	private int age;
	private String sex;
	private String hobby;
	private String photo;
	private int limits;
	public UsersModel(){
		System.out.println("usermodel default  初始化.....................");
	}
	public UsersModel(String username,String password){
		this.username = username;
		this.password=password;
	}
	public UsersModel(String username, String password, int age,
			String sex, String hobby, String photo) {
		this.username = username;
		this.password = password;
		this.age = age;
		this.sex = sex;
		this.hobby = hobby;
		this.photo = photo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		System.out.println("get username...................");
		return username;
	}
	public void setUsername(String username) {
		System.out.println("set username...................");
		this.username = username;
	}
	public String getPassword() {
		System.out.println("get password...................");
		return password;
	}
	public void setPassword(String password) {
		System.out.println("set password...................");
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public int getLimits() {
		return limits;
	}
	public void setLimits(int limits) {
		this.limits = limits;
	}

}
