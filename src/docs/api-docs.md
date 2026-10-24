# 🔌 CampusCompass - API Documentation & Endpoints Specification

## Base URL
`http://localhost:8083/api/documents`

## Endpoints Table

| Method | Endpoint | Request Body (JSON) | Response Type | Description / Status Codes |
| :--- | :--- | :--- | :--- | :--- |
| **GET** | `/api/documents` | None | `JSON Array` | Retrieves all records. Returns `200 OK`. |
| **GET** | `/api/documents?category=...` | None | `JSON Array` | Filters documents by category (e.g., `SYLLABUS`). Returns `200 OK`. |
| **GET** | `/api/documents/{id}` | None | `JSON Object` | Retrieves a document by unique ID. Throws `404 Not Found` if ID is missing. |
| **POST** | `^/api/documents` | `{"title": "...", "category": "...", "content": "..."}` | `JSON Object` | Creates and saves a new document. Returns `201 Created`. |
| **PUT** | `/api/documents/{id}` | `{"title": "...", "category": "...", "content": "..."}` | `JSON Object` | Updates an existing document record. Returns `200 OK`. |
| **DELETE**| `/api/documents/{id}` | None | `HTTP 204` | Deletes a document by ID. Returns `204 No Content` or `404 Not Found`. |