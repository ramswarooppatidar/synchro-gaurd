# Java Spring Boot Project - Memory Management, Deadlock Prevention, and Multithreading


## Introduction
This Spring Boot project implements solutions for common backend system challenges such as memory management, deadlock prevention, concurrency handling (multithreading), and session management. Additionally, it optimizes database connection pooling using HikariCP.

The project serves as a foundation for handling these complex issues in a scalable, high-performance application architecture.

## Features
- **Session Management**: Proper session synchronization across microservices and thread safety.
- **Concurrency and Multithreading**: Implements the Producer-Consumer problem with task prioritization using thread pools and priority queues.
- **Memory Management**: Detects and resolves memory leaks with optimized session handling and caching mechanisms.
- **Deadlock Prevention**: Implements deadlock detection and avoidance strategies in a multi-threaded environment.
- **Database Connection Pooling**: Uses HikariCP to manage and optimize database connections.

## Technologies Used
- Java 17+
- Spring Boot 3.x
- HikariCP for connection pooling
- MySQL for database
- Maven for project build management

## Project Structure
