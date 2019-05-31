package com.mkopec.clinic.controller;

import com.mkopec.clinic.domain.Employee;
import com.mkopec.clinic.domain.Receptionist;
import com.mkopec.clinic.dtos.EmployeePostDTO;
import com.mkopec.clinic.dtos.ShortEmployeeDTO;
import com.mkopec.clinic.mapper.EmployeeMapper;
import com.mkopec.clinic.mapper.ReceptionistMapper;
import com.mkopec.clinic.service.EmployeeService;
import com.mkopec.clinic.service.ReceptionistService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/receptionist")
public class ReceptionistController {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;
    private final ReceptionistService receptionistService;
    private final ReceptionistMapper receptionistMapper;

    @GetMapping("/{id}")
    public ShortEmployeeDTO getReceptionistByID(@PathVariable Long id) {
        return receptionistMapper.toShortEmployeeDTO(receptionistService.findByID(id));
    }

    @GetMapping
    public List<ShortEmployeeDTO> getAll() {
        return receptionistMapper.toShortEmployeeDTOs(receptionistService.getAll());
    }

    @PostMapping
    public EmployeePostDTO saveReceptionist(@RequestBody EmployeePostDTO employeePostDTO) {
        Employee savedEmployee = employeeService.saveEmployee(employeeMapper.toEmployee(employeePostDTO));

        Receptionist receptionist = createReceptionistFromEmployee(savedEmployee);
        receptionistService.save(receptionist);

        return employeeMapper.toEmployeePostDTO(savedEmployee);
    }

    @DeleteMapping("/{id}")
    public void deleteReceptionist(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    private Receptionist createReceptionistFromEmployee(Employee employee) {
        Receptionist receptionist = new Receptionist();
        receptionist.setId(employee.getId());
        receptionist.setFirstname(employee.getFirstname());
        receptionist.setSurname(employee.getSurname());
        receptionist.setEmployee(employee);
        return receptionist;
    }
}
