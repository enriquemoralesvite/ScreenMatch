![Programação-Java_ Persistencia de datos y consultas con Spring Data JPA](https://github.com/genesysR-dev/2066-java-persitencia-de-datos-y-consultas-con-Spring-JPA/assets/91544872/e0e3a9f8-afc7-4e7b-be83-469351ef2d70)

# ScreenMatch

Proyecto desarrollado durante el segundo curso de la formación Avanzando con Java de Alura

## 🔨 Objetivos del proyecto

* Avanzar en el proyecto Screenmatch, iniciado en el primer curso de la formación, creando un menú con varias opciones;
* Modelar las abstracciones de la aplicación a través de clases, enums, atributos y métodos;
* Consumir la API del ChatGPT(Opcional;
* Utilizar Spring Data JPA para persistir datos en la base de datos;
* Conocer varios tipos de bases de datos y utilizar PostgreSQL;
* Trabajar con varios tipos de consultas a la base de datos;
* Profundizar en la interfaz JPA Repository.

# ScreenMatch

A lightweight Spring Boot console application that lets you search for TV series and episodes via an external API, persist your search history in a PostgreSQL database, and translate text into Spanish using Google’s Gemini API.

---

## Table of Contents

1. [Features](#features)  
2. [Tech Stack](#tech-stack)  
3. [Prerequisites](#prerequisites)  
4. [Getting Started](#getting-started)  
5. [Usage](#usage)  
6. [Database Reset](#database-reset)  
7. [Configuration](#configuration)  
8. [Contributing](#contributing)  
9. [License](#license)  
10. [Contact](#contact)

---

## Features

- **Series Search**: Query an external TV series API by name and view basic metadata.  
- **Episode Search**: List all episodes for a selected series.  
- **History Persistence**: Store every series search in a PostgreSQL table via Spring Data JPA.  
- **Translation**: Translate any text to Spanish through the Gemini API.  
- **Sequence Reset**: Reset your database sequence counter on demand.  
- **Interactive Menu**: Simple console menu driven by Spring’s `CommandLineRunner`.

---

## Tech Stack

- **Language**: Java 17  
- **Framework**: Spring Boot 3.2 (CommandLineRunner + Spring Data JPA)  
- **HTTP Client**: Java 11’s `java.net.http.HttpClient`  
- **JSON**: Jackson  
- **Database**: PostgreSQL  
- **AI Service**: Google Gemini API  
- **Build Tool**: Maven

---

## Prerequisites

- Java 17 or newer  
- Maven 3.6+  
- PostgreSQL 12+  
- A Gemini API key

---

## Getting Started

1. **Clone the repository**  
   ```bash
   git clone https://github.com/your-username/screenmatch.git
   cd screenmatch
   ```

2. **Configure your database & API key**  
   Edit `src/main/resources/application.properties` (or `application.yml`):

   ```properties
   # PostgreSQL
   spring.datasource.url=jdbc:postgresql://localhost:5432/screenmatch_db
   spring.datasource.username=postgres
   spring.datasource.password=your_password

   # Gemini API
   gemini.api.key=YOUR_GEMINI_API_KEY
   ```

3. **Build & run**
   ```bash
   mvn clean package
   mvn spring-boot:run
   ```

## Usage

When the application starts, you’ll see a console menu:

```pgsql
1 - Search for series
2 - Search for episodes
3 - Show searched series history
0 - Exit
```

**Search for series**  
Enter a series name.  
The app calls an external API, converts the JSON into Java objects, displays the series, and saves it to PostgreSQL.

**Search for episodes**  
Choose one of your previously searched series (by its ID).  
The app fetches and displays all episodes for that series.

**Show searched series history**  
Displays all stored `Serie` records, sorted by genre.

**Exit**  
Terminates the application.

## Configuration

All properties live in `src/main/resources/application.properties`:

```properties
# PostgreSQL
spring.datasource.url=jdbc:postgresql://localhost:5432/screenmatch_db
spring.datasource.username=postgres
spring.datasource.password=your_password

# JPA DDL
spring.jpa.hibernate.ddl-auto=update

# Gemini API
gemini.api.key=YOUR_GEMINI_API_KEY

# Initialize DB on startup
spring.datasource.initialization-mode=always
```

## Contributing

- Fork the repository.  
- Create your feature branch (`git checkout -b feature/YourFeature`).  
- Commit your changes (`git commit -m "Add some feature"`).  
- Push to the branch (`git push origin feature/YourFeature`).  
- Open a pull request.
