package com.campus.campuscompass.controller;

import com.campus.campuscompass.model.Document;
import com.campus.campuscompass.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/documents")
@CrossOrigin(origins = "*")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    /**
     * Retrieve all documents or filter by category if provided.
     */
    @GetMapping
    public List<Document> getAllDocuments(@RequestParam(required = false) String category) {
        if (category != null && !category.isEmpty()) {
            return documentService.getDocumentsByCategory(category);
        }
        return documentService.getAllDocuments();
    }

    /**
     * Retrieve a single document by its unique ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Document> getDocumentById(@PathVariable Long id) {
        Document document = documentService.getDocumentById(id);
        return ResponseEntity.ok(document);
    }

    /**
     * Create a new campus document.
     */
    @PostMapping
    public Document createDocument(@RequestBody Document document) {
        return documentService.saveDocument(document);
    }

    /**
     * Update an existing document by ID.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Document> updateDocument(@PathVariable Long id, @RequestBody Document documentDetails) {
        Document updatedDocument = documentService.updateDocument(id, documentDetails);
        return ResponseEntity.ok(updatedDocument);
    }

    /**
     * Delete a document by ID.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable Long id) {
        documentService.deleteDocument(id);
        return ResponseEntity.ok().build();
    }
}