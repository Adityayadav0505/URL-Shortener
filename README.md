# 🔗 URL Shortener using Spring Boot

A simple and scalable URL shortener service built with Java and Spring Boot.

## 🚀 Features

- Generate short URLs for long links
- Redirect short URLs to original URLs
- Auto-generated short codes using Base62 encoding
- REST API with clean structure
- Optional database integration (e.g., MySQL/PostgreSQL)
- Optional: Redis caching, rate limiting, analytics

---

## 🧱 Tech Stack

- **Java 17+**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **MySQL / PostgreSQL**
- **Lombok** (optional)
- **Redis** (optional)

---

📡 API Endpoints

🔸 POST /shorten
Description: Shortens a long URL

🔸 GET /{shortCode}
Description: Redirects to the original URL
