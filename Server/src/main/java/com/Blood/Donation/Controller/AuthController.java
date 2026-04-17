package com.Blood.Donation.Controller;

import com.Blood.Donation.DTO.LoginDTO;
import com.Blood.Donation.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/doctor/login")
    public ResponseEntity<String> doctorLogin(@RequestBody LoginDTO dto) {
        String token = authService.loginDoctor(dto);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/donor/login")
    public ResponseEntity<String> donorLogin(@RequestBody LoginDTO dto) {
        String token = authService.loginDonor(dto);
        return ResponseEntity.ok(token);
    }
}
