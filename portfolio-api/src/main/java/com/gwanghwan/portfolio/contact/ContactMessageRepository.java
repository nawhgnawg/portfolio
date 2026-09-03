package com.gwanghwan.portfolio.contact;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {

    java.util.List<ContactMessage> findAllByOrderByCreatedAtDesc();
}
