package com.tricon.demoSpring.Controller;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.tricon.demoSpring.Model.Employee;

@RestController
public class EmployeeController {
	
	@RequestMapping(value="/emp/{Id}",method=RequestMethod.GET)
	public Employee getEmployees(@PathVariable (name = "Id") int Id){
		
		List<Employee> emplist = new ArrayList<Employee>();
		
		Employee sai = new Employee();
		sai.setId(1);
		sai.setName("sai");
		sai.setPosition("Dev");
		
		Employee chai = new Employee();
		chai.setId(2);
		chai.setName("chai");
		chai.setPosition("Dev");
		
		emplist.add(sai);
		emplist.add(chai);
		
		
		return emplist.get(Id);
	}
		
		
	/*
	 * @RequestMapping(value="/empservice",method=RequestMethod.GET) public
	 * List<Employee> getEmployeeServices(){
	 * 
	 * List<Employee> empservicelist = new ArrayList<Employee>();
	 * 
	 * Employee sai = new Employee(); sai.setId(1); sai.setName("sai");
	 * sai.setPosition("Dev");
	 * 
	 * Employee chai = new Employee(); chai.setId(1); chai.setName("chai");
	 * chai.setPosition("Dev");
	 * 
	 * empservicelist.add(sai); empservicelist.add(chai);
	 * 
	 * 
	 * return empservicelist;
	 * 
	 * 
	 * }
	 */
}
