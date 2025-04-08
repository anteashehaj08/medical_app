package org.example.daos;

import org.example.entities.Doctor;
import org.hibernate.Session;

import java.util.List;

public class DoctorDao extends GenericDao<Doctor, Long>{
    private final Session session;


    public DoctorDao(Session session) {
        super(session, Doctor.class);
        this.session = session;
    }
    public Doctor create(Doctor doctor) {
        return this.save(doctor);
    }
    public Doctor update(Doctor doctor) {
        return this.save(doctor);
    }
    public Doctor findById(Long id) {
        return super.findById(id);
    }
    public List<Doctor> findAll() {
        return super.findAll();
    }
    public List<Doctor> findBySpecialization(String specialization) {
        return super.findByString("specialization", specialization);
    }
}
