package com.marktProject.GroceryMarket.service;

import com.marktProject.GroceryMarket.model.Contact;
import com.marktProject.GroceryMarket.model.enums.EInquiryStatus;
import com.marktProject.GroceryMarket.model.enums.EUserRoles;
import com.marktProject.GroceryMarket.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public boolean saveMessageDetails(Contact contact) {

        // Data manipulation.
        contact.setCreatedAt(LocalDateTime.now());
        contact.setCreatedBy(EUserRoles.GUEST.toString());
        contact.setStatus(EInquiryStatus.OPEN.toString());

        int queryResult = contactRepository.saveInquiry(contact);

        return (queryResult > 0);
    }
}
