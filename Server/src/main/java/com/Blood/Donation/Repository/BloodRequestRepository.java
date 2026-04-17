package com.Blood.Donation.Repository;

import com.Blood.Donation.Entity.BloodRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BloodRequestRepository extends JpaRepository<BloodRequestEntity , Long> {
}
