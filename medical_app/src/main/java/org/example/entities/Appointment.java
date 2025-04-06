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
    @Column(name = "patient_id")
    @OneToMany(mappedBy = "appointment_id")
    private List<Patients> patient;
    @OneToMany (mappedBy = "appointment_id_doctor")
    private List<Doctor> doctor;
    @Column(name = "appointment_time")
    private LocalDateTime appointmentTime;
    private String purpose;
    private AppointmentStatus status;
}
