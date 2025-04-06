package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Payments")


public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payments_id")
    private Long ID;
    @ManyToOne
    @JoinColumn(name="patients_id_payments")
    private Patients patients;
    @Column(name="payment_date")
    private LocalDate paymentDate;
    private Double amount;
    private String description;
}
