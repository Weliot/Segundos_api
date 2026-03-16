# Segundos API - Backend Documentation

## Overview

**Segundos API** is a Spring Boot REST API designed to manage study sessions, subjects, materials, and exam questions. The application provides a comprehensive platform for tracking learning progress, study time, and question performance across different subjects and materials.

This is a backend service that supports a frontend application (React/Frontend) running on `localhost:3000` for study management and progress tracking.

## Key Features

- ✅ User authentication and management with JWT tokens
- ✅ Material (Subject Area) management
- ✅ Topic/Subject management under materials
- ✅ Question tracking with success/failure metrics
- ✅ Study time tracking
- ✅ Access control and authorization
- ✅ RESTful API with Swagger documentation
- ✅ CORS support for frontend integration
- ✅ Data persistence with H2 Database

---

## Technologies Stack

### Core Framework
- **Spring Boot 3.5.4** - Java-based web framework for building REST APIs
- **Java 21** - Programming language
- **Maven** - Dependency management and build tool

### Database & ORM
- **H2 Database** - In-memory relational database for development/testing
- **Spring Data JPA** - Object-Relational Mapping (ORM) framework
- **Hibernate** - JPA implementation for database interactions

### API Documentation & Swagger
- **SpringDoc OpenAPI** (v2.8.8) - Generates OpenAPI/Swagger documentation
- **Swagger UI** - Interactive API documentation interface

### Security & Authentication
- **Spring Security** - Framework for authentication and authorization
- **JJWT** (v0.12.6) - JWT (JSON Web Token) library for token-based authentication
- **JWT Secret** - Token encryption and validation

### Validation & Utilities
- **Spring Validation** - Data validation framework
- **Lombok** - Java library to reduce boilerplate code
- **MySQL Connector** - Support for MySQL database (can be used instead of H2)

### Testing
- **JUnit 5 (Jupiter)** - Unit testing framework
- **Spring REST Docs** - REST API documentation with tests

### Development Tools
- **Spring DevTools** - Hot reload and development features
- **Spring Configuration Processor** - Metadata processing for configuration properties

---

## Project Architecture

### Layered Architecture

The application follows a **three-layer architecture pattern**:

```
┌─────────────────────────────────────────┐
│         REST Controllers                 │
│    (HTTP Request/Response Layer)         │
└──────────────────┬──────────────────────┘
                   │
┌──────────────────▼──────────────────────┐
│         Service Layer                    │
│    (Business Logic & Validations)        │
└──────────────────┬──────────────────────┘
                   │
┌──────────────────▼──────────────────────┐
│   Repository Layer (Data Access)        │
│    (Spring Data JPA Repositories)       │
└──────────────────┬──────────────────────┘
                   │
┌──────────────────▼──────────────────────┐
│       Database (H2 In-Memory)            │
│        (Data Persistence)                │
└─────────────────────────────────────────┘
```

### Key Components

1. **Controllers** - Handle HTTP requests and responses
2. **Services** - Contain business logic and domain operations
3. **Repositories** - Interface with the database
4. **DTOs (Data Transfer Objects)** - Transfer data between layers
5. **Mappers** - Convert between entities and DTOs
6. **Models/Entities** - Database entity representations
7. **Configuration** - CORS, Swagger, Web configuration

---

## Project Structure

```
src/main/
├── java/com/example/segundos_api/
│   ├── SegundosApiApplication.java       # Main Spring Boot application entry point
│   │
│   ├── config/                           # Configuration classes
│   │   ├── CorsConfig.java              # CORS configuration
│   │   ├── SwaggerConfig.java           # Swagger/OpenAPI documentation
│   │   └── WebConfig.java               # Web configuration
│   │
│   ├── controller/                       # REST API Controllers
│   │   ├── UserController.java          # User management endpoints
│   │   ├── MateriaController.java       # Material management endpoints
│   │   ├── AssuntoController.java       # Subject/Topic endpoints
│   │   ├── QuestaoController.java       # Question tracking endpoints
│   │   ├── TempoController.java         # Study time endpoints
│   │   └── AcessoController.java        # Authentication/Access control
│   │
│   ├── service/                          # Business Logic Layer
│   │   ├── UserService.java             # User operations
│   │   ├── MateriaService.java          # Material operations
│   │   ├── AssuntoService.java          # Subject operations
│   │   ├── QuestaoService.java          # Question operations
│   │   ├── TempoService.java            # Study time operations
│   │   ├── AcessoService.java           # Authentication logic
│   │   ├── JwtTokenService.java         # JWT token generation/validation
│   │   └── impl/                        # Service implementations
│   │
│   ├── repository/                       # Data Access Layer (Spring Data JPA)
│   │   ├── UserRepository.java
│   │   ├── MateriaRepository.java
│   │   ├── AssuntoRepository.java
│   │   ├── QuestaoRepository.java
│   │   └── TempoRepository.java
│   │
│   ├── model/                            # Entity Classes (JPA Entities)
│   │   ├── User.java
│   │   ├── Materia.java
│   │   ├── Assunto.java
│   │   ├── Questao.java
│   │   ├── Tempo.java
│   │   └── ...
│   │
│   ├── dto/                              # Data Transfer Objects
│   │   ├── UserMapper.java              # User DTOs mapper
│   │   ├── MateriaMapper.java           # Material DTOs mapper
│   │   ├── AssuntoMapper.java           # Subject DTOs mapper
│   │   ├── QuestaoMapper.java           # Question DTOs mapper
│   │   ├── TempoMapper.java             # Study time DTOs mapper
│   │   ├── request/                     # Request DTOs (input)
│   │   │   ├── UserRequest.java
│   │   │   ├── MateriaRequest.java
│   │   │   ├── AssuntoRequest.java
│   │   │   ├── QuestaoRequest.java
│   │   │   └── TempoRequest.java
│   │   └── response/                    # Response DTOs (output)
│   │       ├── UserResponse.java
│   │       ├── MateriaResponse.java
│   │       ├── AssuntoResponse.java
│   │       ├── QuestaoResponse.java
│   │       └── TempoResponse.java
│   │
│   ├── exception/                        # Custom Exceptions
│   │   └── ...
│   │
│   └── enums/                            # Enumerations
│       └── ...
│
└── resources/
    ├── application.properties             # Main configuration
    ├── data.sql                          # Initial SQL data
    └── META-INF/
        └── additional-spring-configuration-metadata.json
```

