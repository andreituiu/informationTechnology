package com.model.dao.hibernateimplementation;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.model.Specialization;
import com.model.User;
import com.model.dao.SpecializationDAO;

public class SpecializationDAOHImpl extends BaseDAOHImpl<Specialization, Integer> implements SpecializationDAO{

	@Autowired
	private Session session;
	
	public SpecializationDAOHImpl() {
		super(Specialization.class);
	}

	@Override
	public List<Specialization> findAll() {
		return session.createCriteria(Specialization.class).list();
	}
}
