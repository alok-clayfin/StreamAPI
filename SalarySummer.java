package com.cfstreams;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SalarySummer {
	public static void main(String[] args) {
		Supplier<EmployeeRepository> empRepo=EmployeeRepository::new;
		List<Employee> elist=empRepo.get().getEmployees();
		
		//Create a stream to hold the Stream of List of Employees
		Stream<Employee> empStream=elist.stream();
		
		//Create a Map of Employee Salary and add the salaries
		Optional<Double> result=empStream.map(Employee::getSalary).reduce((a,b)->a+b);
		
		//Print the result
		System.out.println("The sum of Salary is :"+result.get());
	}

}
