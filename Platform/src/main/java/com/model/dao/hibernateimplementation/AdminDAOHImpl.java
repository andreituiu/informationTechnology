package com.model.dao.hibernateimplementation;

import com.model.Admin;
import com.model.dao.AdminDAO;

public class AdminDAOHImpl extends BaseDAOHImpl<Admin, String> implements AdminDAO{

	public AdminDAOHImpl() {
		super(Admin.class);
	}

//	private static final SessionFactory SESSION_FACTORY = SessionUtil.getSessionFactory();

//	public void save(Admin admin) {
//		Session session = SESSION_FACTORY.openSession();
//		Transaction tx = session.beginTransaction();
//		session.save(admin);
//		session.flush();
//		tx.commit();
//		session.close();
//	}
//
//	public void delete(Admin selectedUser) {
//		Session session = SESSION_FACTORY.openSession();
//		session.beginTransaction();
//		session.delete(selectedUser);
//		session.getTransaction().commit();
//		session.close();
//	}
//
//	public Admin findByID(String id) {
//		Session session = SESSION_FACTORY.openSession();
//		Admin e = (Admin) session.load(Admin.class, id);
//		session.close();
//		return e;
//	}

}
