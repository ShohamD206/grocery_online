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
import java.util.Optional;

// The service class is the connection between the UI layer to Repository layer.

@Service
@Slf4j
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public ContactService() {
        System.out.println("Contact Service bean was initialized!");
    }

    public boolean saveMessageDetails(Contact contact) {
        // Data manipulation.
        contact.setStatus(EInquiryStatus.OPEN.toString());

        Contact queryResult = contactRepository.save(contact);

        return (queryResult != null && queryResult.getInquiryId() > 0);
    }

    public List<Contact> findInquiriesByStatus() {

        List<Contact> inquiriesList = contactRepository.findByStatus(EInquiryStatus.OPEN.toString());
        return inquiriesList;
    }

    public boolean updateInquiryStatus(int inquiryId) {

        Optional<Contact> contact = contactRepository.findById(inquiryId);

        contact.ifPresent(contactObj -> {
            contactObj.setStatus(EInquiryStatus.CLOSED.toString());
        });

        Contact queryResult = contactRepository.save(contact.get());

        return (queryResult != null && queryResult.getUpdatedBy() != null);
    }
}
