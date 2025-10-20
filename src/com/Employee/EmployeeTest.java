package com.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

public class EmployeeTest {
	
	public static void main(String[] args) {
		
		List<Employee> employees = new ArrayList<Employee>();	
		
		employees.add(new Employee(101, "Rahul ", 29, "Male", 75000L, "IT", "Active"));
        employees.add(new Employee(102, "Priya ", 32, "Female", 85000L, "HR", "Active"));
        employees.add(new Employee(103, "Arjun ", 26, "Male", 60000L, "Finance", "On Leave"));
        employees.add(new Employee(104, "Sneha ", 28, "Female", 92000L, "Marketing", "Active"));
        employees.add(new Employee(105, "Vikram ", 40, "Male", 110000L, "Management", "Inactive"));
        employees.add(new Employee(106, "Neha ", 35, "Female", 97000L, "Operations", "Active"));
        employees.add(new Employee(107, "Rohit ", 31, "Male", 72000L, "IT", "Active"));
        employees.add(new Employee(108, "Anita ", 30, "Female", 68000L, "Finance", "Active"));
        employees.add(new Employee(109, "Karan ", 27, "Male", 64000L, "Sales", "On Leave"));
        employees.add(new Employee(110, "Divya ", 33, "Female", 88000L, "HR", "Active"));
        
        
        // Filters
        List<String> dept = employees.stream().filter(e->e.getSalary() > 90000) .map(Employee::getDepartment).distinct().collect(Collectors.toList());
        System.out.println("Print all departments with 90000 above salary  : "+ dept);
        
        Map<String, List<Employee>> GroupingByGender = employees.stream().collect(Collectors.groupingBy(Employee::getGender));
        System.out.println("GroupingByGender : "+GroupingByGender);
        
        Map<String, List<String>> GroupingByGenderNames = employees.stream()
        .collect(Collectors.groupingBy(Employee::getGender,Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println("GroupingByGenderNames : "+GroupingByGenderNames);

        Map<Integer,String> devEmployees= employees.stream().filter(e-> e.getDepartment().equals("HR") && e.getSalary() > 70000)
                                                   .collect(Collectors.toMap(Employee::getAge,Employee::getName));
        System.out.println("HR'S High salary avove 70000 :"+devEmployees);
        
        Employee maxSalary = employees.stream().max(Comparator.comparingDouble(Employee::getSalary)).get();
        System.out.println("maxSalary :"+maxSalary);
        
        Optional<Employee> minSalary = employees.stream().min(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("minSalary :"+minSalary);
        
       List<Employee> salDesc = employees.stream() .sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList());
       System.out.println("salary desc : "+salDesc);
       
       List<Employee> salDesc1 = employees.stream() .sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
       System.out.println("salary Asc : "+salDesc1);

      Map<String, Long> count= employees.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
      System.out.println(count);
      
      long count1= employees.stream().filter(e->e.getGender().equals("Male")).count();
      System.out.println("Count male employees :"+count1);
      
      List<String> count11= employees.stream().filter(e->e.getGender().equals("Male") && e.getAge() > 30).map(Employee::getName). collect(Collectors.toList());
      System.out.println("Print male employees age above 30 :"+count11);
      
      
	
	}

}
