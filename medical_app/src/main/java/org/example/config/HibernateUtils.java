package org.example.config;

import org.example.entities.Appointment;
import org.example.entities.Doctor;
import org.example.entities.Patients;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            Configuration config = new Configuration();
            config.addAnnotatedClass(Patients.class);
            config.addAnnotatedClass(Doctor.class);
            config.addAnnotatedClass(Appointment.class);
           return config.buildSessionFactory();
        }
        return this.sessionFactory;
    }
}