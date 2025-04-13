package org.example.config;

import org.example.entities.*;
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
            config.addAnnotatedClass(Prescription.class);
            config.addAnnotatedClass(Payments.class);
         /*   config.addAnnotatedClass(Medicine.class);
            config.addAnnotatedClass(Report.class);*/
           return config.buildSessionFactory();
        }
        return this.sessionFactory;
    }
}