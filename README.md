# JPAstreamer - Spring App Example

[JPAstreamer](https://github.com/speedment/jpa-streamer) is a lightweight extension for any JPA provider that allows creation of Java Streams from database content.

This repository contains an example Spring project that uses JPAstreamer to access data.

## Local setup

Before proceeding with the local setup, make sure you have the following dependencies installed:
- [JDK 11](https://openjdk.java.net/install/)
- [Gradle](https://gradle.org/install/)
- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/install/)

### Database instance

This example project uses [Sakila](https://dev.mysql.com/doc/sakila/en/), an Open Source MySQL database, as a storage option of choice. Before running the application, it is required that an instance of the database is available and running.

You can start a Sakila instance locally by executing the following command from the project root:
```
docker-compose up -d
```

Once done, you can terminate the local instance by executing the following command from the project root:
```
docker-compose down
```

### Running the Spring Boot app

Once you have the Sakila instance up and running, you can start the Spring Boot application by executing the following command from the project root:
```
gradle bootRun
```

### Using the REST API

The example Spring application exposes several REST routes as a way for users to access entities:

- Accessing a paginated list of films:
```
${baseUrl}/films
```

- Accessing a single film:
```
${baseUrl}/films/${id}
```

- Accessing the list of actors in a film:
```
${baseUrl}/films/${id}/actors
```
