package org.example.daos;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class GenericDao<T, ID> {
    private final Session session;
    private Transaction tx;
    private final Class<T> clazz;
    public GenericDao(Session session, Class<T> clazz) {
        this.session = session;
        this.clazz = clazz;
    }
    public T save(T entity) {
        this.tx=session.beginTransaction();
        try {
            T saved = (T) session.merge(entity);
            tx.commit();
            return saved;
        }catch (Exception e){
            tx.rollback();
            throw new RuntimeException(e);
        }
    }
    protected T findById(ID id) {
        return (T) session.find(clazz, id);
    }
    protected List<T> findAll() {
        String query = String.format("select e from %s e", clazz.getSimpleName());
        Query<T> findAllQuery = session.createQuery(query, clazz);
        return findAllQuery.getResultList();
    }

    public void delete(ID id){
        this.tx=session.beginTransaction();
        try {
            T entity = this.findById(id);
            session.remove(entity);
            tx.commit();
        }catch (Exception e){
            tx.rollback();
            throw new RuntimeException(e);
        }
    }

}


