"# event-driven-commerce" 


Overview:
A production-style event-driven e-commerce platform built using modern cloud-native technologies.

The goal of this project is to demonstrate:
- Microservices architecture
- Event-driven communication
- Secure API development
- Distributed system patterns
- Cloud deployment practices

## Architecture

The platform follows a microservices architecture.

Services:

- User Service
- Product Service
- Order Service
- Payment Service
- Inventory Service
- Notification Service

Communication:

- REST APIs for synchronous communication
- Apache Kafka for asynchronous event processing

## Tech Stack

### Backend
- Java 17
- Spring Boot 3.5
- Spring Security
- JWT Authentication
- Spring Data JPA

### Database
- PostgreSQL

### Messaging
- Apache Kafka

### Cache
- Redis

### Frontend
- Angular

### DevOps
- Docker
- Kubernetes

### Cloud
- AWS

## Repository Structure

event-driven-commerce

├── docs
│
├── infrastructure
│   └── docker-compose.yml
│
├── services
│   ├── user-service
│   ├── product-service
│   ├── order-service
│   └── payment-service
│
└── frontend

## Running Locally

### Start Infrastructure

Navigate:

infrastructure/

Run:

docker compose up -d


Services started:

- PostgreSQL
- Redis
- Kafka

## Run User Service

Navigate:

services/user-service


Build:

mvn clean package


Run:

mvn spring-boot:run

## APIs


### Register User

POST

/api/auth/register


Request:

{
 "email":"test@test.com",
 "password":"password123"
}



### Login

POST

/api/auth/login


Response:

{
 "token":"jwt-token"
}

## Security

Authentication implemented using:

- Spring Security
- JWT

Password storage:

- BCrypt hashing

Protected endpoints require:

Authorization: Bearer <token>

## Future Enhancements

- Product microservice
- Order processing workflow
- Kafka event-driven communication
- Saga pattern implementation
- Outbox pattern
- Redis caching
- Kubernetes deployment
- AWS deployment
- CI/CD pipeline

## Author

Software Engineer
Java | Spring Boot | Angular | AWS

## System Design Concepts Demonstrated
- Microservices architecture
- API security
- JWT authentication
- Event-driven architecture
- Distributed transactions
- Caching strategy
- Containerization
- Cloud deployment
