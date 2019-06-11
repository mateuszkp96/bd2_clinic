package com.mkopec.clinic.mapper;

import com.mkopec.clinic.domain.Referral;
import com.mkopec.clinic.dtos.ReferralDTO;
import com.mkopec.clinic.dtos.ReferralPostDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ReferralMapper {

    @Autowired
    protected ScopeOfExaminationMapper scopeMapper;

    @Mappings({
            @Mapping(target = "scope", expression = "java(scopeMapper.toScopeOfExaminationDTO(referral.getScope()))"),
            @Mapping(target = "appointmentID", source = "appointment.id")
    })
    public abstract ReferralPostDTO toReferralPostDTO(Referral referral);

    @Mappings({
            @Mapping(target = "appointment.id", source = "appointmentID"),
            @Mapping(target = "scope", expression = "java(scopeMapper.toScopeOfExamination(postDTO.getScope()))"),
            @Mapping(target = "name", expression = "java(postDTO.getScope().getName())")
    })
    public abstract Referral toReferral(ReferralPostDTO postDTO);

    public abstract ReferralDTO toReferralDTO(Referral referral);

    public abstract List<ReferralDTO> toReferralDTOs(List<Referral> referral);
}
