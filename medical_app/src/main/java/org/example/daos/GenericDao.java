package org.example.daos;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class GenericDao<T, ID> {
    private final Session session;
    private Transaction transaction;
    private final Class<T> aClasss;
    public GenericDao(Session session, Class<T> clazz) {
        this.session = session;
        this.aClasss = clazz;
    }
    public T save(T entity) {
        this.transaction =session.beginTransaction();
        try {
            T saved = (T) session.merge(entity);
            transaction.commit();
            return saved;
        }catch (Exception e){
            transaction.rollback();
            throw new RuntimeException(e);
        }
    }
    protected T findById(ID id) {
        return (T) session.find(aClasss, id);
    }
    protected List<T> findAll() {
        String query = String.format("select e from %s e", aClasss.getSimpleName());
        Query<T> findAllQuery = session.createQuery(query, aClasss);
        return findAllQuery.getResultList();
    }

    public void delete(ID id){
        this.transaction =session.beginTransaction();
        try {
            T entity = this.findById(id);
            session.remove(entity);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            throw new RuntimeException(e);
        }
    }

}


