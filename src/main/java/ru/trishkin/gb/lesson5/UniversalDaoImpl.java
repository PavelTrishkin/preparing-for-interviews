package ru.trishkin.gb.lesson5;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UniversalDaoImpl<T, E> implements UniversalDao<T, E> {

    private Class<T> type;
    private Class<E> id;

    private SessionFactory sessionFactory;
    private Session session;

    public UniversalDaoImpl (Class<T> type, Class<E> id){
        this.type = type;
        this.id = id;
        sessionFactory = getSessionFactory();
    }

    private static SessionFactory getSessionFactory(){
        return new Configuration().configure("/resources/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    @Override
    public void saveOrUpdate(T obj) {
        session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(obj);
    }

    @Override
    public E save(T obj) {
        session = sessionFactory.getCurrentSession();
        return (E) session.save(obj);
    }

    @Override
    public T findById(E obj) {
        session = sessionFactory.getCurrentSession();
        return session.find(type , obj);
    }

    @Override
    public void delete(T obj) {
        session = sessionFactory.getCurrentSession();
        session.delete(obj);
    }
}
