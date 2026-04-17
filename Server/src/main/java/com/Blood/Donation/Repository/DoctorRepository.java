package com.Blood.Donation.Repository;

import com.Blood.Donation.Entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepository extends JpaRepository<DoctorEntity , Long> {
    Optional<DoctorEntity> findByEmail(String email);
}
