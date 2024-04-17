----------------------------------------------------
##Library Management System API using Spring Boot###
----------------------------------------------------

# Check out sources

git clone https://github.com/AungKoLin828/LibraryManagementSystem.git

# Install all spring-\* jars into your local Maven cache

mvn install

-------------------------------------------------------------------------------------
# PostgresSQL Database Setup

1.Create "library" login role with passowrd is "library"

2.Create "library_db" database and schema with owner "library"

3.Run Script  [create_sql.sql] file from following 

  https://github.com/AungKoLin828/LibraryManagementSystem/tree/main/src/main/resources/postgresql

-----------------------------------------------------------------------------------------
# Project Description

Building a Library Management System API using Spring Boot. The system allow librarians
to manage books, patrons, and borrowing records.

# Entities Class

● Book: Includes attributes like ID, title, author, publication year, ISBN, etc.

● Patron: Contains details like ID, name, contact information, etc.

● Borrowing Record: Tracks the association between books and patrons,
  including borrowing and return dates.
  
# API Endpoints

● Implement RESTful endpoints to handle the following operations:

# Book management endpoints:

● GET /api/books/all-books: Retrieve a list of all books.

● GET /api/books/{id}: Retrieve details of a specific book by ID.

● POST /api/books/add: Add a new book to the library.

● PUT /api/books/update: Update an existing book's information.

● DELETE /api/books/{id}: Remove a book from the library.

# Patron management endpoints:

● GET /api/patrons/all-patrons: Retrieve a list of all patrons.

● GET /api/patrons/{id}: Retrieve details of a specific patron by ID.

● POST /api/patrons/add: Add a new patron to the system.

● PUT /api/patrons/update: Update an existing patron's information.

● DELETE /api/patrons/{id}: Remove a patron from the system.

# Borrowing endpoints:
● POST /api/borrow/{bookId}/patron/{patronId}: Allow a patron to
borrow a book.

● PUT /api/return/{bookId}/patron/{patronId}: Record the return of a borrowed book by a patron.

# Data Storage

● PostgreSQL

# Validation and Error Handling:
● Implement input validation for API requests (e.g., validating required fields, data formats, etc.).

● Handle exceptions gracefully and return appropriate HTTP status codes and error messages.

# Transaction Management

● Implement declarative transaction management using Spring's @Transactional annotation to ensure data integrity during critical operations.

# Testing

● Unit tests to validate the functionality of API endpoints.

● Using testing frameworks like JUnit, Mockito, SpringBootTest for testing.

# ERD
![ERD](https://github.com/AungKoLin828/LibraryManagementSystem/assets/61590535/bbe2e825-d851-410c-99eb-4a5b07473803)