---

## Database Schema

The application manages 5 main entities with the following relationships:

### Entity Relationships

```
┌─────────────┐
│    User     │
│  (tsec_users)│
└──────┬──────┘
       │ 1:N
       │
       ├──────────────────┬──────────────┬──────────────┐
       │                  │              │              │
       ▼                  ▼              ▼              ▼
   ┌────────────┐   ┌────────────┐ ┌──────────┐ ┌────────────────┐
   │  Materia   │   │  Questao   │ │  Assunto │ │  Tempo Estudo  │
   │(tsec_      │   │(tsec_      │ │(tsec_    │ │ (tsec_tempos)  │
   │materias)   │   │questoes)   │ │assuntos) │ └────────────────┘
   └─────┬──────┘   └────────────┘ └────┬─────┘
         │               │               │
         │ 1:N           │ 1:N          │ 1:N
         │               │              │
         └───────────────┴──────────────┘
                 Assunto (Subject)
                   (1:N relation)
```
---

### CORS Configuration

CORS is configured to allow requests from the frontend application:
- **Allowed Origins**: `http://localhost:3000`
- **Allowed Methods**: GET, POST, PUT, DELETE
- **Allowed Headers**: All (*)
- **Allow Credentials**: Yes
- **Max Age**: 3600 seconds

---

## Getting Started

### Prerequisites

- **Java 21** or higher
- **Maven 3.6+** (or use `mvnw` provided)
- **Git**

### Installation & Setup

1. **Clone the repository**
```bash
git clone <repository-url>
cd segundos-back/segundos-api
```

2. **Build the project**
```bash
./mvnw clean install
```

On Windows:
```bash
mvnw.cmd clean install
```

3. **Run the application**
```bash
./mvnw spring-boot:run
```

On Windows:
```bash
mvnw.cmd spring-boot:run
```

The application will start on `http://localhost:8080`

---

## Accessing Documentation & Tools

### 1. **Swagger UI (API Documentation)**
```
http://localhost:8080/swagger-ui.html
```
Interactive API documentation where you can test all endpoints.

### 2. **API Docs (OpenAPI JSON)**
```
http://localhost:8080/api-docs
```

### 3. **H2 Database Console**
```
http://localhost:8080/h2-console
```
Default credentials:
- **Username**: sa
- **Password**: (leave empty)
- **JDBC URL**: jdbc:h2:mem:segundos

---

## Development Features

### Hot Reload
The application includes Spring DevTools for hot reload:
- Code changes are automatically reloaded during development
- No need to restart the application manually

### Database Console
H2 Database Console is enabled for development:
- Visual inspection of database data
- Execute SQL queries directly
- Monitor database state in real-time

### SQL Logging
Hibernate SQL logging is enabled to see executed queries:
```
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## Testing

Run unit tests:
```bash
./mvnw test
```

The project includes:
- **JUnit 5** for unit testing
- **Spring Test** for integration testing
- **Spring REST Docs** for API documentation tests

---

## Troubleshooting

### Port Already in Use
If port 8080 is already in use, change it in `application.properties`:
```properties
server.port=8081  # or any other available port
```

### Database Connection Errors
For H2 database issues:
1. Clear Maven cache: `./mvnw clean`
2. Check H2 console at `http://localhost:8080/h2-console`
3. Verify JDBC URL: `jdbc:h2:mem:segundos`

### JWT Token Validation Failure
- Ensure token is included in request headers
- Check token hasn't expired (1 hour default)
- Verify JWT secret in configuration matches

---

## Project Information

- **Project Name**: Segundos API
- **Version**: 0.0.1-SNAPSHOT
- **Java Version**: 21
- **Spring Boot Version**: 3.5.4
- **Status**: Active Development

---
