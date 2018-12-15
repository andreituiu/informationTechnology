package com.model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.model.Admin;
import com.model.Teacher;
import com.model.User;
import com.model.dao.AdminDAO;
import com.model.mapper.AdminMapper;
import com.model.mapper.TeacherMapper;

public class AdminDAOImpl implements AdminDAO{
	private Connection conn;
	private AdminMapper adminMapper; 
	

	public AdminDAOImpl(AdminMapper adminMapper, Connection conn) {
		super();
		this.adminMapper = adminMapper;
		this.conn = conn;
	}

	@Override
	public void save(Admin admin) {
	        String query = "INSERT INTO admin( name, surname, cnp, external_email, internal_email, pass ) VALUES (?,?,?,?,?,?)";
	        String userQuery = "INSERT INTO users(name, surname, userCNP, role) VALUES(?,?,?, 'admin')";
			
	        try {
	            PreparedStatement p = conn.prepareStatement(query);
	            p.setString(1, admin.getName());
	            p.setString(2, admin.getSurname());
	            p.setString(3, admin.getCnp());
	            p.setString(4, admin.getExternalEmail());
	            p.setString(5, admin.getInternalEmail());
	            p.setString(6, admin.getPassword());
	            
	            p.executeUpdate();

	            p = conn.prepareStatement(userQuery);
				p.setString(1, admin.getName());
				p.setString(2, admin.getSurname());
				p.setString(3, admin.getCnp());
				p.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public void deleteUser(User selectedUser) {
		String query = "DELETE FROM admin WHERE CNP=? ";

        try {
            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, selectedUser.getCnp());

            p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public Admin getAdmin(String cnp) {
		String query = "SELECT * FROM admin WHERE cnp=?";

        ResultSet resultSet = null;
		try {
            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, cnp);

            resultSet = p.executeQuery();
            resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return adminMapper.getAdmin(resultSet);
        		
	}

	@Override
	public void update(Admin admin) {
		String query = "UPDATE admin SET name=?,surname=?,pass=?,external_email=?, internal_email=? WHERE cnp=?";
		ResultSet resultSet = null;
		try {
            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, admin.getName());
            p.setString(2, admin.getSurname());
            p.setString(3, admin.getPassword());
            p.setString(4, admin.getExternalEmail());
            p.setString(5, admin.getInternalEmail());
            p.setString(6, admin.getCnp());
            
            p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

}
