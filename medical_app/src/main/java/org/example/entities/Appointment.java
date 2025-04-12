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
    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patients patient;
    @ManyToOne
    @JoinColumn(name="doctor_id")
    private Doctor doctor;
    @Column(name = "appointment_time")
    private LocalDateTime appointmentTime;
    private String purpose;
    @Enumerated(value = EnumType.STRING)
    private AppointmentStatus status;
    @OneToMany(mappedBy = "appointment")
    private List<Medicine> medicines;
    @OneToOne
    @JoinColumn(name="prescription_id")
    private Prescription prescription;
}
