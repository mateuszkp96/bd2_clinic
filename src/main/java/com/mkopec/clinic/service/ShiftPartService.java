package com.mkopec.clinic.service;

import com.mkopec.clinic.domain.ShiftPart;
import com.mkopec.clinic.exception.ResourceNotFoundException;
import com.mkopec.clinic.repository.ShiftPartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShiftPartService {
    private final ShiftPartRepository repository;

    public List<ShiftPart> findAllByShiftID(Long shiftID) {
        return repository.findAllByShiftID(shiftID);
    }

    public ShiftPart findByID(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ShiftPart", "id", id));
    }

    public List<ShiftPart> findAllByIDs(List<Long> shifts) {
        return repository.findAllById(shifts);
    }

    public List<ShiftPart> saveAll(List<ShiftPart> shiftParts) {
        return repository.saveAll(shiftParts);
    }
}
