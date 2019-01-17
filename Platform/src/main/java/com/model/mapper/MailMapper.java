package com.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Mail;

public class MailMapper {

    public List<Mail> getList(ResultSet resultSet) {
        List<Mail> list = new ArrayList<>();

        if(resultSet == null) {
            return list;
        }
           
        try {
            while (resultSet.next()) {
                String toCnp = resultSet.getString("toCNP");
                String fromCnp = resultSet.getString("fromCNP");
                String subject = resultSet.getString("subject");
                String message = resultSet.getString("message");

                Mail mail = new Mail(toCnp, fromCnp, subject, message);
                list.add(mail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
