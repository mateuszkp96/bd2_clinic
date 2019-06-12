package com.mkopec.clinic.controller;

import com.mkopec.clinic.domain.*;
import com.mkopec.clinic.dtos.FullShiftPostDTO;
import com.mkopec.clinic.dtos.ShiftDTO;
import com.mkopec.clinic.dtos.ShiftPartDTO;
import com.mkopec.clinic.dtos.ShiftPostDTO;
import com.mkopec.clinic.mapper.ShiftMapper;
import com.mkopec.clinic.mapper.ShiftPartMapper;
import com.mkopec.clinic.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.ArrayList;
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

    private final PartService partService;
    private final ShiftPartService shiftPartService;
    private final ShiftPartMapper shiftPartMapper;

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

    @PostMapping("/shiftWithPart")
    public FullShiftPostDTO saveDoctorShiftWithParts(@RequestBody FullShiftPostDTO postDTO) {
        LocalTime startTime = LocalTime.parse(postDTO.getStartTime());
        LocalTime endTime = LocalTime.parse(postDTO.getEndTime());
        String quant = "00:15:00";
        List<Part> parts = partService.findAllByStartAndEndAndQuant(startTime, endTime, "00:15:00");

        Shift savedShift = shiftService.save(shiftMapper.toShift(postDTO));

        List<ShiftPart> savedShiftParts = shiftPartService.saveAll(createShiftPartsFromShift(savedShift, parts));

        FullShiftPostDTO result = shiftMapper.toFullShiftPostDTO(savedShift);
        result.setStartTime(postDTO.getStartTime());
        result.setEndTime(postDTO.getEndTime());

        return result;
    }

    private List<ShiftPart> createShiftPartsFromShift(Shift shift, List<Part> parts) {
        List<ShiftPart> result = new ArrayList<>();
        for (Part p : parts) {
            ShiftPart shiftPart = new ShiftPart();
            shiftPart.setShift(shift);
            shiftPart.setPartID(p.getId());
            shiftPart.setStartTime(p.getStartTime());
            shiftPart.setEndTime(p.getEndTime());
            result.add(shiftPart);
        }
        return result;
    }

    @DeleteMapping("/{id}")
    public void deleteShift(@PathVariable Long id) {
        shiftService.delete(id);
    }

    @GetMapping("/shiftParts/{shiftID}")
    public List<ShiftPartDTO> getShiftPartsByShift(@PathVariable Long shiftID) {
        return shiftPartMapper.toShiftPartDTOs(shiftPartService.findAllByShiftID(shiftID));
    }
}
