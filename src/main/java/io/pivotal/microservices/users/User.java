package io.pivotal.microservices.users;

public class User {
	
	int id;
	String name;
	int age;
	String sex;
	String address;
	
	public User(){
		super();
	}
	
	public User(int id, String name, int age, String sex, String address){
		
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.address = address;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
