package com.user.dao;

import java.util.List;

import com.user.model.Employee;

/**
 * @author Basanta
 *
 */
public interface EmployeeDao {
	
	public void addEmployee(Employee employee);

	public List<Employee> listEmployeess();
	
	public Employee getEmployee(int empid);
	
	public void deleteEmployee(Employee employee);
}
