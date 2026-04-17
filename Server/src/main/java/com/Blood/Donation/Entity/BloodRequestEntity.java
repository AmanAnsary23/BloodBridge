package com.Blood.Donation.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Entity
@Table(name = "bloodrequest")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloodRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientName;
    private String bloodGroup;
    private String hospitalAddress;
    private String city;
    private String message;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private DoctorEntity doctor;

    @CreationTimestamp
    private LocalDateTime createdAt;
}
