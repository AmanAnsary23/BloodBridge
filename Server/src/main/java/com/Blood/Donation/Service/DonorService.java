package com.Blood.Donation.Service;

import com.Blood.Donation.DTO.DonorRegisterDTO;
import com.Blood.Donation.DTO.DonorResponseDTO;
import com.Blood.Donation.Entity.DonorEntity;
import com.Blood.Donation.Repository.DonorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DonorService {

    private final DonorRepository donorRepository;
    private final PasswordEncoder passwordEncoder;

    public DonorResponseDTO register(DonorRegisterDTO dto) {

        if(donorRepository.findByEmail(dto.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered!");
        }

        DonorEntity donor = new DonorEntity();
        donor.setFullName(dto.getFullName());
        donor.setEmail(dto.getEmail());
        donor.setPassword(passwordEncoder.encode(dto.getPassword()));
        donor.setPhoneNumber(dto.getPhoneNumber());
        donor.setCity(dto.getCity());
        donor.setBloodGroup(dto.getBloodGroup());

        DonorEntity saved = donorRepository.save(donor);

        return mapToResponse(saved);

    }

    private DonorResponseDTO mapToResponse(DonorEntity donor) {
        DonorResponseDTO response = new DonorResponseDTO();
        response.setId(donor.getId());
        response.setFullName(donor.getFullName());
        response.setEmail(donor.getEmail());
        response.setPhoneNumber(donor.getPhoneNumber());
        response.setCity(donor.getCity());
        response.setBloodGroup(donor.getBloodGroup());
        return response;
    }
}
