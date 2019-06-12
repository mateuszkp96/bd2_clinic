package com.mkopec.clinic.mapper;

import com.mkopec.clinic.domain.Employee;
import com.mkopec.clinic.dtos.DoctorPostDTO;
import com.mkopec.clinic.dtos.EmployeeDTO;
import com.mkopec.clinic.dtos.EmployeePostDTO;
import com.mkopec.clinic.dtos.ShortEmployeeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class EmployeeMapper {

    @Mapping(target = "role", expression = "java(getDTOType(employee))")
    public abstract EmployeeDTO toEmployeeDTO(Employee employee);

    public abstract List<EmployeeDTO> toEmployeeDTOs(List<Employee> employees);

    @Mapping(target = "role", expression = "java(getDomainType(postDTO))")
    public abstract Employee toEmployee(EmployeePostDTO postDTO);

    @Mapping(target = "role", expression = "java(getDTOType(employee))")
    public abstract EmployeePostDTO toEmployeePostDTO(Employee employee);

    public abstract ShortEmployeeDTO toShortEmployeeDTO(Employee employee);

    public abstract Employee toEmployeeFromDoctor(DoctorPostDTO doctorPostDTO);

    protected String getDTOType(Employee employee) {
        switch (employee.getRole()) {
            case "admin":
                return "administrator";
            case "recep":
                return "recepcjonista";
            case "lek":
                return "lekarz";
        }
        return null;
    }

    protected String getDomainType(EmployeePostDTO employee) {
        switch (employee.getRole()) {
            case "administrator":
                return "admin";
            case "recepcjonista":
                return "recep";
            case "lekarz":
                return "lek";
        }
        return null;
    }

}