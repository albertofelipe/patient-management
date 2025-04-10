package com.pm.patientservice.dto;

public record PatientResponseDto(
        String id,
        String name,
        String email,
        String address,
        String dateOfBirth
) {}