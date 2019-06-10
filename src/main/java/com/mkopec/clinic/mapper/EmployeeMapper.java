package com.mkopec.clinic.mapper;

import com.mkopec.clinic.domain.Employee;
import com.mkopec.clinic.dtos.DoctorPostDTO;
import com.mkopec.clinic.dtos.EmployeeDTO;
import com.mkopec.clinic.dtos.EmployeePostDTO;
import com.mkopec.clinic.dtos.ShortEmployeeDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class EmployeeMapper {

    public abstract EmployeeDTO toEmployeeDTO(Employee employee);

    public abstract List<EmployeeDTO> toEmployeeDTOs(List<Employee> employees);

    public abstract Employee toEmployee(EmployeePostDTO employeePostDTO);

    public abstract EmployeePostDTO toEmployeePostDTO(Employee employee);

    public abstract ShortEmployeeDTO toShortEmployeeDTO(Employee employee);

    public abstract Employee toEmployee(DoctorPostDTO doctorPostDTO);
}