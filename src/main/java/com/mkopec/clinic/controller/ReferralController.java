package com.mkopec.clinic.controller;

import com.mkopec.clinic.domain.Appointment;
import com.mkopec.clinic.domain.Referral;
import com.mkopec.clinic.dtos.ReferralDTO;
import com.mkopec.clinic.dtos.ReferralPostDTO;
import com.mkopec.clinic.mapper.ReferralMapper;
import com.mkopec.clinic.service.AppointmentService;
import com.mkopec.clinic.service.ReferralService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/referral")
public class ReferralController {
    private final ReferralService service;
    private final ReferralMapper mapper;

    private final AppointmentService appointmentService;

    @GetMapping("/{id}")
    public List<ReferralDTO> findByAppointmentID(@PathVariable Long id) {
        Appointment appointment = appointmentService.findByID(id);
        return mapper.toReferralDTOs(service.findByAppointment(appointment));
    }

    @PostMapping
    public ReferralPostDTO saveReferral(@RequestBody ReferralPostDTO postDTO) {
        Referral referral = mapper.toReferral(postDTO);
        return mapper.toReferralPostDTO(service.save(referral));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
