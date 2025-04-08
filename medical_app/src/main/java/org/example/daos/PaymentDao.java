package org.example.daos;

import org.example.entities.Patients;
import org.example.entities.Payments;
import org.hibernate.Session;

import java.util.List;

public class PaymentDao extends GenericDao<Payments, Long> {
    private final Session session;

    public PaymentDao(Session session) {
        super(session, Payments.class);
        this.session = session;
    }

    public Payments create(Payments payments) {
        payments.getAmount();
        return this.save(payments);
    }
    public Payments update(Payments payments) {
        payments.getAmount();
        return this.save(payments);
    }
    public Payments findById(Long id) {
        return super.findById(id);
    }
    public List<Payments> findAll() {
        return super.findAll();
    }

}