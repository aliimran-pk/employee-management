package com.ibm.employeemanagment.controllers;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.employeemanagment.model.Employee;

@RestController
public class EmployeeController {

	@Value("${application.version}")
	private String appVersion;
	
	@Value("${application.database.username}")
	private String dbUserName;
	
	@Value("${application.database.password}")
	private String dbUserPassword;
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public Employee getEmployee() {

		Employee emp = new Employee();
		
		Random random = new Random();
		emp.setName("Ali Imran");
        emp.setDesignation("Sr. Consulatnt@IBM");
		emp.setEmpId(dbUserName+ "-"+dbUserPassword + "-"+ random.nextInt(1000));
		emp.setSalary(13000);
		emp.setDob(new Date());
		
		InetAddress addr;
		try {
			addr = InetAddress.getLocalHost();
			emp.setHostName(addr.getHostName() + ":" + System.getenv("HOSTNAME"));
			emp.setIpAddress(addr.getHostAddress());	
			emp.setAppVersion(this.appVersion);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				System.out.println(emp);
				return emp;
	}

}
