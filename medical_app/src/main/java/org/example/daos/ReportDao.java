package org.example.daos;



import org.example.entities.Doctor;
import org.example.entities.Report;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;


public class ReportDao extends GenericDao<Report, Long> {
    private final Session session;

    public ReportDao(Session session) {
        super(session, Report.class);
        this.session = session;
    }
        public List<Report> findAllReportsByDoctors(Long ReportNr){
            String query = "select r from Report r join fetch r.doctor join fetch r.patient where doctor";
            Query<Report> q = session.createQuery(query, Report.class);
            return q.getResultList();
        }
    }

