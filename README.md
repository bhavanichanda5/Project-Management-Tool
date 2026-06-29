# Project-Management-Tool
Project Management Tool | Spring Boot, Java, Spring Security, Spring Data JPA, Hibernate, MySQL, REST APIs, Maven, Postman

A backend Project Management Tool built using Spring Boot that provides REST APIs for managing users, workspaces, projects, tasks, comments, attachments, and dashboard analytics. The application follows a layered architecture and uses Spring Security for secure user authentication.

🚀 Features
User Registration & Authentication
Secure password encryption using BCrypt
Workspace Management
Project Management
Space & Folder Management
Task List Management
Task Management
Comments on Tasks
File Attachments
Activity Logs
Dashboard Statistics
RESTful APIs
MySQL Database Integration
API Testing with Postman

🛠️ Tech Stack
Backend
Java 17+
Spring Boot
Spring Security
Spring Data JPA
Hibernate
Database
MySQL
Build Tool
Maven
Testing
Postman

📂 Project Structure
src
├── controller
├── service
├── repository
├── entity
├── dto
├── security
├── config
├── exception
└── util

The project follows a layered architecture:

Client
   │
Controller
   │
Service
   │
Repository
   │
Database

🗄️ Database Design

The application uses MySQL with JPA/Hibernate entity relationships.

Entity Relationships
User → Workspaces (One-to-Many)
Workspace → Projects (One-to-Many)
Project → Spaces (One-to-Many)
Space → Folders (One-to-Many)
Folder → Task Lists (One-to-Many)
Task List → Tasks (One-to-Many)
Task → Comments (One-to-Many)
Task → Attachments (One-to-Many)
User → Tasks (Assigned Tasks)

🔒 Security
Spring Security
BCrypt Password Encoder
Secure User Authentication
Protected REST APIs

📡 REST API Modules
Authentication
User Management
Workspace Management
Project Management
Space Management
Folder Management
Task List Management
Task Management
Comments
Attachments
Activity Logs
Dashboard Statistics

📊 Dashboard APIs

The dashboard provides statistics such as:

Total Projects
Total Tasks
Completed Tasks
Pending Tasks
Overdue Tasks
Task Status Summary
Project Insights

⚙️ Configuration

 application.properties file :

spring.datasource.url=jdbc:mysql://localhost:3306/clickup_db
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

▶️ Getting Started

Build the project:
mvn clean install

Run the application:
mvn spring-boot:run

The application will start at:
http://localhost:8080

🧪 API Testing
All REST APIs were tested using Postman.

Import the Postman collection from:
postman/My Collection.postman_collection.json

📌 Future Enhancements
Email Notifications
Role-Based Access Control (RBAC)
File Upload to AWS S3 or Cloudinary
Swagger/OpenAPI Documentation
Docker Support
CI/CD Pipeline
WebSocket Notifications

👨‍💻 Author
Bhavani Chanda

LinkedIn:
https://www.linkedin.com/in/bhavani-c-1ba3b93b9

GitHub:
https://github.com/bhavanichanda5
