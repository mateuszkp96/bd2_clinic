package com.mkopec.clinic.service;

import com.mkopec.clinic.repository.AppointmentRepoistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepoistory repoistory;

}
