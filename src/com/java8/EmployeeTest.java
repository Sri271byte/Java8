package com.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeTest {

	public static void main(String[] args) {
		
		List<Employee> employees = Arrays.asList(
	            new Employee(101, "Alice", 28, "IT", 70000),
	            new Employee(102, "Bob", 35, "HR", 40000),
	            new Employee(103, "Ram", 40, "Finance", 80000),
	            new Employee(104, "Ram", 30, "IT", 60000),
	            new Employee(105, "Eva", 25, "Marketing", 58000),
	            new Employee(106, "Frank", 45, "HR", 55000),
	            new Employee(107, "Grace", 32, "Finance", 45000),
	            new Employee(108, "Raj", 29, "Marketing", 47000)
	        );      

List<Employee> itEmployees = employees.stream().filter(emp -> emp.getDepartment().equals("IT")).collect(Collectors.toList());
System.out.println("IT employees data only----------------------------: "+itEmployees);
          
List<String> names = employees.stream().filter(emp -> emp.getAge() > 30).map(Employee::getName).collect(Collectors.toList());
         System.out.println("names above age of 30----------------------------: "+names);
         
Map<String, List<Employee>> deptMap = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
         System.out.println("Group employees by department----------------------------: "+deptMap);
         
List<Employee> sorted = employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).collect(Collectors.toList());      
         System.out.println("Print employees by salary in descending order----------------------------: "+sorted);
         

Map<String, Long> deptCount = employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
         System.out.println("Count number of employees in each department----------------------------: "+deptCount);
 
Map<String, Double> avgSalary = employees.stream() .collect(Collectors.groupingBy(Employee::getDepartment,Collectors
		                                           .averagingDouble(Employee::getSalary)));
         System.out.println("Find average salary of each department----------------------------: "+avgSalary);
      
 boolean hasHR = employees.stream().anyMatch(emp -> "HR".equals(emp.getDepartment()));
         System.out.println("employee is from \"HR\" department----------------------------: "+hasHR);
         
Double secondHighestSalary = employees.stream().map(Employee::getSalary).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();                     
          System.out.println("Second highest salary is---------------------------: " + secondHighestSalary);
          
          double totalSalary = employees.stream().collect(Collectors.summingDouble(Employee::getSalary));
          System.out.println("totalSalary------------------ : "+totalSalary);

        
          List<Employee> names1 = employees.stream().filter(e -> (e.getSalary() < 50_000 || e.getSalary() > 75_000) && e.getName()
        		  .startsWith("R")).collect(Collectors.toList());
                   System.out.println(names1);    
                   
                   
          List<Employee> sv = employees.stream().filter(e -> (e.getAge() > 40 || e.getSalary() >=50000)&& e.getDepartment().equals("HR"))
        		             .collect(Collectors.toList());
          System.out.println(sv);
          
          List<String> st=  (List<String>) employees.stream().filter(e -> e.getDepartment().equals("HR")|| e.getDepartment().equals("IT")).map(Employee::getName).collect(Collectors.toList());
          System.out.println("Print all HR and IT Employee Names ----------- : " +st);
          
       // Group by name and get second highest salary
          Map<String, Double> result = employees.stream()
                  .collect(Collectors.groupingBy(         // 1. Group employees by their name
                          Employee::getName,
                          Collectors.collectingAndThen(    // 2. After grouping, do some extra processing
                                  Collectors.mapping(      // 3. From each Employee, take only the salary
                                          Employee::getSalary,
                                          Collectors.toList() // -> collect all salaries into a List
                                  ),
                                  list -> list.stream()    // 4. Work on the list of salaries for each name
                                          .sorted(Comparator.reverseOrder()) // sort in descending order
                                          .skip(1)         // 5. Skip the first element (highest salary)
                                          .findFirst()     // 6. Take the next one (second highest salary)
                                          .orElse(null)    // 7. If no second salary exists, return null
                          )
                  ));

          // Print result
          result.forEach((name, salary) ->  {// Iterate through the map
          if (salary != null) {   // print only if 2nd highest exists

                  System.out.println(name + " -> " + salary); // Print name and its second highest salary
                  
          }
          });
      
	    } 

    }
















































