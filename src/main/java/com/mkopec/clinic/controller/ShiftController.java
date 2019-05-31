package com.mkopec.clinic.controller;

import com.mkopec.clinic.domain.Doctor;
import com.mkopec.clinic.domain.Shift;
import com.mkopec.clinic.dtos.ShiftDTO;
import com.mkopec.clinic.mapper.ShiftMapper;
import com.mkopec.clinic.repository.ShiftRepository;
import com.mkopec.clinic.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shift")
public class ShiftController {
    private final DoctorService doctorService;
    private final ShiftRepository shiftRepository;
    private final ShiftMapper shiftMapper;

    @GetMapping("/{id}")
    public List<ShiftDTO> getDoctorShifts(@PathVariable Long id) {
        Doctor doctor = doctorService.findByID(id);

        List<Shift> shifts = shiftRepository.findByDoctor(doctor);

        return shiftMapper.toShiftDTOs(shifts);
    }
}
