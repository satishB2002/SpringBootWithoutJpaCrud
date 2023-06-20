package without.jpa.SpringbootCrudWithoutJpa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import without.jpa.SpringbootCrudWithoutJpa.entity.EmployeeEntity;
@Repository
@Service
public class YourEntityDAO {
	 private final JdbcTemplate jdbcTemplate;
	 @Autowired
	    public YourEntityDAO(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }
	    public void saveEmployee(EmployeeEntity employee) {
	        String sql = "INSERT INTO employee (id, name, sal) VALUES (?, ?, ?)";
	        System.out.println("Your Data is inserted");
	       
	        jdbcTemplate.update(sql, employee.getId(), employee.getName(), employee.getSal());
	        
	    }
	   public List<EmployeeEntity> getAllEmployees() {
	        String sql = "SELECT * FROM employee";
	        return jdbcTemplate.query(sql, (rs, rowNum) -> {
	        	EmployeeEntity employee = new EmployeeEntity(rowNum, sql, rowNum);
	            employee.setId(rs.getInt(1));
	            employee.setName(rs.getString(2));
	            employee.setSal(rs.getDouble(3));
	            return employee;
	        });
	    }
	  
	    public void updateEmployee(EmployeeEntity employee) {
	        String sql = "UPDATE employee SET name = ?, sal = ? WHERE id = ?";
	        jdbcTemplate.update(sql, employee.getName(), employee.getSal(), employee.getId());
	    }

	    public void deleteEmployee(int id) {
	        String sql = "DELETE FROM employee WHERE id = ?";
	        jdbcTemplate.update(sql, id);
	    }
	    
}
