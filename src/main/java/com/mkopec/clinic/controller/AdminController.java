package com.mkopec.clinic.controller;

import com.mkopec.clinic.domain.Admin;
import com.mkopec.clinic.domain.Employee;
import com.mkopec.clinic.dtos.EmployeePostDTO;
import com.mkopec.clinic.dtos.ShortEmployeeDTO;
import com.mkopec.clinic.mapper.AdminMapper;
import com.mkopec.clinic.mapper.EmployeeMapper;
import com.mkopec.clinic.service.AdminService;
import com.mkopec.clinic.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;
    private final AdminService adminService;
    private final AdminMapper adminMapper;

    @GetMapping("/{id}")
    public ShortEmployeeDTO getAdminByID(@PathVariable Long id) {
        return adminMapper.toShortEmployeeDTO(adminService.findByID(id));
    }

    @GetMapping
    public List<ShortEmployeeDTO> getAll() {
        return adminMapper.toShortEmployeeDTOs(adminService.getAll());
    }

    @PostMapping
    public EmployeePostDTO saveAdmin(@RequestBody EmployeePostDTO employeePostDTO) {
        Employee savedEmployee = employeeService.saveEmployee(employeeMapper.toEmployee(employeePostDTO));

        Admin admin = createAdminFromEmployee(savedEmployee);
        adminService.save(admin);

        return employeeMapper.toEmployeePostDTO(savedEmployee);
    }

    @DeleteMapping("/{id}")
    public void deleteAdmin(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    private Admin createAdminFromEmployee(Employee employee) {
        Admin admin = new Admin();
        admin.setId(employee.getId());
        admin.setFirstname(employee.getFirstname());
        admin.setSurname(employee.getSurname());
        admin.setEmployee(employee);
        return admin;
    }
}
