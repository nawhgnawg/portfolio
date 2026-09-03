package com.gwanghwan.portfolio.contact;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ContactController {

    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("portfolio-api is running");
    }

    @PostMapping("/contact")
    public ResponseEntity<ContactResponse> createContact(@Valid @RequestBody ContactRequest request) {
        contactService.save(request);
        return ResponseEntity.ok(new ContactResponse("문의가 접수되었습니다."));
    }

    public record ContactResponse(String message) {
    }
}
