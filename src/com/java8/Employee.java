package com.java8;


public class Employee {
	
	private int employeeId;
    private String name;
    private int age;
    private String department;
    private double salary;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	
	public Employee(int employeeId, String name, int age, String department, double salary) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.age = age;
		this.department = department;
		this.salary = salary;
	}
    
	 @Override
	    public String toString(){
	        return employeeId + " - " + name + " - " + age + " - " + department + " - " + salary;
	    }

}
