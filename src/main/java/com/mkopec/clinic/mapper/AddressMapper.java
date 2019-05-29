package com.mkopec.clinic.mapper;

import com.mkopec.clinic.domain.Address;
import com.mkopec.clinic.dtos.AddressDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class AddressMapper {

    public abstract AddressDTO toAddressDTO(Address address);
}
