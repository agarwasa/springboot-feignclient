# Spring Boot Feign Client

This is a Spring Boot application built with Maven.

## Project Structure

```
.
├── pom.xml
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/springbootfeignclient/
│   │   │       └── SpringBootApplication.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/example/springbootfeignclient/
│               └── SpringBootApplicationTests.java
└── cursor.md
```

## Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher

### Running the Application

1. Build the project:
   ```bash
   mvn clean install
   ```

2. Run the application:
   ```bash
   mvn spring-boot:run
   ```

   Or run the JAR file:
   ```bash
   java -jar target/spring-boot-feignclient-1.0.0.jar
   ```

The application will start on `http://localhost:8080`

## Dependencies

- Spring Boot Starter Web
- Spring Boot Starter Test

## Configuration

Application properties can be configured in `src/main/resources/application.properties`

