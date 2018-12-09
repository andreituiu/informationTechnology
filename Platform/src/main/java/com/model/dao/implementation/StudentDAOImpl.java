package com.model.dao.implementation;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Student;
import com.model.dao.StudentDAO;

public class StudentDAOImpl implements StudentDAO {
	private SessionFactory factory; 

	public StudentDAOImpl(SessionFactory factory) {
		super();
		this.factory = factory;
	}

	@Override
	public Student getStudent(String cnp) {
		Session session = factory.openSession();
		String hql = "FROM student WHERE cnp= :student_cnp";
		TypedQuery<Student> query = session.createQuery(hql);
		query.setParameter("student_cnp", cnp);
	    List<Student> result = query.getResultList();
		
	    if(result.isEmpty()) {
	    	return null;
	    }
		return result.get(0);
	}

}
