package com.mkopec.clinic.controller;

import com.mkopec.clinic.domain.Doctor;
import com.mkopec.clinic.domain.Shift;
import com.mkopec.clinic.domain.Surgery;
import com.mkopec.clinic.dtos.ShiftDTO;
import com.mkopec.clinic.dtos.ShiftPostDTO;
import com.mkopec.clinic.mapper.ShiftMapper;
import com.mkopec.clinic.service.DoctorService;
import com.mkopec.clinic.service.ShiftService;
import com.mkopec.clinic.service.SurgeryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shift")
public class ShiftController {
    private final ShiftService shiftService;
    private final ShiftMapper shiftMapper;

    private final DoctorService doctorService;
    private final SurgeryService surgeryService;

    @GetMapping("/{id}")
    public List<ShiftDTO> getDoctorShifts(@PathVariable Long id) {
        Doctor doctor = doctorService.findByID(id);
        List<Shift> shifts = shiftService.findDoctorShifts(doctor);
        return shiftMapper.toShiftDTOs(shifts);
    }

    @GetMapping("/{id}/{day}")
    public List<ShiftDTO> getDoctorShiftsInDay(@PathVariable Long id, @PathVariable Integer day) {
        Doctor doctor = doctorService.findByID(id);
        List<Shift> shifts = shiftService.findByDoctorAndDayOfWeek(doctor, day);
        return shiftMapper.toShiftDTOs(shifts);
    }

    @PostMapping("/{doctorID}")
    public ShiftPostDTO saveDoctorShift(@RequestBody ShiftPostDTO shiftPostDTO, @PathVariable Long doctorID) {
        Surgery surgery = surgeryService.findByID(shiftPostDTO.getSurgeryID());
        Doctor doctor = doctorService.findByID(doctorID);

        if (Objects.nonNull(surgery) && Objects.nonNull(doctor)) {
            Shift shift = shiftMapper.toShift(shiftPostDTO);
            shift.setDoctor(doctor);
            shift.setSurgery(surgery);

            return shiftMapper.toShiftPostDTO(shiftService.save(shift));
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteShift(@PathVariable Long id) {
        shiftService.delete(id);
    }
}
