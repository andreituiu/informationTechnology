package com.model.dao.hibernateimplementation;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.model.Teacher;
import com.model.dao.TeacherDAO;

public class TeacherDAOHImpl extends BaseDAOHImpl<Teacher, String> implements TeacherDAO {

	@Autowired
	private Session session;
	
	public TeacherDAOHImpl() {
		super(Teacher.class);
	}

	@Override
	public List<Teacher> findAll() {
		return session.createCriteria(Teacher.class).list();
	}

}
