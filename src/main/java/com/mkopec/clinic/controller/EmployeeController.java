package com.mkopec.clinic.controller;

import com.mkopec.clinic.dtos.EmployeeDTO;
import com.mkopec.clinic.mapper.EmployeeMapper;
import com.mkopec.clinic.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    @GetMapping
    public List<EmployeeDTO> getAllEmployees() {
        return employeeMapper.toEmployeeDTOs(employeeService.getAll());
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long id) {
        return employeeMapper.toEmployeeDTO(employeeService.findByID(id));
    }
}
