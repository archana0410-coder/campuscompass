# 🏛️ CampusCompass - System Design & Architecture Documentation

## 1. Problem Statement
University students require an instant, centralized, and web-accessible repository to look up Anna University 2023 regulation syllabus details, hostel rules, and important campus announcements without navigating through heavy files.

## 2. Layered Architecture Flow
CampusCompass is structured following strict Spring Boot **Layered Architecture**:
* **Frontend Layer (`index.html`):** User interface built with HTML5, CSS3, and JavaScript Fetch API communicating asynchronously with backend REST endpoints.
* **Controller Layer (`DocumentController`):** Handles incoming HTTP requests, performs input validation, and routes traffic.
* **Service Layer (`DocumentService.java`):** Implements core business rules, filtering, and exception triggers.
* **Repository Layer (`DocumentRepository`):** Communicates with the H2 database using Spring Data JPA (`JpaRepository`).
* **Exception Layer (`GlobalExceptionHandler`):** Intercepts custom exceptions and standardizes HTTP error responses.

## 3. ER Diagram / Entity Description (`Document` Model)
* **Table Name:** `documents`
* **Columns:**
    * `id` (`Long`, Primary Key, Auto-increment)
    * `title` (`String`, Not Blank)
    * `category` (`String`, e.g., `SYLLABUS`, `HOSTEL`, `RULES`)
    * `content` (`String`, Description or structured syllabus text)