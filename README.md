# Spring Boot Feign Client

A Spring Boot application demonstrating how to use Feign clients for making REST API calls. This project provides a complete example of integrating Spring Cloud OpenFeign to consume external REST APIs declaratively.

## Overview

This project showcases:
- **Feign Client Integration**: Declarative HTTP client for external API calls
- **Layered Architecture**: Controller → Service → Feign Client pattern
- **REST API Endpoints**: Exposes endpoints that consume external APIs
- **Type-Safe API Calls**: Compile-time checking with automatic JSON serialization/deserialization

## Project Structure

```
.
├── pom.xml
├── README.md
├── FEIGN_CLIENT_GUIDE.md          # Detailed Feign client learning guide
├── .cursorrules.md                 # Cursor AI rules
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/springbootfeignclient/
│   │   │       ├── Application.java              # Main class with @EnableFeignClients
│   │   │       ├── client/
│   │   │       │   └── UserClient.java           # Feign client interface
│   │   │       ├── controller/
│   │   │       │   └── UserController.java       # REST controller
│   │   │       ├── model/
│   │   │       │   └── User.java                 # Data model/DTO
│   │   │       └── service/
│   │   │           └── UserService.java          # Service layer
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/example/springbootfeignclient/
│               └── ApplicationTests.java
└── target/                         # Build output (excluded from git)
```

## Features

- ✅ **Feign Client**: Declarative HTTP client interface
- ✅ **REST API Integration**: Consumes JSONPlaceholder API
- ✅ **Automatic JSON Handling**: No manual serialization needed
- ✅ **Type-Safe**: Compile-time checking of API contracts
- ✅ **Spring Boot Integration**: Seamless dependency injection
- ✅ **Layered Architecture**: Clean separation of concerns

## Prerequisites

- **Java 17** or higher
- **Maven 3.6** or higher
- Internet connection (for external API calls)

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/agarwasa/springboot-feignclient.git
cd springboot-feignclient
```

### 2. Build the Project

```bash
mvn clean install
```

### 3. Run the Application

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

### 4. Alternative: Run JAR File

After building, you can run the JAR directly:

```bash
java -jar target/spring-boot-feignclient-1.0.0.jar
```

## API Endpoints

Once the application is running, you can test the following endpoints:

### Get All Users
```bash
curl http://localhost:8080/api/users
```

### Get User by ID
```bash
curl http://localhost:8080/api/users/1
```

### Search Users by Name
```bash
curl "http://localhost:8080/api/users/search?name=Leanne"
```

## Dependencies

- **Spring Boot Starter Web** - Web framework
- **Spring Cloud OpenFeign** - Feign client integration
- **Spring Boot Starter Test** - Testing framework

See `pom.xml` for complete dependency list.

## How It Works

1. **Feign Client Interface** (`UserClient.java`): Defines the external API contract using annotations
2. **Service Layer** (`UserService.java`): Uses the Feign client and adds business logic
3. **Controller** (`UserController.java`): Exposes REST endpoints that use the service
4. **Model** (`User.java`): Data transfer objects for API responses

For detailed explanation, see [FEIGN_CLIENT_GUIDE.md](FEIGN_CLIENT_GUIDE.md)

## Configuration

Application properties can be configured in `src/main/resources/application.properties`:

```properties
server.port=8080
spring.application.name=spring-boot-feignclient
```

### Feign Client Configuration (Optional)

You can add Feign-specific configuration:

```properties
# Connection timeout
feign.client.config.default.connectTimeout=5000
feign.client.config.default.readTimeout=10000

# Enable logging
logging.level.com.example.springbootfeignclient.client=DEBUG
```

## External API

This project uses [JSONPlaceholder](https://jsonplaceholder.typicode.com), a free fake REST API for testing and prototyping.

## Learning Resources

- **[FEIGN_CLIENT_GUIDE.md](FEIGN_CLIENT_GUIDE.md)**: Comprehensive guide on Feign clients, including:
  - What Feign is and why to use it
  - How Feign works internally
  - Request flow sequence diagrams
  - Configuration options
  - Best practices

## Project Status

✅ **Complete**: All core features implemented
- Feign client integration
- REST endpoints
- Service layer
- Unit tests (Service and Controller layers)
- Documentation

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is open source and available for learning purposes.

## Author

Created as a learning project to understand Spring Boot Feign clients.

## Acknowledgements

This project was developed with the assistance of AI-powered development tools. The majority of the code implementation, architectural design, and documentation were created using Cursor, powered by advanced language models (including Claude and GPT-4). This AI-assisted development significantly accelerated the development process and helped ensure best practices in Spring Boot and Feign client integration. Additionally, the use of these AI tools served as a valuable learning experience and practice opportunity for modern software development workflows that incorporate AI-assisted coding techniques.

---

**Happy Learning! 🚀**

