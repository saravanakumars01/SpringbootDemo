package com.Springboot.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {
	//@Autowired
	private SessionFactory factory=null;

	public void saveUser(Employee employee)
	{
		factory=new Configuration().configure().buildSessionFactory();
		Session session=factory.openSession();
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
	}
	public String getEmpName(int id)
	 {
		 Session session=null;
		 Employee emp = null;
		 try {
			 factory=new Configuration().configure().buildSessionFactory();
			 session=factory.openSession();
			 session.beginTransaction();
			 emp=(Employee)session.get(Employee.class, id);
			session.close();  
			System.out.println("in DAO");
		 }
		 
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
		 return emp.getEmpName();
	 }
	public void deleteEmployee(int empid)
	{
		 Session session=null;
		 try {
			 factory=new Configuration().configure().buildSessionFactory();
			 session=factory.openSession();
			 session.beginTransaction();
			Employee emp=session.get(Employee.class, empid);
			System.out.println(emp.getEmpName());
			session.delete(emp);
			session.getTransaction().commit();
			session.close();  
			System.out.println("in DAO");
		 }
		 
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	}
	public void updateEmployee(int empId,String empName)
	{
		Session session=null;
		 try {
			 factory=new Configuration().configure().buildSessionFactory();
			 session=factory.openSession();
			 session.beginTransaction();
			Employee emp=session.get(Employee.class, empId);
			System.out.println(emp.getEmpName());
			System.out.println(empName);
			emp.setEmpName(empName);
			session.update(emp);
			session.getTransaction().commit();
			session.close();  
			
		 }
		 
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
	}
}
