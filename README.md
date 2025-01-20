# Streaming API

This project demonstrates a **Streaming API** using **Spring Boot**, **WebSockets**, and **Spring WebFlux**. It integrates with an external service to showcase various data retrieval methods and WebSocket-based streaming.

---

## Features

- **WebSockets**: Real-time communication using STOMP over WebSocket.
- **Spring WebFlux**: Non-blocking reactive programming for high-performance data streaming.
- **Integration**: Connects to an external service to fetch and process data.
- **Swagger/OpenAPI**: Interactive API documentation with Swagger UI.
- **Dynamic Configuration**: Environment-based configuration for the external service URL and server port.

---

## Requirements

- **Java**: 17+
- **Maven**: 3.8+
- **Spring Boot**: 3.4.1

---

## Getting Started

### 1. Clone the Repository

```bash
git clone <repository-url>
cd streaming-api
```

### 2. Set Up Configuration

#### Application Properties

Configure the `application.properties` or `application.yml` file:

```properties
server.port=8081
service.url=http://external-service-url
```

Alternatively, set these values as environment variables:

```bash
export SERVER_PORT=8081
export SERVICE_URL=http://external-service-url
```

### 3. Build and Run the Application

#### Using Maven

```bash
mvn clean install
mvn spring-boot:run
```

#### Running the JAR

```bash
java -jar target/streaming-api-0.0.1-SNAPSHOT.jar
```

---

## API Endpoints

### REST Endpoints

#### Data Retrieval

- **GET** `/api/streaming/data`

  - Fetch data from the external service.

- **GET** `/api/streaming/parallel-data`

  - Make three parallel calls to fetch data from the external service.

- **GET** `/api/streaming/stream-data`

  - Stream multiple chunks of data, including fetched data from the external service.

#### WebSocket

- **Endpoint**: `/ws`
- **Send**: `/app/ws-message`
  - Process messages sent to the server.
- **Subscribe**: `/topic/updates`
  - Receive real-time updates from the server.

### Swagger UI

- **Swagger UI**: [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html)

---

## WebSocket Client Example

### Using JavaScript

```javascript
const socket = new SockJS('/ws');
const stompClient = Stomp.over(socket);

stompClient.connect({}, () => {
    // Subscribe to topic
    stompClient.subscribe('/topic/updates', (message) => {
        console.log('Received:', message.body);
    });

    // Send a message
    stompClient.send('/app/ws-message', {}, 'Hello WebSocket!');
});
```

---

## Project Structure

### Core Components

- **`DataRetrievalService`**:
  Handles communication with the external service.

- **`StreamingController`**:
  Provides REST endpoints for data retrieval and streaming.

- **`WebSocketController`**:
  Manages WebSocket communication.

- **`WebClientConfig`**:
  Configures `WebClient` for external service calls.

- **`SwaggerConfig`**:
  Configures Swagger/OpenAPI documentation.

---

## Contributing

Contributions are welcome! Feel free to submit issues or pull requests.

