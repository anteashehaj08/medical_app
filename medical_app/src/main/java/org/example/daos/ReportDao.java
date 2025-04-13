/*
package org.example.daos;



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
        public List<Report> findAllReportsByDoctors(Long doctorId){
            String query = "select r from Report r join fetch r.doctor d join fetch r.patient where d.id = :doctorId";
            Query<Report> q = session.createQuery(query, Report.class);
            q.setParameter("doctorId", doctorId);
            return q.getResultList();
        }
    }

*/
