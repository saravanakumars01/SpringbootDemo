package com.Springboot.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ServiceClass {
	
	  @Autowired 
	  EmployeeDAO employeeDAO;
	 
	public String getEmpName(int id)
	{
	System.out.println("Heloo in service class"+id);
	//EmployeeDAO dao=new EmployeeDAO();
	//dao.saveUser();
	return employeeDAO.getEmpName(id);//employeeDAO.getEmpName(id);	
	}
	public boolean saveEmployee(Employee employee)
	{
		employeeDAO.saveUser(employee);
		return true;
	}
	public void deleteEmployee(int id)
	{
		employeeDAO.deleteEmployee(id);
	}
	public void updateEmployee(int empId,String empName)
	{
		employeeDAO.updateEmployee(empId, empName);
	}
	}
