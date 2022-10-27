package com.marktProject.GroceryMarket.repository;
import com.marktProject.GroceryMarket.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// The Repository class role is to interact with the database.

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {

    // to show the inquiries table in the dashboard with status OPEN.
    List<Contact> findByStatus(String status);
}
