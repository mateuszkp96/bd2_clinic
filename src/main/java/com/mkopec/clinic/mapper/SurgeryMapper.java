package com.mkopec.clinic.mapper;

import com.mkopec.clinic.domain.Surgery;
import com.mkopec.clinic.dtos.SurgeryDTO;
import com.mkopec.clinic.dtos.SurgeryPostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class SurgeryMapper {

    @Mapping(target = "clinicID", source = "surgery.clinic.id")
    public abstract SurgeryDTO toSurgeryDTO(Surgery surgery);

    public abstract List<SurgeryDTO> toSurgeryDTOs(List<Surgery> surgeries);

    @Mapping(target = "clinicID", source = "surgery.clinic.id")
    public abstract SurgeryPostDTO toSurgeryPostDTO(Surgery surgery);

    public abstract Surgery toSurgery(SurgeryPostDTO surgeryPostDTO);
}
