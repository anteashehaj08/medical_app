package org.example.daos;

import org.example.entities.Appointment;
import org.example.staticData.AppointmentStatus;
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
    public void delete(Appointment appointment) {
        if (appointment.getStatus() == AppointmentStatus.CANCELLED) {
            this.session.delete(appointment);
        }
    }

}
