package com.Blood.Donation.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DoctorResponseDTO {

    private Long id;
    private String name;
    private String hospitalName;
    private String city;
    private String email;
    private String phoneNumber;
    private String licenseNumber;
}
