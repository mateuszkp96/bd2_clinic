package com.mkopec.clinic.service;

import com.mkopec.clinic.domain.Address;
import com.mkopec.clinic.exception.ResourceNotFoundException;
import com.mkopec.clinic.repository.AddressRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

@Service
public class AddressService {

    private final AddressRepository repository;

    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    public Address getAddress(Address address) {
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("id")
                .withMatcher("postCode", ignoreCase())
                .withMatcher("city", ignoreCase())
                .withMatcher("street", ignoreCase())
                .withMatcher("houseNumber", ignoreCase());

        Example<Address> example = Example.of(address, matcher);

        if (repository.exists(example)) {
            return repository.findOne(example).orElseThrow(() -> new ResourceNotFoundException("Address", "byExample", address));
        } else {
            return repository.save(address);
        }
    }
}
