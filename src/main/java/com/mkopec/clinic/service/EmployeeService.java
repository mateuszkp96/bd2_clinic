package com.mkopec.clinic.service;

import com.mkopec.clinic.domain.Employee;
import com.mkopec.clinic.exception.ResourceNotFoundException;
import com.mkopec.clinic.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repository;

    public Employee findByID(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
    }

    public List<Employee> getAll() {
        return repository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}
