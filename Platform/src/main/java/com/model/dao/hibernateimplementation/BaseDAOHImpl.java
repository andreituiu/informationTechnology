package com.model.dao.hibernateimplementation;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;

import com.model.dao.BaseDAO;

public class BaseDAOHImpl<T extends Serializable, PK extends Serializable> implements BaseDAO<T, PK> {

	@Autowired
	private Session session;
//	public static final Session SESSION = SessionUtil.getSessionFactory().openSession();
	private final Class<T> myType;// = (Class<T>) Serializable.class;

	public BaseDAOHImpl(Class<T> typeParameterClass) {
		this.myType = typeParameterClass;
	}

	@Override
	public void save(T obj) {
		Transaction tx = session.beginTransaction();
		session.save(obj);
		session.flush();
		tx.commit();
//		SESSION.close();
	}

	@Override
	public void delete(T obj) {
//		Session session = SESSION_FACTORY.openSession();
		session.beginTransaction();
		session.delete(obj);
		Transaction tx = session.getTransaction();
		if (tx.getStatus().equals(TransactionStatus.ACTIVE)) {
		    tx.commit();
		}
//		session.close();
	}

	@Override
	public T findByID(PK id) {
//		Session session = SESSION.openSession();
		T e = (T) session.load(myType, id);
//		session.close();
		return e;
	}

	@Override
	public void update(T obj) {
		Transaction tx = session.beginTransaction();
		session.update(obj);
		tx.commit();
	}

}
