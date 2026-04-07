# Quiz Application - Microservices Architecture

## 📌 Overview
This project is a **Quiz Application** built using **Spring Boot Microservices Architecture**.  
It is designed with multiple independent services that communicate with each other to provide a scalable and modular backend system.

---

## 🏗️ Architecture

The system consists of the following microservices:

- **Service Registry (Eureka Server)**  
  Handles service registration and discovery.

- **API Gateway**  
  Acts as a single entry point and routes requests to appropriate services.

- **Question Service**  
  Manages quiz questions (CRUD operations).

- **Quiz Service**  
  Creates quizzes and calculates results.

---

## ⚙️ Tech Stack

- Java
- Spring Boot
- Spring Cloud
- Eureka Server
- API Gateway
- REST APIs
- PostgreSql
- Maven

---

## 🔄 Microservices Communication

- Services are registered with **Eureka**
- API Gateway handles routing
- Services communicate using **REST APIs**

---

## ▶️ How to Run the Project

Start services in the following order:

1. **service-registry**
2. **api-gateway**
3. **question-service**
4. **quizService**

---

## 🧪 API Testing

You can test APIs using:
- Postman

---

## 🚀 Features

- Microservices-based architecture
- Service discovery using Eureka
- Centralized API routing
- Modular and scalable backend design

---

## 👨‍💻 Author

**Narendran Mukesh**
