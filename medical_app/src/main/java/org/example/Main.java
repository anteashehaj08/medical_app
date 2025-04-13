package org.example;

import org.example.config.HibernateUtils;
import org.example.daos.PatientDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        HibernateUtils hibernateUtils = new HibernateUtils();
        SessionFactory sessionFactory = hibernateUtils.getSessionFactory();
        Session session = sessionFactory.openSession();

        PatientDao patientDao = new PatientDao(session);
        }
    }
