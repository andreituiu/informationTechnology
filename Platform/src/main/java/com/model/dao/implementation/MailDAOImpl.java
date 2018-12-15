package com.model.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.model.Mail;
import com.model.User;
import com.model.dao.MailDAO;
import com.model.mapper.MailMapper;

public class MailDAOImpl implements MailDAO {

    private Connection conn;
    private MailMapper mailMapper;

    public MailDAOImpl(MailMapper mailMapper, Connection conn) {
        super();
        this.mailMapper = mailMapper;
        this.conn = conn;
    }

    @Override
    public void sendMail(Mail mail) {
        String query = "INSERT INTO `mail`(`fromCNP`, `toCNP`, `message`, `subject`) VALUES (?,?,?,?)";
        try {
            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, mail.getFromCnp());
            p.setString(2, mail.getToCnp());
            p.setString(3, mail.getMessage());
            p.setString(4, mail.getSubject());
            p.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Mail> getInboxMails(User user) {
        String query = "SELECT * FROM mail WHERE toCNP = ?";
        ResultSet resultSet = null;
        try {
            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, user.getCnp());
            resultSet = p.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mailMapper.getList(resultSet);

    }

    @Override
    public List<Mail> getSentMails(User user) {
        String query = "SELECT * FROM mail WHERE fromCNP = ?";
        ResultSet resultSet = null;
        try {
            PreparedStatement p = conn.prepareStatement(query);
            p.setString(1, user.getCnp());
            resultSet = p.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mailMapper.getList(resultSet);
    }

}
