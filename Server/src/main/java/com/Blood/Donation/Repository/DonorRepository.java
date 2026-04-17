package com.Blood.Donation.Repository;

import com.Blood.Donation.Entity.DonorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DonorRepository extends JpaRepository<DonorEntity, Long> {

    Optional<DonorEntity> findByEmail(String email);
    List<DonorEntity> findByCity(String city);
}
