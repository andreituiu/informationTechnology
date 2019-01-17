package com.model.dao.implementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Course;
import com.model.Specialization;
import com.model.Teacher;
import com.model.dao.SpecializationDAO;
import com.model.mapper.SpecializationMapper;

public class SpecializationDAOImpl  implements SpecializationDAO 
	{
		
		private Connection conn;

		public SpecializationDAOImpl(Connection conn) {
			super();
			this.conn = conn;
		}

		@Override
		public List<Specialization> getAllSpecializations() {
	        String query = "SELECT * FROM specialization";
	        ResultSet resultSet = null;
	        try {
	            PreparedStatement p = conn.prepareStatement(query);
	            resultSet = p.executeQuery();            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        List<Specialization> specializations = new ArrayList<>();

	        try {
	        while (resultSet.next()) {
	        	Specialization specialization = new Specialization();
					specialization.setName(resultSet.getString("specializationName"));
					specializations.add(specialization);
				}
	        } catch (SQLException e) {
	        	// TODO Auto-generated catch block
	        	e.printStackTrace();
	        	
			}
	        return specializations;

		}

		@Override
		public void saveNewSpecialization(Specialization specialization) {
			String query = "INSERT INTO specialization(specializationName) VALUES( ?)";
			try {
				PreparedStatement p = conn.prepareStatement(query);
				p.setString(1, specialization.getName());
//				p.setInt(2, specialization.getYear());
//				p.setInt(3, specialization.getSemester());
				p.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		@Override
		public Specialization getSpecializationFor(Course course) {
			return new Specialization();
//			String query = "SELECT * FROM specialization,course where course_name= '?' ";
//			ResultSet resultSet = null;
//			
//			try {
//				PreparedStatement p = conn.prepareStatement(query);
//				p.setString(1, course.getSpecialization().getName());
//				resultSet = p.executeQuery();
//				
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			return specializationMapper.getSpecialization(resultSet);
		}

		@Override
		public void updateSpecializationName(Specialization specializationSelected) {
			String query = "UPDATE specialization SET specializationName=? WHERE specializationName=?";
			try {
				PreparedStatement p = conn.prepareStatement(query);
				p.setString(1, specializationSelected.getName());
				p.setString(2, specializationSelected.getName());
				p.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	
	
	}



