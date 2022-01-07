package ExamMidTermOOP;

import java.util.Scanner;

public class Person {
	
	static CustomerList cuslist = new CustomerList();
	
	static Scanner sc = new Scanner(System.in);
	
	private String name;
	
	private String address;
	
	private String phone;
	
	private String date;
	
	private String sex;

	public Person() {

	}

	public Person(String name, String address, String phone, String date, String sex) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.date = date;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public void input() {
		System.out.println("Enter last and first name: ");
		name = sc.nextLine();
		
		System.out.println("Enter address: ");
		address = sc.nextLine();
		
		System.out.println("Enter phone number: ");
		phone = sc.nextLine();
		
		System.out.println("Enter date: ");
		date = sc.nextLine();
		
		System.out.println("Enter sex (male / female): ");
		sex = sc.nextLine();
	}
	
	// Khai báo phương thức Abstract
	public void display() {
		
	}
	
//	public static void main(String[] args) {
//		Customer cus = new Customer();
//		cus.inputs();
//		cuslist.PrintCustomer();
//	}
}
