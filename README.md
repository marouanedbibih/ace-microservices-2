
# ACE Microservices 2 (RestTemplate)

## Table of Contents
1. [Introduction](#introduction)
2. [Features](#features)
3. [Technologies](#technologies)
4. [Project Structure](#project-structure)
5. [How to Run this Project](#how-to-run-this-project)
6. [License](#license)
7. [User Interfaces](#user-interfaces)

## Introduction

Ace Microservices 2 is a modern microservices-based project designed to handle various aspects of a multi-service application. This project utilizes Docker, Spring Boot, and React to provide a scalable and maintainable solution. The system is structured with multiple services, including car management, client management, an API Gateway, and a Eureka service for service discovery.

## Features

- **Microservices Architecture**: The project follows a microservices architecture, with each service handling a specific domain of functionality.
- **Service Discovery**: Uses Eureka for service discovery, allowing microservices to register and discover each other dynamically.
- **API Gateway**: The API Gateway service provides a single entry point for clients to interact with the system. It routes requests to appropriate backend services.
- **Dockerized**: All services are containerized using Docker, making it easy to deploy and scale the application.
- **MySQL Database**: The project uses MySQL as the primary database for storing client and car-related data.
- **React Frontend**: A React-based frontend that interacts with the backend APIs to provide a user-friendly interface for managing cars and clients.

## Technologies

- **Spring Boot**: Backend services are built using Spring Boot, providing a robust and scalable solution.
- **Eureka**: Service discovery is handled via Eureka.
- **Docker**: All services are containerized using Docker and managed with Docker Compose.
- **MySQL**: A relational database used to store persistent data.
- **React**: Frontend application built with React.
- **NGINX**: Used to serve the React application in production.
- **NPM**: Package manager for managing frontend dependencies.

## Project Structure

The project is organized into the following services and directories:

- **car**: Handles car-related operations and API endpoints.
- **client**: Manages client data and interactions.
- **docker**: Contains Docker-related configurations, including the entrypoint script and Docker Compose configurations.
- **eureka**: Service discovery using Eureka.
- **gateway**: The API Gateway that routes requests to the appropriate microservices.
- **web**: The React frontend application.

Additionally, there is a `compose.yml` file that sets up all the services in a Docker environment.

```plaintext
ace-microservices-2/
├── car/
├── client/
├── docker/
├── eureka/
├── gateway/
├── web/
├── docker-compose.yml
└── README.md
```

## How to Run this Project

### Requirements

- Docker
- Docker Compose
- Java (for Spring Boot services)

### Steps

1. Clone the repository:
   ```bash
   git clone https://github.com/marouanedbibih/ace-microservices-2.git
   cd ace-microservices-2
   ```

2. Build and start the application using Docker Compose:
   ```bash
   docker compose up --build
   ```

   This will build and start all the services defined in the `compose.yml` file, including MySQL, Eureka, Gateway, and the backend services.

3. Access the application:
   - **Frontend**: Open your browser and navigate to `http://localhost:5174`.
   - **Eureka Dashboard**: Access the Eureka dashboard at `http://localhost:8761` to see the registered services.

4. Optionally, if you want to stop the services, run:
   ```bash
   docker compose down
   ```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## User Interface
The application provides a clean and user-friendly interface for both admins and users. Below are some key screenshots of the application:

### Delete Interface

<image src="./demo/delete.png">

### Form Interface

<image src="./demo/form.png">

### List Interface

<image src="./demo/list.png">

### Eureka
<image src="./demo/eureka.png">
