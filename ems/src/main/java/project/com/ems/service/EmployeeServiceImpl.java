package project.com.ems.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import project.com.ems.dto.EmployeeDto;
import project.com.ems.entity.Employee;
import project.com.ems.exception.ResourceNotFoundException;
import project.com.ems.mapper.EmployeeMapper;
import project.com.ems.repository.EmployeeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        Employee createEmployee=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(createEmployee);
    }
    @Override
    public EmployeeDto getEmployeeById(Long employeeId)
    {
        Employee employee =employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee is not found with the given Id:"+employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees=employeeRepository.findAll();
        return employees.stream().map((employee)-> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updateEmployee) {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee is not exist with given Id"+ employeeId));

        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setEmail(updateEmployee.getEmail());
        Employee updatedEmployee=employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(()-> new ResourceNotFoundException("Employee is not exist with given Id"+ employeeId));

        employeeRepository.deleteById(employeeId);
    }

}
