package com.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Specialization;


public class SpecializationMapper {


	public Specialization getSpecialization(ResultSet resultSet) {
		Specialization specialization = new Specialization();
		
        try {
        	
        	specialization.setName(resultSet.getString("specialization_name"));
      
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return specialization;
    }

	public List<Specialization> getList(ResultSet resultSet) {

		List<Specialization> specializations = new ArrayList<>();
		
		try {
			while(resultSet.next()) {
				
				specializations.add(getSpecialization(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return specializations ;
	}

}
