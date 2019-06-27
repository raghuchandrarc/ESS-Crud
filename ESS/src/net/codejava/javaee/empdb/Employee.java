package net.codejava.javaee.empdb;

/**
 * Employee.java
 * This is a model class represents a book entity
 * 
 *
 */
public class Employee {
	protected int id;
	protected String empname;
	protected String empdesignation;
	protected String location;

	public Employee() {
	}

	public Employee(int id) {
		this.id = id;
	}

	public Employee(int id, String empname, String designation, String location) {
		this(empname, designation, location);
		this.id = id;
	}
	
	public Employee(String title, String designation, String location) {
		this.empname = title;
		this.empdesignation = designation;
		this.location = location;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}



	public String getEmpdesignation() {
		return empdesignation;
	}

	public void setEmpdesignation(String empdesignation) {
		this.empdesignation = empdesignation;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	/*public String getTitle() {
		return employeeName;
	}

	public void setTitle(String title) {
		this.employeeName = title;
	}

	public String getAuthor() {
		return designation;
	}

	public void setAuthor(String author) {
		this.designation = author;
	}

	public String getPrice() {
		return location;
	}

	public void setPrice(String price) {
		this.location = price;
	}*/

}
