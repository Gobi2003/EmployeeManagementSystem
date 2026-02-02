package project.com.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.com.ems.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
