package com.gwanghwan.portfolio.contact;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin/contacts")
public class AdminContactController {

    private final ContactMessageRepository repository;

    public AdminContactController(ContactMessageRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<List<ContactResponse>> getContacts() {
        List<ContactResponse> contacts = repository.findAllByOrderByCreatedAtDesc()
                .stream()
                .map(ContactResponse::from)
                .toList();
        return ResponseEntity.ok(contacts);
    }

    public record ContactResponse(Long id, String name, String email, String message, String createdAt) {

        static ContactResponse from(ContactMessage contact) {
            return new ContactResponse(
                    contact.getId(),
                    contact.getName(),
                    contact.getEmail(),
                    contact.getMessage(),
                    contact.getCreatedAt() == null ? null : contact.getCreatedAt().toString());
        }
    }
}
