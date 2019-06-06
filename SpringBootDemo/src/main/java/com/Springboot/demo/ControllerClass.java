package com.Springboot.demo;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
//import javax.ws.rs.core.Context;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin
@RequestMapping("/sp")
public class ControllerClass {
	
	  
	  @Autowired 
	  ServiceClass serviceClass ;
	 

	
	// @GetMapping(value="/getemployee")
	@RequestMapping("/get")
	public String get(@RequestParam(value = "empId") int id) {
		System.out.println(id);
		return serviceClass.getEmpName(id);
	}
	
	
	  @PostMapping(value="/save", consumes = {MediaType.APPLICATION_JSON_VALUE,
	  MediaType.APPLICATION_XML_VALUE}) 
	  //public boolean saveEmployee( @RequestBody Employee employee, @RequestHeader Map<String, String> headersMap, @Context HttpHeaders httpHeaders,  HttpServletRequest request ) {
	  //public boolean saveEmployee( @RequestBody Employee employee, @RequestHeader Map<String, String> headersMap, @Context HttpHeaders httpHeaders) {
	  //public boolean saveEmployee( @RequestBody Employee employee, @RequestHeader Map<String, String> headersMap,  HttpHeaders httpHeaders) {
	  //working-->
	  //public boolean saveEmployee( @RequestBody Employee employee, @RequestHeader Map<String, String> headersMap,  HttpServletRequest request) {
	  public boolean saveEmployee( @RequestBody Employee employee, @RequestHeader HttpHeaders httpHeaders,  HttpServletRequest request) {
		  try 
		  {
			System.out.println(employee.getEmpID());
			serviceClass.saveEmployee(employee);
			
//			System.out.println("headersMap==>");
//			System.out.println(headersMap);
			
			System.out.println("request.getHeader(referer)==>");
			System.out.println(request.getHeader("referer"));
			
			System.out.println("request.getRemoteAddr()==>");
			System.out.println(request.getRemoteAddr());
			
			System.out.println("request.getRemoteHost()==>");
			System.out.println(request.getRemoteHost());
			
			System.out.println("request.getRemotePort()==>");
			System.out.println(request.getRemotePort());
			
			System.out.println("request.getRemoteUser()==>");
			System.out.println(request.getRemoteUser());
			
			  System.out.println("httpHeaders.getOrigin()==>");
			  System.out.println(httpHeaders.getOrigin());
			 
		  }
		  
		  catch(Exception e) {e.printStackTrace();}
	  return true; 
	  }
	  @DeleteMapping(path="/delete")
	 public void deleteEmployee(@RequestParam(value = "empId") String empId)
	 {
		  serviceClass.deleteEmployee(Integer.parseInt(empId));
	 }
	  @PutMapping(path="/update")
		 public void updateEmployee(@RequestParam(value = "empId") String empId,@RequestParam(value = "empName") String empName)
		 {
			  serviceClass.updateEmployee(Integer.parseInt(empId),empName);
		 }
}
