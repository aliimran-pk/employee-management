package com.ibm.employeemanagment.controllers;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Random;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.employeemanagment.model.Employee;

@RestController
public class EmployeeController {

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public Employee firstPage() {

		Employee emp = new Employee();
		
		Random random = new Random();
		emp.setName("Ali Imran");
        emp.setDesignation("Sr. Consulatnt@IBM");
		emp.setEmpId("emp-"+ random.nextInt(1000));
		emp.setSalary(13000);
		emp.setDob(new Date());
		
		InetAddress addr;
		try {
			addr = InetAddress.getLocalHost();
			emp.setHostName(addr.getHostName() + ":" + System.getenv("HOSTNAME"));
			emp.setIpAddress(addr.getHostAddress());			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				System.out.println(emp);
				return emp;
	}

}
