
# Asturias Ruta & Ride – Backend

Backend desarrollado con Spring Boot para la aplicación **Asturias Ruta & Ride**, cuyo objetivo es gestionar rutas de senderismo y ciclismo en Asturias e implementar un sistema de autenticación con verificación por correo y seguridad mediante JWT.

Este servicio expone una API REST utilizada por el frontend para el registro, inicio de sesión y consulta de rutas.

---

## 1. Tecnologías utilizadas

| Tecnología | Versión | Uso |
|------------|----------|-----|
| Java | 21 | Lenguaje principal |
| Spring Boot | 3.5.7 | Framework backend |
| Spring Data JPA | - | Persistencia ORM |
| Spring Security + JWT | - | Seguridad y autenticación |
| MySQL | 8+ | Base de datos (perfil principal) |
| H2 Database | - | Base de datos para desarrollo rápido |
| Maven | 3+ | Gestión de dependencias |
| Docker Compose | - | Levantar MySQL en local |
| JavaMailSender | - | Envío de correos de verificación |

---

## 2. Arquitectura del proyecto

El backend sigue una estructura modular basada en capas:

src/main/java/dev.milca.ruta_ride
│
├── auth/ # Registro, login, verificación y JWT
├── route/ # Gestión de rutas (entidad, servicio y controlador)
├── user/ # Usuario, token de verificación y servicio email
├── spring_security/ # Configuración de seguridad y CORS
└── common/ # Excepciones y utilidades comunes

---

## 3. Modelo de datos

### Users
- id, name, email (único), password, phone, profileImage
- isVerified: boolean para controlar acceso tras verificación

### VerificationToken
- Token único asociado 1:1 a un usuario
- expiryDate con vencimiento de 24h

### Routes
- id, name, area, kilometres, difficulty, image, description, latitude, longitude

---

## 4. Endpoints principales

### Autenticación (`/api/v1/auth`)

| Método | Endpoint | Descripción |
|--------|-----------|--------------|
| POST | `/register` | Registra un usuario y envía email de verificación |
| GET | `/verify?token=` | Activa la cuenta del usuario |
| POST | `/login` | Inicia sesión y devuelve JWT (si está verificado) |

### Rutas (`/api/v1/routes`)

| Método | Endpoint | Descripción |
|--------|-----------|--------------|
| GET | `/` | Lista todas las rutas |
| GET | `/{id}` | Devuelve el detalle de una ruta |

---

## 5. Seguridad

- Spring Security con filtros personalizados
- JWT para autorización mediante `Authorization: Bearer <token>`
- BCrypt para encriptación de contraseñas
- CORS habilitado para permitir la conexión con el frontend (`http://localhost:5173`)
- Inicio de sesión bloqueado si el usuario no verificó su correo

---

## 6. Configuración y ejecución

### Requisitos previos

- Java 21
- Maven
- (Opcional) Docker + Docker Compose para usar MySQL
- Credenciales SMTP para envío de emails

---

### Opción A: Ejecutar con MySQL + Docker Compose (recomendado)

1. Iniciar base de datos:

```bash
docker compose up -d
```

2. Iniciar base de datos:

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=mysql
```

Opción B: Ejecutar con H2 (sin base de datos instalada)

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=h2
```

Consola H2:
http://localhost:8080/h2-console

---

## 7. Variables de entorno

Las credenciales sensibles deben configurarse como **variables de entorno**.

Ejemplo:

```bash
SPRING_MAIL_USERNAME=<your_smtp_user>
SPRING_MAIL_PASSWORD=<your_smtp_password>
JWT_SECRET=<your_jwt_secret>
```
---

## 8. Scripts útiles

| Comando                  | Descripción                  |
| ------------------------ | ---------------------------- |
| `./mvnw clean package`   | Genera artefacto JAR         |
| `./mvnw spring-boot:run` | Ejecuta el proyecto          |
| `docker compose up -d`   | Inicia MySQL para desarrollo |

---

## 9. Próximas mejoras

- CRUD completo de rutas (POST, PUT, DELETE)

- Rutas protegidas por roles

- Favoritos de usuario

- Refresh token y recuperación de contraseña

- Tests unitarios y de integración

---

## 10. Estado del proyecto
###Funcionalidades completadas para esta fase:

✔ Registro de usuario con verificación por email

✔ Inicio de sesión con JWT

✔ Catálogo de rutas

✔ Conexión entre backend y frontend

---