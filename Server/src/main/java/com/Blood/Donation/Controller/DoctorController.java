package com.Blood.Donation.Controller;

import com.Blood.Donation.DTO.DoctorRegisterDTO;
import com.Blood.Donation.DTO.DoctorResponseDTO;
import com.Blood.Donation.DTO.DonorResponseDTO;
import com.Blood.Donation.Service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping("/register")
    public ResponseEntity<DoctorResponseDTO> register(@RequestBody DoctorRegisterDTO dto) {
        DoctorResponseDTO response = doctorService.register(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
