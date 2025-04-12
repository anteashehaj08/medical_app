package org.example.daos;
import org.example.entities.Patients;
import org.example.entities.Payments;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.List;

public class PaymentDao extends GenericDao<Payments, Long> {
    private final Session session;
    private final PatientDao patientDao;

    public PaymentDao(Session session, PatientDao patientDao) {
        super(session, Payments.class);
        this.session = session;
        this.patientDao = patientDao;
    }

    public Payments create(Payments payments, Long patientId) {
        Patients patient = patientDao.findById(patientId);
        payments.setPatients(patient);
        payments.setPaymentDate(LocalDate.now());
        return this.save(payments);
    }
    public Payments update(Payments payments) {
        return this.save(payments);
    }
    public Payments findById(Long id) {
        return super.findById(id);
    }
    public List<Payments> findAll() {
        return super.findAll();
    }

    public List<Payments>findPatientPayments(Long patientId) {
        String query = "select p from Payments p where p.patients.patientId = :patientId";
        Query<Payments> findByPatient = session.createQuery(query, Payments.class);
        findByPatient.setParameter("patientId", patientId);
        return findByPatient.getResultList();
    }
   public List<Payments>findByPaymentDate(LocalDate paymentDate, Long patientId){
        String query = "select p from Payments p where p.paymentDate >= :paymentDate and p.patients.patientId = :patientId";
        Query<Payments> findByPaymentDate = session.createQuery(query, Payments.class);
        findByPaymentDate.setParameter("payment_date", paymentDate);
        findByPaymentDate.setParameter("patientId", patientId);
        return findByPaymentDate.getResultList();
    }
}