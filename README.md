# Job Portal Backend Application

A backend REST API for a Job Portal system developed using **Spring Boot**. The application focuses on secure authentication, role-based authorization, and clean API design following industry best practices.

##  Key Highlights

* Secure user registration and login
* JWT-based authentication
* Role-based access control (USER / ADMIN)
* Spring Security integration
* Centralized exception handling
* Request validation with meaningful error responses
* Swagger UI for API exploration and testing

##  Technologies Used

* Java
* Spring Boot
* Spring Security
* JWT (JSON Web Token)
* Spring Data JPA
* MySQL Database
* Maven
* Swagger / OpenAPI

##  Package Overview
```
com.pallavi.jobportal
│
├── controller   → REST controllers
├── service      → Business logic
├── repository   → Database access
├── dto          → Request & response objects
├── entity       → JPA entities
├── security     → JWT & security configuration
├── exception    → Global exception handling
└── JobPortalApplication.java
```

##  Authentication & Security Flow

1. User signs up using the signup API
2. User logs in with valid credentials
3. Server generates a JWT access token
4. Client sends the token in request headers

```
Authorization: Bearer <JWT_TOKEN>
```

5. JWT filter validates the token for secured endpoints


##  Role-Based Authorization

* **USER**: Can view job listings
* **ADMIN**: Can create, update, and delete jobs

Authorization is enforced using Spring Security rules.


##  Exception Handling

Implemented using `@ControllerAdvice` for centralized handling:

* 400 – Validation errors
* 401 – Unauthorized access
* 404 – Resource not found
* 405 – Method not allowed
* 500 – Internal server errors

All errors are returned in a consistent JSON format.


##  Swagger API Documentation

Swagger UI is enabled for easy API testing:

```
http://localhost:8080/swagger-ui/index.html
```

JWT token can be passed using the **Authorize** button.


##  Running the Application

1. Clone the repository
2. Configure database details in `application.properties`
3. Run the project using:

```bash
mvn spring-boot:run
````

##  Testing APIs

1. Register a user
2. Login and copy the JWT token
3. Authorize in Swagger
4. Access secured APIs

##  Future Improvements

* Refresh token implementation
* Pagination and sorting
* Advanced job search
* Deployment using Docker or cloud platforms

## 👩‍💻 Developer

Pallavi Kattimani

Java Backend Developer | Spring Boot
