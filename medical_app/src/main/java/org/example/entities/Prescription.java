package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "prescriptions")
@Data
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prescription_id")
    private Long prescriptionId;
    @OneToOne
    @JoinColumn(name = "appointment_id_prescription")
    private Appointment appointment;
    @Column(name = "prescription_date")
    private LocalDate prescriptionDate;
    private String medicines;
}
