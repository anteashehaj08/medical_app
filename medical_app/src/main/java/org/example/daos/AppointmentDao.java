package org.example.daos;

import org.example.entities.Appointment;
import org.example.entities.Payments;
import org.hibernate.Session;

public class AppointmentDao extends GenericDao<Appointment, Long> {
    private final Session session;

    public AppointmentDao(Session session) {
        super(session, Appointment.class);
        this.session = session;
    }

    public Appointment create(Appointment appointment) {
        return this.save(appointment);
    }

    public Appointment update(Appointment appointment) {
        return this.save(appointment);
    }


}
