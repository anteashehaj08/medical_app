package org.example.entities;


import lombok.Data;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "doctors")
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long doctorId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String specialization;
    @Column(name = "contact_info")
    private String contactInfo;
    @Column(name = "start_work_at")
    private LocalTime startWorkAt;
    @Column(name = "end_work_at")
    private LocalTime endWorkAt;
    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;
   /* @ManyToMany
    @JoinColumn(name="id")
    private List<Patients> patients;
    @OneToMany(mappedBy = "doctor")
    private List<Report> report;*/
}
