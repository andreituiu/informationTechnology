package com.model.dao.implementation;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.model.Student;
import com.model.Teacher;
import com.model.dao.StudentDAO;
import com.model.dao.TeacherDAO;

public class TeacherDAOImpl implements TeacherDAO {
	private SessionFactory factory; 

	
	
	public TeacherDAOImpl(SessionFactory factory) {
		super();
		this.factory = factory;
	}



	@Override
	public Teacher getTeacher(String cnp) {
		Session session = factory.openSession();
		String hql = "FROM teacher WHERE cnp= :teacher_cnp";
		TypedQuery<Teacher> query = session.createQuery(hql);
		query.setParameter("teacher_cnp", cnp);
	    List<Teacher> result = query.getResultList();
		
	    if(result.isEmpty()) {
	    	return null;
	    }
		return result.get(0);
	}

}
