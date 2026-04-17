package com.Blood.Donation.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DonorResponseDTO {

    private Long id;
    private String fullName;
    private String email;
    private String phoneNumber;
    private String city;
    private String bloodGroup;
}
