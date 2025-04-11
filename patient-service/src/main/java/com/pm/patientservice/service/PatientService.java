package com.pm.patientservice.service;

import com.pm.patientservice.dto.PatientRequestDto;
import com.pm.patientservice.dto.PatientResponseDto;
import com.pm.patientservice.exception.EmailAlreadyExistsException;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private PatientRepository patientRepository;

    public PatientService (PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<PatientResponseDto> getPatients () {
        List<Patient> patients = patientRepository.findAll();

        return patients.stream()
                .map(PatientMapper::toDto)
                .toList();
    }

    public PatientResponseDto createPatient(PatientRequestDto requestDto) {
        if(patientRepository.existsByEmail(requestDto.email())){
            throw new EmailAlreadyExistsException(
                    String.format("A patient with email '%s' already exists.", requestDto.email())
            );
        }

        Patient patient = patientRepository.save(PatientMapper.toModel(requestDto));

        return PatientMapper.toDto(patient);
    }

}
