package org.example.daos;
import org.example.entities.Patients;
import org.hibernate.Session;

import java.util.List;

public class PatientDao extends GenericDao<Patients, Long> {
    private final Session session;

    public PatientDao(Session session) {
        super(session, Patients.class);
        this.session = session;
    }

    public Patients create(Patients patient) {
        return this.save(patient);
    }
    public Patients update(Patients patient) {
        return this.save(patient);
    }
    public Patients findById(Long id) {
        return super.findById(id);
    }
    public List<Patients> findAll() {
        return super.findAll();
    }
    public List<Patients> findByPatientName(String firstName) {
        return super.findByFieldName("firstName", firstName);
    }

    public List<Patients> findByPatientSurname(String lastName) {
        return super.findByFieldName("lastName", lastName);
    }

    public List<Patients> findByPatientEmail(String contactInfo) {
        return super.findByFieldName("contactInfo", contactInfo);
    }
    }

