package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.example.staticData.AppointmentStatus;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "appointments")
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long appointmentId;
    @OneToMany(mappedBy = "patient_id")
    private List<Patients> patient;
    @OneToMany (mappedBy = "doctor_id")
    private List<Doctor> doctor;
    @Column(name = "appointment_time")
    private LocalDateTime appointmentTime;
    private String purpose;
    private AppointmentStatus status;
}
