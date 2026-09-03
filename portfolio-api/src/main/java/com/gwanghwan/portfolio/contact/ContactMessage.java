package com.gwanghwan.portfolio.contact;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "contact_messages")
public class ContactMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @jakarta.persistence.Column(length = 2000)
    private String message;

    private LocalDateTime createdAt;

    protected ContactMessage() {
    }

    private ContactMessage(String name, String email, String message) {
        this.name = name;
        this.email = email;
        this.message = message;
    }

    public static ContactMessage of(String name, String email, String message) {
        return new ContactMessage(name, email, message);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @PrePersist
    private void setCreatedAt() {
        createdAt = LocalDateTime.now();
    }
}
