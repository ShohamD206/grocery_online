package com.marktProject.GroceryMarket.repository;

import com.marktProject.GroceryMarket.mappers.ContactMapper;
import com.marktProject.GroceryMarket.model.Contact;
import com.marktProject.GroceryMarket.model.enums.EInquiryStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

// The Repository class role is to interact with the database.

@Repository
public class ContactRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ContactRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int saveInquiry(Contact contact) {
        String sqlQuery = "INSERT INTO Inquiry (name,mobile_num,email,subject,message,status,created_at,created_by) VALUES (?,?,?,?,?,?,?,?)";

        return jdbcTemplate.update(
                sqlQuery,
                contact.getName(),
                contact.getMobileNum(),
                contact.getEmail(),
                contact.getSubject(),
                contact.getMessage(),
                contact.getStatus(),
                contact.getCreatedAt(),
                contact.getCreatedBy()
        );
    }

    public List<Contact> findByStatus(EInquiryStatus status) {

        String sqlQuery = "SELECT * FROM Inquiry WHERE status = ?";
        return jdbcTemplate.query(sqlQuery, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, status.toString());

            }
        }, new ContactMapper());
    }

    public int updateInquiryStatus(int inquiryId, EInquiryStatus status, String updatedBy) {

        String sqlQuery = "UPDATE Inquiry SET status = ?, updated_by = ?, updated_at = ? WHERE inquiry_id = ?";

        return jdbcTemplate.update(sqlQuery, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, status.toString());
                ps.setString(2, updatedBy);
                ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                ps.setInt(4, inquiryId);
            }
        });
    }
}
