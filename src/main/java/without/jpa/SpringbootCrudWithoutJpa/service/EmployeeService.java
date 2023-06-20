package without.jpa.SpringbootCrudWithoutJpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import without.jpa.SpringbootCrudWithoutJpa.dao.YourEntityDAO;
import without.jpa.SpringbootCrudWithoutJpa.entity.EmployeeEntity;
@Service
public class EmployeeService {
	@Autowired
	private YourEntityDAO yourEntityDAO;
	public void saveEmployee(EmployeeEntity employee) {
		yourEntityDAO.saveEmployee(employee);
	}
   public EmployeeService(YourEntityDAO employeeRepository) {
	        this.yourEntityDAO = employeeRepository;
	    }
	public List<EmployeeEntity> getAllEmployees() {
		return yourEntityDAO.getAllEmployees();
	}
	public void updateEmployee(EmployeeEntity employee) {
		yourEntityDAO.updateEmployee(employee);
	}
	public void deleteEmployee(int id) {
		yourEntityDAO.deleteEmployee(id);
	}
}
