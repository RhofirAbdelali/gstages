# GStages

Application de gestion de stages pour étudiants développée avec Spring Boot.

## Fonctionnalités

- Authentification
- Gestion des étudiants (CRUD)
- Gestion des stages
- Utilisation de H2 ou MySQL

## Technologies

- Java 17+
- Spring Boot
- Spring Security
- Spring Data JPA
- Thymeleaf
- ModelMapper
- H2 / MySQL

## Exécution

```bash
./mvnw spring-boot:run
```

## Base de données

- Par défaut : `application.properties` → H2
- Pour utiliser MySQL :
  ```properties
  spring.config.activate.on-profile=mysql
  ```

## Tests

```bash
mvn test
```
