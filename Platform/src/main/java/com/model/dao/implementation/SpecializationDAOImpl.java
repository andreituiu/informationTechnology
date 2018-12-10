package com.model.dao.implementation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.model.Specialization;
import com.model.dao.SpecializationDAO;
import com.model.mapper.SpecializationMapper;

public class SpecializationDAOImpl  implements SpecializationDAO 
	{
		
		private Connection conn;
	    private SpecializationMapper specializationMapper;

		public SpecializationDAOImpl(SpecializationMapper specializationMapper, Connection conn) {
			super();
			this.conn = conn;
			this.specializationMapper = specializationMapper;
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
	        return specializationMapper.getList(resultSet);

		}

		@Override
		public void saveNewSpecialization(Specialization specialization) {
			String query = "INSERT INTO specialization(name, year, semester) VALUES( ?, ?, ?)";
			try {
				PreparedStatement p = conn.prepareStatement(query);
				p.setString(1, specialization.getName());
				p.setInt(2, specialization.getYear());
				p.setInt(3, specialization.getSemester());
				p.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}



