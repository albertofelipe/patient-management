package com.pm.patientservice.mapper;

import com.pm.patientservice.dto.PatientRequestDto;
import com.pm.patientservice.dto.PatientResponseDto;
import com.pm.patientservice.model.Patient;

import java.time.LocalDate;
import java.util.UUID;

public class PatientMapper {

    public static PatientResponseDto toDto (Patient patient) {

        return new PatientResponseDto(
                patient.getId().toString(),
                patient.getName(),
                patient.getEmail(),
                patient.getAddress(),
                patient.getDateOfBirth().toString()
        );
    }

    public static Patient toModel (PatientRequestDto requestDto) {

        return new Patient(
                requestDto.name(),
                requestDto.email(),
                requestDto.address(),
                LocalDate.parse(requestDto.dateOfBirth()),
                LocalDate.parse(requestDto.registeredDate())
        );

    }
}
