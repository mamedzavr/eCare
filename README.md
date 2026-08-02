# eCare

Telecom self-care web app: clients, contracts, tariffs, and options with admin and customer flows.

## Stack

- Java 11
- Spring Boot 2.5 (Web, Data JPA/JDBC, Security, HATEOAS)
- Thymeleaf templates
- Google OAuth2 login
- Maven Wrapper

## Features

- Client / contract / tariff / option management
- Admin and home controllers
- Cart-oriented contract options
- Role-based security (`SecurityConfig`)

## Run

```bash
./mvnw spring-boot:run
```

Configure datasource and OAuth credentials in `src/main/resources/application.properties`. SQL helpers live under `sql/`.
