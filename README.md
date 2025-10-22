
## Requisitos
- Java 21
- Maven 3.9+
- MySQL 8

## Configuración
- Base de datos: soporte_tecnico (se crea automáticamente)
- Edita credenciales en: src/main/resources/application.properties

## Ejecutar
mvn spring-boot:run

- Swagger UI: http://localhost:8080/swagger-ui/index.html
- con el url podemos entrar a Swagger UI y ver los registros que estan en postman

## Endpoints
- Clientes: GET/POST/PUT/DELETE /api/clientes
- Técnicos: GET/POST/PUT/DELETE /api/tecnicos
- Solicitudes: GET/POST/PUT/DELETE /api/solicitudes



