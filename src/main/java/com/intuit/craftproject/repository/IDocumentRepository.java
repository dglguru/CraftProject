package com.intuit.craftproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.intuit.craftproject.model.Document;

@Repository
public interface IDocumentRepository extends JpaRepository<Document, Long>{

}
