package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
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
    private LocalDateTime startWorkAt;
    @Column(name = "end_work_at")
    private LocalDateTime endWorkAt;
    @OneToMany (mappedBy = "doctor")
    private List<Appointment> appointment;
}
