package com.ggr.temp;

public class Person {

	private String name;
	private String age;
	private String phones;
	private String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhones() {
		return phones;
	}
	public void setPhones(String phones) {
		this.phones = phones;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Person(String name, String age, String phones, String address) {
		super();
		this.name = name;
		this.age = age;
		this.phones = phones;
		this.address = address;
	}
	
	
}
