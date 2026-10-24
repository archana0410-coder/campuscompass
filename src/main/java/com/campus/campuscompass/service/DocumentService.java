package com.campus.campuscompass.service;

import com.campus.campuscompass.exception.DocumentNotFoundException;
import com.campus.campuscompass.model.Document;
import com.campus.campuscompass.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }


    public Document getDocumentById(Long id) {
        return documentRepository.findById(id)
                .orElseThrow(() -> new DocumentNotFoundException("Document not found with id: " + id));
    }

    public Document saveDocument(Document document) {
        return documentRepository.save(document);
    }

    public Document updateDocument(Long id, Document details) {
        Document existing = getDocumentById(id);
        existing.setTitle(details.getTitle());
        existing.setCategory(details.getCategory());
        existing.setDescription(details.getDescription());
        existing.setFileUrl(details.getFileUrl());
        return documentRepository.save(existing);
    }

    public void deleteDocument(Long id) {
        Document existing = getDocumentById(id);
        documentRepository.delete(existing);
    }

    public List<Document> getDocumentsByCategory(String category) {
        return documentRepository.findByCategory(category);
    }
}