package com.gwanghwan.portfolio.contact;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactService {

    private final ContactMessageRepository repository;

    public ContactService(ContactMessageRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void save(ContactRequest request) {
        ContactMessage contactMessage = ContactMessage.of(
                request.name().trim(),
                request.email().trim(),
                request.message().trim());
        repository.save(contactMessage);
    }
}
