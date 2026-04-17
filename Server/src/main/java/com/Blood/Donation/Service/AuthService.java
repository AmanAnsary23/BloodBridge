package com.Blood.Donation.Service;

import com.Blood.Donation.Config.JwtUtil;
import com.Blood.Donation.DTO.LoginDTO;
import com.Blood.Donation.Repository.DoctorRepository;
import com.Blood.Donation.Repository.DonorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final DoctorRepository doctorRepository;
    private final DonorRepository donorRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public String loginDoctor(LoginDTO dto) {
        var doctor = doctorRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Doctor not found!"));

        if(!passwordEncoder.matches(dto.getPassword(), doctor.getPassword())){
            throw  new RuntimeException("Invalid password!");
        }

        return jwtUtil.generateToken(doctor.getEmail(), "DOCTOR");
    }

    public String loginDonor(LoginDTO dto) {
        var donor = donorRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Donor not found!"));

        if(!passwordEncoder.matches(dto.getPassword(), donor.getPassword())) {
            throw new RuntimeException("Invalid password!");
        }

        return jwtUtil.generateToken(donor.getEmail() , "DONOR");
    }
}
