# Projeto de estudo
Projeto criado com o intuito de estudar OAuth 2.0 e OpenID Connect.

## Tecnologias utilizadas
- Spring Boot
- Spring Security
- OAuth 2.0 Resource Server
- OAuth 2.0 Client
- Keycloak

## Comando para iniciar aplicação
```sh
mvn spring-boot:run
```

## Comando docker para rodar o Keycloak
```sh
docker run -p 8080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:22.0.5 start-dev
```