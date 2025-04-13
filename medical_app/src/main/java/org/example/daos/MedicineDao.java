/*
package org.example.daos;

import org.example.entities.Medicine;
import org.example.entities.Prescription;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDateTime;
import java.util.List;

public class MedicineDao extends GenericDao<Medicine,Long>{
    private final Session session;

    public MedicineDao(Session session) {
        super(session, Medicine.class);
        this.session = session;
    }
    public Medicine create(Medicine medicine) {
        return this.save(medicine);
    }

    public Medicine update(Medicine medicine) {
        return this.save(medicine);
    }
}
*/
