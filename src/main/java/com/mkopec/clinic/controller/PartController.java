package com.mkopec.clinic.controller;

import com.mkopec.clinic.domain.Part;
import com.mkopec.clinic.dtos.PartDTO;
import com.mkopec.clinic.dtos.PartPostDTO;
import com.mkopec.clinic.mapper.PartMapper;
import com.mkopec.clinic.service.PartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/part")
public class PartController {
    private final PartService partService;
    private final PartMapper partMapper;

    @GetMapping
    public List<PartDTO> getAllParts() {
        return partMapper.toPartDTOs(partService.getAll());
    }

    @GetMapping("/{id}")
    public PartDTO findByID(@PathVariable Long id) {
        return partMapper.toPartDTO(partService.findByID(id));
    }

    @PostMapping
    public PartPostDTO partPostDTO(@RequestBody PartPostDTO partPostDTO) {
        Part part = partMapper.toPart(partPostDTO);
        return partMapper.toPartPostDTO(partService.save(part));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        partService.delete(id);
    }
}
