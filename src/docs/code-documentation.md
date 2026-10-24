# 💻 CampusCompass - Code-Level Documentation & Javadocs

## 1. Overview of Code Documentation Standards
The codebase follows standard Java documentation practices (Javadocs) and clean code principles. Every major layer—Controllers, Services, Repositories, Models, and Exception Handlers—includes descriptive class-level and method-level comments to explain non-obvious business logic, transaction handling, and REST routing.

---

## 2. Key Components and Documentation Breakdown

### A. Controller Layer (`com.campus.campuscompass.controller`)
* **`DocumentController.java`**
    * Annotated with `@RestController` and `@RequestMapping("/api/documents")`.
    * Contains Javadocs explaining HTTP method mappings (`GET`, `POST`, `PUT`, `DELETE`), request parameter handling (such as `?category=...`), and response status codes (`200 OK`, `201 Created`, `204 No Content`).

### B. Service Layer (`com.campus.campuscompass.service`)
* **`DocumentService.java`**
    * Annotated with `@Service`.
    * Implements core business logic, data filtering, and exception triggering.
    * Documented with Javadocs detailing method parameters, return types, and custom exceptions thrown (e.g., `DocumentNotFoundException`).

### C. Repository Layer (`com.campus.campuscompass.repository`)
* **`DocumentRepository.java`**
    * Extends `JpaRepository<Document, Long>`.
    * Handles automated database queries and custom finder methods like `findByCategory(String category)`.

### D. Exception Handling Layer (`com.campus.campuscompass.exception`)
* **`GlobalExceptionHandler.java`**
    * Annotated with `@RestControllerAdvice`.
    * Captures runtime exceptions globally and returns standardized, user-friendly JSON error responses with proper HTTP status codes.

---

## 3. Example Javadoc Template Used in Code
```java
/**
 * Retrieves a specific document by its unique ID or throws a custom exception.
 * @param id The unique identifier of the document
 * @return The found Document entity
 * @throws DocumentNotFoundException if the record does not exist in the database
 */