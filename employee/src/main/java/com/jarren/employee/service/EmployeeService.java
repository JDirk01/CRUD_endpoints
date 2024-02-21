package com.jarren.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jarren.employee.model.Employee;
import com.jarren.employee.repository.EmployeeRepository;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
        EmployeeRepository empRepository;

    //CREATE
    public Employee createEmployee(Employee emp) {
        return empRepository.save(emp);
    }

    //READ
    public List<Employee> getEmployees() {
        return empRepository.findAll();
    }

    //UPDATE
    public Employee updateEmployee(Long empId, Employee employeeDetails) {
        Employee emp = empRepository.findById(empId).get();
        emp.setFirstName(employeeDetails.getFirstName());
        emp.setLastName(employeeDetails.getLastName());
        emp.setEmailId(employeeDetails.getEmailId());

        return empRepository.save(emp);
    }

    //DELETE
    public void deleteEmployee(Long empId) {
        empRepository.deleteById(empId);
    }


}
