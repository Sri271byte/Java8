package com.Employee;

public class Employee {
	
	private Integer Id;
	private String Name;
	private Integer Age;
	private String Gender;
	private Long Salary;
	private String Department;
	private String Status;
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Integer getAge() {
		return Age;
	}

	public void setAge(Integer age) {
		Age = age;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public Long getSalary() {
		return Salary;
	}

	public void setSalary(Long salary) {
		Salary = salary;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	

	public Employee(Integer id, String name, Integer age, String gender, Long salary, String department, String status) {
	    this.Id = id;
	    this.Name = name;
	    this.Age = age;
	    this.Gender = gender;
	    this.Salary = salary;
	    this.Department = department;
	    this.Status = status;
	}

	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", Name=" + Name + ", Age=" + Age + ", Gender=" + Gender + ", Salary=" + Salary
				+ ", Department=" + Department + ", Status=" + Status + "]";
	}


	
	
	
	

}
