package com.Blood.Donation.Service;

import com.Blood.Donation.DTO.DoctorRegisterDTO;
import com.Blood.Donation.DTO.DoctorResponseDTO;
import com.Blood.Donation.Entity.DoctorEntity;
import com.Blood.Donation.Repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final PasswordEncoder passwordEncoder;

    public DoctorResponseDTO register(DoctorRegisterDTO dto) {

        if(doctorRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered!");
        }

        DoctorEntity doctor = new DoctorEntity();
        doctor.setName(dto.getName());
        doctor.setHospitalName(dto.getHospitalName());
        doctor.setCity(dto.getCity());
        doctor.setEmail(dto.getEmail());
        doctor.setPassword(passwordEncoder.encode(dto.getPassword()));
        doctor.setPhoneNumber(dto.getPhoneNumber());
        doctor.setLicenseNumber(dto.getLicenseNumber());

        DoctorEntity saved = doctorRepository.save(doctor);

        return mapToResponse(saved);
    }

    private DoctorResponseDTO mapToResponse(DoctorEntity doctor) {
        DoctorResponseDTO response = new DoctorResponseDTO();
        response.setId(doctor.getId());
        response.setName(doctor.getName());
        response.setHospitalName(doctor.getHospitalName());
        response.setCity(doctor.getCity());
        response.setEmail(doctor.getEmail());
        response.setPhoneNumber(doctor.getPhoneNumber());
        response.setLicenseNumber(doctor.getLicenseNumber());
        return response;
    }
}
