package com.Blood.Donation.Service;

import com.Blood.Donation.DTO.BloodRequestDTO;
import com.Blood.Donation.DTO.BloodRequestResponseDTO;
import com.Blood.Donation.Entity.BloodRequestEntity;
import com.Blood.Donation.Entity.DoctorEntity;
import com.Blood.Donation.Entity.DonorEntity;
import com.Blood.Donation.Repository.BloodRequestRepository;
import com.Blood.Donation.Repository.DoctorRepository;
import com.Blood.Donation.Repository.DonorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BloodRequestService {

    private final BloodRequestRepository bloodRequestRepository;
    private final DoctorRepository doctorRepository;
    private final DonorRepository donorRepository;
    private final JavaMailSender mailSender;

    public BloodRequestResponseDTO crateRequest(BloodRequestDTO dto , Long doctorId) {

        DoctorEntity doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found!"));

        BloodRequestEntity request = new BloodRequestEntity();
        request.setPatientName(dto.getPatientName());
        request.setBloodGroup(dto.getBloodGroup());
        request.setHospitalAddress(dto.getHospitalAddress());
        request.setCity(dto.getCity());
        request.setMessage(dto.getMessage());
        request.setDoctor(doctor);

        BloodRequestEntity saved = bloodRequestRepository.save(request);

        // send email to all donors in that city
        sendEmailToDonors(dto.getCity(), saved);

        return mapToResponse(saved);
    }

    private void sendEmailToDonors(String city , BloodRequestEntity request) {
        List<DonorEntity> donors = donorRepository.findByCity(city);

        for (DonorEntity donor : donors) {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(donor.getEmail());
            mail.setSubject("Urgent Blood Request - " + request.getBloodGroup());
            mail.setText(
                    "Dear " + donor.getFullName() + ",\n\n" +
                            "There is an urgent blood requirement in your city!\n\n" +
                            "Patient Name: " + request.getPatientName() + "\n" +
                            "Blood Group Needed: " + request.getBloodGroup() + "\n" +
                            "Hospital: " + request.getDoctor().getHospitalName() + "\n" +
                            "Address: " + request.getHospitalAddress() + "\n" +
                            "Message: " + request.getMessage() + "\n\n" +
                            "Please contact the hospital if you can help!\n\n" +
                            "Thank You,\nBlood Donation App"
            );
            mailSender.send(mail);
        }
    }

    private BloodRequestResponseDTO mapToResponse(BloodRequestEntity request) {
        BloodRequestResponseDTO response = new BloodRequestResponseDTO();
        response.setId(request.getId());
        response.setPatientName(request.getPatientName());
        response.setBloodGroup(request.getBloodGroup());
        response.setHospitalAddress(request.getHospitalAddress());
        response.setCity(request.getCity());
        response.setMessage(request.getMessage());
        response.setCreatedAt(request.getCreatedAt());
        response.setDoctorName(request.getDoctor().getName());
        response.setHospitalName(request.getDoctor().getHospitalName());
        return response;
    }
}
