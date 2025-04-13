package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.List;


@Data
@Entity
@Table(name = "patients")
public class Patients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long patientId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    private String NID;
    @Column(name = "contact_info")
    private String contactInfo;
    @Column(name = "medical_history")
    private String medicalHistory;
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointment;
    @OneToMany(mappedBy = "patients")
    private List<Payments> payments;
    @ManyToMany
    @JoinColumn (name="doctor_id")
    private List<Doctor> doctor;
}
