package com.mkopec.clinic.controller;

import com.mkopec.clinic.domain.Doctor;
import com.mkopec.clinic.domain.DoctorSpecialization;
import com.mkopec.clinic.domain.Employee;
import com.mkopec.clinic.domain.Specialization;
import com.mkopec.clinic.dtos.DoctorDTO;
import com.mkopec.clinic.dtos.DoctorPostDTO;
import com.mkopec.clinic.dtos.DoctorPostSpecializationDTO;
import com.mkopec.clinic.mapper.DoctorMapper;
import com.mkopec.clinic.mapper.EmployeeMapper;
import com.mkopec.clinic.service.DoctorService;
import com.mkopec.clinic.service.DoctorSpecializationService;
import com.mkopec.clinic.service.EmployeeService;
import com.mkopec.clinic.service.SpecializationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorService doctorService;
    private final DoctorMapper doctorMapper;

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    private final DoctorSpecializationService doctorSpecializationService;
    private final SpecializationService specializationService;

    @GetMapping
    public List<DoctorDTO> getAllDoctors() {
        return doctorMapper.toDoctorDTOs(doctorService.getAllDoctors());
    }

    @PostMapping
    public DoctorPostDTO saveDoctor(@RequestBody DoctorPostDTO doctorPostDTO) {
        Employee employee = employeeMapper.toEmployee(doctorPostDTO);
        Employee savedEmployee = employeeService.saveEmployee(employee);

        Doctor doctor = createDoctorFromEmployee(savedEmployee);
        Doctor savedDoctor = doctorService.saveDoctor(doctor);

        List<DoctorSpecialization> doctorSpecializations = createDoctorSpecialization(doctorPostDTO.getSpecializations(), savedDoctor);

        List<DoctorSpecialization> savedDoctorSpecializations = doctorSpecializationService.saveAll(doctorSpecializations);
        savedDoctor.setSpecializations(savedDoctorSpecializations);

        return doctorMapper.toDoctorDTOs(savedDoctor);
    }

    private Doctor createDoctorFromEmployee(Employee employee) {
        Doctor doctor = new Doctor();
        doctor.setId(employee.getId());
        doctor.setFirstname(employee.getFirstname());
        doctor.setSurname(employee.getSurname());
        doctor.setEmployee(employee);
        return doctor;
    }

    private List<DoctorSpecialization> createDoctorSpecialization(List<Long> specializationIDs, Doctor doctor) {
        List<DoctorSpecialization> doctorSpecializationList = new ArrayList<>();

        List<Specialization> specializations = specializationService.findAllByID(specializationIDs);
        for (Specialization sp : specializations) {
            DoctorSpecialization doctorSpecialization = new DoctorSpecialization();
            doctorSpecialization.setDoctor(doctor);
            doctorSpecialization.setSpecializationName(sp.getName());
            doctorSpecialization.setSpecializationID(sp.getId());
            doctorSpecializationList.add(doctorSpecialization);
        }

        return doctorSpecializationList;
    }

    @PostMapping("/{id}")
    public DoctorPostSpecializationDTO addSpecializationToDoctor(@RequestBody DoctorPostSpecializationDTO dto) {
        Doctor doctor = doctorService.findByID(dto.getDoctorID());

        List<Long> specializationsToCreate = getSpecializationsToCreate(dto.getSpecializations(), doctor);

        List<DoctorSpecialization> doctorSpecializations = createDoctorSpecialization(specializationsToCreate, doctor);
        List<DoctorSpecialization> savedDoctorSpecializations = doctorSpecializationService.saveAll(doctorSpecializations);
        doctor.getSpecializations().addAll(savedDoctorSpecializations);

        return doctorMapper.toDoctorPostSpecializationDTO(doctor);
    }

    private List<Long> getSpecializationsToCreate(List<Long> specializations, Doctor doctor) {
        List<Long> result = new ArrayList<>();
        for (Long id : specializations) {
            DoctorSpecialization doctorSpecialization = doctorSpecializationService.findByDoctorAndSpecializationID(doctor, id);
            if (Objects.isNull(doctorSpecialization)) {
                result.add(id);
            }
        }
        return result;
    }
}

