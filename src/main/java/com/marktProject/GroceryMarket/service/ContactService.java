package com.marktProject.GroceryMarket.service;

import com.marktProject.GroceryMarket.model.Contact;
import com.marktProject.GroceryMarket.model.enums.EInquiryStatus;
import com.marktProject.GroceryMarket.model.enums.EUserRoles;
import com.marktProject.GroceryMarket.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

// The service class is the connection between the UI layer to Repository layer.

@Service
@Slf4j
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public boolean saveMessageDetails(Contact contact) {

        // Data manipulation.
        contact.setCreatedAt(LocalDateTime.now());
        contact.setCreatedBy(EUserRoles.ADMIN.toString());
        contact.setStatus(EInquiryStatus.OPEN.toString());

        int queryResult = contactRepository.saveInquiry(contact);

        return (queryResult > 0);
    }

    public List<Contact> findInquiriesByStatus() {

        List<Contact> inquiriesList = contactRepository.findByStatus(EInquiryStatus.OPEN);
        return inquiriesList;
    }

    public boolean updateInquiryStatus(int inquiryId, String updatedBy) {

        int queryResult = contactRepository.updateInquiryStatus(inquiryId, EInquiryStatus.CLOSED, updatedBy);

        return (queryResult > 0);
    }
}
