package org.example.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "medicines")
public class Medicine {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name = "id")
    private Long medicineId;
    @Column (name = "type")
    private String type;
    @Column (name= "medicine_size")
    private Long medicineSize;
    @ManyToMany(mappedBy = "medicine")
    private List<Prescription> prescriptions;
    @ManyToOne
    @JoinColumn(name="appointment_id")
    private Appointment appointment;
}
