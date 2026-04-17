package com.Blood.Donation.Controller;

import com.Blood.Donation.DTO.DonorRegisterDTO;
import com.Blood.Donation.DTO.DonorResponseDTO;
import com.Blood.Donation.Service.DonorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/donors")
@RequiredArgsConstructor
public class DonorController {

    private final DonorService donorService;

    @PostMapping("/register")
    public ResponseEntity<DonorResponseDTO> register(@RequestBody DonorRegisterDTO dto) {
        DonorResponseDTO response = donorService.register(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
