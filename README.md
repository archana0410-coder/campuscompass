#  CampusCompass - Intelligent Campus Information & Retrieval System

## 1. Project Purpose
CampusCompass is a full-stack campus information management and document retrieval system built for university students to instantly access Anna University 2023 regulation syllabus materials, department-wise subject details, university attendance/assessment rules, and hostel information.

## 2. Tech Stack & Implementation Details
* **Backend:** Java 21, Spring Boot 3.3.5, Spring Data JPA, Hibernate, Maven
* **Database:** H2 In-Memory Database (with automated startup seeding via `CommandLineRunner`)
* **Frontend:** HTML5, CSS3, JavaScript (`fetch()` API for real-time asynchronous communication)
* **Port:** Running on port `8083`

## 3. Project Architecture & Components
The application follows a strict standard **Layered Architecture** to maintain clean separation of concerns:
* **Controller Layer (`com.campus.campuscompass.controller`):** Manages REST API endpoints (`DocumentController`) for handling HTTP requests and responses.
* **Service Layer (`com.campus.campuscompass.service`):** Contains core business logic (`DocumentService.java`) and transaction management.
* **Repository Layer (`com.campus.campuscompass.repository`):** Interacts with the H2 database using Spring Data JPA (`DocumentRepository`).
* **Model Layer (`com.campus.campuscompass.model`):** Defines entity schemas (`Document` with fields like `id`, `title`, `description`, `content`, `category`).
* **Exception Handling (`com.campus.campuscompass.exception`):** Centralized error management using `GlobalExceptionHandler` (`@RestControllerAdvice`) and custom `DocumentNotFoundException`.

## 4. Database Configuration (`application.properties`)
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
server.port=8083
## API Endpoints Table
| Method | Endpoint | Request Body | Response | Description |
| :--- | :--- | :--- | :--- | :--- |
| **GET** | `/api/documents` | None | JSON Array | Retrieve all campus documents or filter by category (`?category=...`)[cite: 3] |
| **GET** | `/api/documents/{id}` | None | JSON Object | Retrieve a specific document by unique ID (Throws 404 via GlobalExceptionHandler if missing)[cite: 3] |
| **POST** | `/api/documents` | JSON Document | JSON Object | Create and save a new campus document