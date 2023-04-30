# Book Management System — Spring Boot & Thymeleaf

A web application built with **Java**, **Spring Boot**, **Spring Data JPA**, and **Thymeleaf** for managing a bookstore or library inventory. Users can register new books, browse available titles, add books to their personal "My Books" collection, and manage inventory.

---

## What It Does

- **Register Books (`/book_register`)**: Form to add new books to the database with a title, author name, and price.
- **Browse Catalog (`/available_books`)**: View all books currently in inventory with actions to delete or add to your personal shelf.
- **Personal Shelf (`/my_books`)**: A dedicated view showing the books you have selected for your own reading list.
- **One-Click Actions**:
  - Click "Add to My Books" on any catalog item to save a copy to your personal collection.
  - Remove items from your personal list without deleting them from the general store catalog.
  - Delete books from the catalog when they are out of stock.

---

## Tech Stack

- **Language**: Java 19 (compatible with Java 17+)
- **Framework**: Spring Boot 3 (Spring Web, Spring Data JPA, Thymeleaf)
- **Database**: Microsoft SQL Server (MSSQL via `mssql-jdbc` and Hibernate)
- **UI & Views**: Thymeleaf server-rendered templates, Bootstrap
- **Build Tool**: Maven (`mvnw`)

---

## Project Structure

```text
book-management-system/
├── src/main/java/com/iamjunaidjutt/bookmanagement/
│   ├── controller/
│   │   └── BookController.java         # Web endpoints for catalog and personal list
│   ├── entity/
│   │   ├── Book.java                   # General catalog book entity
│   │   └── myBooks.java                # User personal shelf book entity
│   ├── repository/
│   │   ├── BookRepository.java         # Spring Data JPA catalog repository
│   │   └── myBooksRepository.java      # Spring Data JPA personal shelf repository
│   ├── service/
│   │   ├── BookService.java            # Business logic for catalog operations
│   │   └── myBooksService.java         # Business logic for personal collection
│   └── BookmanagementApplication.java  # Main Spring Boot entry point
├── src/main/resources/
│   ├── application.properties          # Database connection settings
│   └── templates/
│       ├── home.html                   # Landing page
│       ├── bookRegister.html           # Add new book form
│       ├── availableBooks.html         # Store catalog table
│       └── myBooks.html                # Personal reading shelf table
├── pom.xml
└── README.md
```

---

## How to Run It Locally

### Prerequisites

- **Java JDK 17** or **JDK 19**
- **Microsoft SQL Server** (local Express edition or cloud instance)
- **Maven** (or use the included `./mvnw` script)

---

### 1. Database Configuration

You can configure your database either by setting environment variables or by updating `src/main/resources/application.properties`.

**Option A: Using Environment Variables**
```bash
export Data_Source="jdbc:sqlserver://localhost\\sqlexpress;databaseName=bookdb;encrypt=true;trustServerCertificate=true;"
export User_Name="your_db_username"
export Password="your_db_password"
```

**Option B: In `src/main/resources/application.properties`**
```properties
spring.datasource.url=jdbc:sqlserver://localhost\\sqlexpress;databaseName=bookdb;encrypt=true;trustServerCertificate=true;
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 2. Start the Application

In your terminal, run:

```bash
# On Linux / macOS:
./mvnw spring-boot:run

# On Windows:
mvnw.cmd spring-boot:run
```

Open `http://localhost:8080` in your web browser to start managing books.

---

## License

This project is licensed under the [MIT License](LICENSE).
