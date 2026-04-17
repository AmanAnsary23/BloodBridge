package com.Blood.Donation.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloodRequestDTO {

    private String patientName;
    private String bloodGroup;
    private String hospitalAddress;
    private String city;
    private String message;
}
