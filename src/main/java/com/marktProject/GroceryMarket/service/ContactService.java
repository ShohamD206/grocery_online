package com.marktProject.GroceryMarket.service;

import com.marktProject.GroceryMarket.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ContactService {

    public Contact createContact(Contact contact) {

        if (contact != null)
            log.info(contact.toString());

        return contact;
    }
}
