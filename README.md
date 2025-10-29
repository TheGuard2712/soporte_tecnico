##Descrpcion del proyecto 
La empresa de servicios tecnológicos necesita registrar las solicitudes de
soporte técnico de sus clientes. Actualmente el proceso es manual, lo que
genera pérdidas de información y retrasos. Por ello, el equipo desarrolló una
API REST full en Java 21 y Spring Boot, conectada a MySQL,
que permite registrar, consultar, actualizar y eliminar solicitudes de manera
estructurada y segura.

## Requisitos
- Java 21
- Maven 3.9+
- MySQL 8

## Configuración
- Base de datos: soporte_tecnico (se crea automáticamente)
- Edita credenciales en: src/main/resources/application.properties
- En MySQL para poder entar a la base de datos tendremos que poner :
- USE soporte_tecnico;
- seleccionaremos las tablas
- SELECT * FROM cliente;
- SELECT * FROM tecnico;
- SELECT * FROM solicitud;

## Ejecutar
mvn spring-boot:run

- Swagger UI: http://localhost:8080/swagger-ui/index.html
- con el url podemos entrar a Swagger UI y ver los registros que estan en postman

## Endpoints
- Clientes: GET/POST/PUT/DELETE /api/clientes
- Técnicos: GET/POST/PUT/DELETE /api/tecnicos
- Solicitudes: GET/POST/PUT/DELETE /api/solicitudes




