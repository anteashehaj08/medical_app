package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.example.staticData.AppointmentStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long appointmentId;
    @Column(name = "patinet_id")
    @OneToMany
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    @Column(name = "appointment_time")
    private LocalDateTime appointmentTime;
    private String purpose;
    private AppointmentStatus status;
}
