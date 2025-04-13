package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Payments")


public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long paymentId;
    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patients patients;
    @Column(name="payment_date")
    private LocalDate paymentDate;
    private Double amount;
    private String description;
}
