# 🔗 URL Shortener using Spring Boot

A simple and scalable URL shortener service built with Java and Spring Boot.

## 🚀 Features

- Generate short URLs for long links
- Redirect short URLs to original URLs
- Auto-generated short codes using Base62 encoding
- Track number of clicks for each short URL
- Rate limiting using Resilience4j
- REST API with clean structure
- Database integration (e.g., MySQL/PostgreSQL)
- Easy deployment using Docker Compose
- Optional: Redis caching, analytics, expiry links

---

## 🧱 Tech Stack

- **Java 17+**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **MySQL / PostgreSQL**
- **Resilience4j** (for rate limiting)
- **Docker & Docker Compose**
- **Redis** (optional)
---

## 📡 API Endpoints

### 🔹 POST `/shorten`
**Description:** Shortens a long URL  
**Request Body Example:**
```json
{
  "originalUrl": "https://example.com"
}
```
**Response Example:**
```json
{
  "shortUrl": "http://localhost:8080/abc123"
}
```
### 🔹 GET `/{shortCode}`
**Description:** Redirects to the original URL


## 🐳 Run with Docker Compose

1️⃣ Clone the repository
```bash
git clone https://github.com/yourusername/url-shortener.git
cd url-shortener
```

2️⃣ Build and start services
```bash
docker compose up --build
```

---

## ⚙️ Environment Variables

You can configure these in `application-docker.properties` as well as in `application-local.properties`:

```properties
spring.datasource.url=jdbc:mysql://db:3306/urlshortener
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

---

## 📜 License

This project is licensed under the MIT License.


