package without.jpa.SpringbootCrudWithoutJpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import without.jpa.SpringbootCrudWithoutJpa.entity.EmployeeEntity;
import without.jpa.SpringbootCrudWithoutJpa.service.EmployeeService;
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	 @Autowired
	    public EmployeeController(EmployeeService employeeService) {
	        this.employeeService = employeeService;
	    }
	    @Autowired
	    private EmployeeService yourEntityService;

	    @PostMapping("/add")
	    public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employee) {
	    	System.out.println("hii");
	        String responseMessage = "Employee inserted into the database ";
	        	
	        yourEntityService.saveEmployee(employee);
	     return employee;
	    }
	    
	    @GetMapping("/showall")
	    public List<EmployeeEntity> getAllEmployees() {
	    	 String responseMessage = "Your All Employee List";
	        return yourEntityService.getAllEmployees();
	    }
	  
	    @PutMapping("/put/{id}")
	    public EmployeeEntity updateEmployee(@PathVariable int id, @RequestBody EmployeeEntity employee) {
	        employee.setId(id);
	        yourEntityService.updateEmployee(employee);
	        String responseMessage = "Your Data Is Updated ";
			return employee;
	    }
	 

	    @DeleteMapping("/delete/{id}")
	    public EmployeeEntity deleteEmployee(@PathVariable int id,@RequestBody EmployeeEntity employee) {
	        yourEntityService.deleteEmployee(id);
	        String responseMessage = "Employee Is Deleted ";
			return employee;
	    }
}
