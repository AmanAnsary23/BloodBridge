package com.Blood.Donation.Controller;

import com.Blood.Donation.DTO.BloodRequestDTO;
import com.Blood.Donation.DTO.BloodRequestResponseDTO;
import com.Blood.Donation.Entity.DoctorEntity;
import com.Blood.Donation.Repository.DoctorRepository;
import com.Blood.Donation.Service.BloodRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/blood-requests")
@RequiredArgsConstructor
public class BloodRequestController {

    private final BloodRequestService bloodRequestService;
    private final DoctorRepository doctorRepository;

    @PostMapping
    public ResponseEntity<BloodRequestResponseDTO> createRequest (
            @RequestBody BloodRequestDTO dto,
            @AuthenticationPrincipal String email
            ) {
        DoctorEntity doctor = doctorRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Doctor not found!"));

        BloodRequestResponseDTO response = bloodRequestService.crateRequest(dto, doctor.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
