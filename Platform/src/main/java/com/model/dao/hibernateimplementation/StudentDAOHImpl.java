package com.model.dao.hibernateimplementation;

import com.model.Student;
import com.model.dao.StudentDAO;

public class StudentDAOHImpl  extends BaseDAOHImpl<Student, String> implements StudentDAO {

	public StudentDAOHImpl() {
		super(Student.class);
	}

}
