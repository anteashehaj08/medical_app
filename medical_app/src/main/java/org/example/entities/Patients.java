package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name = "patients")

public class Patients {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="patients_id")
private Long Id;
@Column(name="first_name")
    private String firstName;
@Column(name="last_name")
    private String lastName;
@Column(name = "birth_date")
    private Long birthDate;
    private Long NID;
@Column(name ="contact_info")
    private Long contactInfo;
@Column(name="medical_history")
    private String medicalHistory;
@ManyToOne
@JoinColumn(name = "appointment_id")
    private Appointment appointment;
@OneToMany(mappedBy = "patients_id_payments")
    private List<Payments> payments;
}
