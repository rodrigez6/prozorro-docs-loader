package org.rodrigez.repository;

import org.rodrigez.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document,String> {
}
