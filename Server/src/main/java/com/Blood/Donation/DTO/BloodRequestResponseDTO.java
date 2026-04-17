package com.Blood.Donation.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloodRequestResponseDTO {

    private Long id;
    private String patientName;
    private String bloodGroup;
    private String hospitalAddress;
    private String city;
    private String message;
    private LocalDateTime createdAt;
    private String doctorName;
    private String hospitalName;
}
