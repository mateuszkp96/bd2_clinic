package com.mkopec.clinic.controller;

import com.mkopec.clinic.domain.Surgery;
import com.mkopec.clinic.dtos.SurgeryDTO;
import com.mkopec.clinic.dtos.SurgeryPostDTO;
import com.mkopec.clinic.mapper.SurgeryMapper;
import com.mkopec.clinic.service.ClinicService;
import com.mkopec.clinic.service.SurgeryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/surgery")
public class SurgeryController {
    private final SurgeryService surgeryService;
    private final SurgeryMapper surgeryMapper;
    private final ClinicService clinicService;

    @GetMapping("/{id}")
    public SurgeryDTO getSurgeryByID(@PathVariable Long id) {
        return surgeryMapper.toSurgeryDTO(surgeryService.findByID(id));
    }

    @GetMapping
    public List<SurgeryDTO> getAllSurgeries() {
        return surgeryMapper.toSurgeryDTOs(surgeryService.getAll());
    }

    @PostMapping
    public SurgeryPostDTO saveSurgery(@RequestBody SurgeryPostDTO surgeryPostDTO) {
        Surgery surgery = surgeryMapper.toSurgery(surgeryPostDTO);
        surgery.setClinic(clinicService.findByID(surgeryPostDTO.getClinicID()));

        return surgeryMapper.toSurgeryPostDTO(surgeryService.save(surgery));
    }

    @DeleteMapping("/{id}")
    public void deleteSurgery(@PathVariable Long id) {
        surgeryService.deleteByID(id);
    }
}
