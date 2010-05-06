package org.onebusaway.gtdf.serialization;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;

public class HibernateEntityStore implements GTDFEntityStore {

  private static final int BUFFER_SIZE = 50;

  private SessionFactory _sessionFactory;

  private Session _session;

  private Transaction _tx;

  private int _count = 0;

  public void setSessionFactory(SessionFactory sessionFactory) {
    _sessionFactory = sessionFactory;
  }

  public void setSession(org.hibernate.classic.Session session) {
    _session = session;
  }

  public void open() {
    _session = _sessionFactory.openSession();
    _tx = _session.beginTransaction();
  }

  public void close() {
    _tx.commit();
    _session.close();
  }

  public Object load(Class<?> entityClass, Serializable id) {
    return _session.load(entityClass, id);
  }

  public void save(Object entity) {
    _session.save(entity);
    _count++;
    if (_count >= BUFFER_SIZE)
      flush();
  }

  public void flush() {
    _session.flush();
    _session.clear();
    _count = 0;
  }
}
