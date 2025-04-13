package org.example.daos;
import org.example.entities.Appointment;
import org.example.entities.Medicine;
import org.example.entities.Prescription;
import org.hibernate.Session;
import org.hibernate.query.Query;
import java.time.LocalDateTime;
import java.util.List;

public class PrescriptionDao extends GenericDao<Prescription, Long> {
    private final Session session;
    private final AppointmentDao appointmentDao;

    public PrescriptionDao(Session session, AppointmentDao appointmentDao) {
        super(session, Prescription.class);
        this.session = session;
        this.appointmentDao = appointmentDao;
    }

    public List<Prescription> findByPatientId(Long patientId) {
        String query = "from Prescription p where p.appointment.patient.patientId = :patientId";
        Query<Prescription> queryFindByPatient = session.createQuery(query, Prescription.class);
        queryFindByPatient.setParameter("patientId", patientId);
        return queryFindByPatient.getResultList();
    }

    public Prescription create(Prescription prescription, Long appointmentId) {
        Appointment appointment = appointmentDao.findById(appointmentId);
        prescription.setAppointment(appointment);
        return super.save(prescription);
    }


    public List<Prescription> findByAppointmentTime(LocalDateTime appointmentTime) {
        String query = "select p from Prescription p where p.appointment.appointmentTime = :appointmentTime";
        Query<Prescription> queryFindByPrescriptionDate = session.createQuery(query, Prescription.class);
        queryFindByPrescriptionDate.setParameter("appointment_time", appointmentTime);
        return queryFindByPrescriptionDate.getResultList();
    }
    }


