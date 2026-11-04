# cicdPractice — Banana Shooter

A small Spring Boot web app that serves a browser game ("banana shooter"), used as a playground for practicing Docker and CI/CD workflows.

## Tech stack

- Java 25
- Spring Boot 3.5 (`spring-boot-starter-web`)
- Maven (with the Maven Wrapper)
- Docker (multi-stage build) and Docker Compose

## Project structure

```
.
├── src/main/java/com/example/cicdpractice/
│   ├── CicdPracticeApplication.java   # Spring Boot entry point
│   └── controller/GameController.java # Maps "/" to the game page
├── src/main/resources/
│   ├── application.properties         # App config (port 8080)
│   └── static/index.html              # The game (HTML/CSS/JS)
├── src/test/java/...                  # Tests
├── Dockerfile                         # Multi-stage build: Maven -> JRE
├── docker-compose.yaml                # Runs dev and prod images
└── pom.xml
```

## Running locally

Requires JDK 25.

```bash
./mvnw spring-boot:run
```

Then open http://localhost:8080.

### Build and test

```bash
./mvnw clean package   # builds target/cicdPractice-0.0.1-SNAPSHOT.jar
./mvnw test            # runs tests only
java -jar target/cicdPractice-0.0.1-SNAPSHOT.jar
```

## Docker

Build and run the image:

```bash
docker build -t banana .
docker run -p 8080:8080 banana
```

The Dockerfile builds the jar with `maven:3.9-eclipse-temurin-25`, then copies it into a slim `eclipse-temurin:25-jre` runtime image.

### Docker Compose

`docker-compose.yaml` runs the published dev and prod images side by side:

| Service | Image                          | URL                   |
|---------|--------------------------------|-----------------------|
| dev     | `elyasaf1/banana-dev:latest`   | http://localhost:3000 |
| prod    | `elyasaf1/banana-prod:latest`  | http://localhost:4000 |

```bash
docker compose up -d          # start both
docker compose up -d dev      # start only dev
docker compose pull           # fetch the latest images
docker compose down           # stop
```
