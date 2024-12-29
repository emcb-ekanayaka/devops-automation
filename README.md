# Inventory CRUD Operation

This repository contains a **Java-based Inventory Management System** that supports CRUD (Create, Read, Update, Delete) operations. It utilizes **Jenkins** and **Docker** to automate the CI/CD pipeline for efficient building, testing, and deployment.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Installation and Setup](#installation-and-setup)
- [Endpoints](#endpoints)
- [CI/CD Pipeline](#ci-cd-pipeline)
- [Future Enhancements](#future-enhancements)
- [License](#license)

---

## Features

- CRUD operations for managing inventory data.
- Automated CI/CD pipeline with Jenkins and Docker.
- Containerized application for deployment.
- Compatible with Java 17.

---

## Technologies Used

- **Java 17**: Backend development.
- **Maven**: Build and dependency management.
- **Jenkins**: Continuous Integration and Continuous Deployment.
- **Docker**: Containerization for seamless deployment.

---

## Prerequisites

Ensure the following are installed on your machine:
- **Java 17** or higher
- **Maven**
- **Docker**
- **Jenkins**

---

## Installation and Setup

### Step 1: Clone the Repository
```bash
git clone <repository-url>
cd inventory-crud-operation


Docker.

Docker Hub
ekanayakabdr1998
199800610155Vv

Jenkins
ekanayaka199801
199800610155@Vv


// Docker Commands
ls
cat Dockerfile
mvn clean package or mvn clean install -DskipTests
ls target/
docker login
docker build -t devops-integration:1.0 .
docker images
docker ps
docker tag a211b5a4861c ekanayakabdr1998/devops-integration:latest
docker push ekanayakabdr1998/devops-integration:latest

//run docker
docker run -d -p 8001:8001 ekanayakabdr1998/devops-integration:latest

//To install Maven to Spring Boot Project
mvn -v
mvn clean install

// Remove Docker image/Container
docker rmi -f <tag>
docker rm <tag>

//Docker Stop
docker stop practical_wing
docker rm practical_wing

// NGROK tp get public IP
https://dashboard.ngrok.com/get-started/setup/windows
https://dashboard.ngrok.com/get-started/your-authtoken
ngrok http 8080


Change the Webhooks with generated URL
