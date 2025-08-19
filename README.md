# taskflow-ai
A# 🚀 TaskMind-AI  
*A Spring Boot powered Task Management API with AI-ready architecture*  

## 📖 Overview  
TaskMind-AI is a **backend API** for managing tasks, projects, and collaboration.  
It is built with **Java Spring Boot** and designed with **enterprise-grade security, database design, and scalability** in mind.  

This project serves both as a **portfolio project** and a foundation for future **AI-driven task automation and smart recommendations**.  

---

## ✨ Features  
- ✅ RESTful Task & Category Management  
- ✅ User Authentication & Authorization (JWT)  
- ✅ PostgreSQL Relational Database with audit trails  
- ✅ Task Sharing & Collaboration  
- ✅ Dockerized Deployment  
- ✅ API Documentation with Swagger  
- 🔜 AI Extensions (task prioritization, smart reminders, NLP task creation)  

---

## 🏗️ System Architecture  

```
┌─────────────┐    ┌─────────────┐    ┌─────────────┐
│   Client    │────│  REST API   │────│  Database   │
│ (Frontend/  │    │ (Spring     │    │ (PostgreSQL)│
│  Postman)   │    │   Boot)     │    │             │
└─────────────┘    └─────────────┘    └─────────────┘
```

---

## 🛠️ Tech Stack  
- **Language**: Java 17+  
- **Framework**: Spring Boot 3.x  
- **Database**: PostgreSQL 14+  
- **Security**: Spring Security + JWT  
- **Testing**: JUnit 5 + Mockito + TestContainers  
- **Containerization**: Docker  
- **Docs**: Swagger / OpenAPI 3  

---

## 📦 Installation & Setup  

### 1️⃣ Clone the Repo
```bash
git clone https://github.com/shubhamshelar/taskflow-ai.git
cd taskflow-ai
```

### 2️⃣ Configure Database
Update your `application.properties` (or `application.yml`) with PostgreSQL credentials:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/taskflow_ai
spring.datasource.username=postgres
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### 3️⃣ Run with Maven
```bash
./mvnw spring-boot:run
```

### 4️⃣ Run with Docker
```bash
docker-compose up --build
```

---

## 📚 API Endpoints  

### 🔑 Authentication
- `POST /api/auth/register` → Register user  
- `POST /api/auth/login` → Authenticate user  
- `POST /api/auth/refresh` → Refresh token  

### 📌 Tasks
- `GET /api/tasks` → Get all tasks  
- `POST /api/tasks` → Create task  
- `PUT /api/tasks/{id}` → Update task  
- `DELETE /api/tasks/{id}` → Delete task  

### 📂 Categories
- `GET /api/categories` → Get all categories  
- `POST /api/categories` → Create category  

*(More endpoints in [API Docs](http://localhost:8080/swagger-ui.html))*  

---

## 🔒 Security  
- JWT-based authentication  
- BCrypt password hashing  
- Owner-only access on tasks  
- Shared access with collaborators  

---

## 🚀 Roadmap (Future AI Features)  
- 🤖 **AI-powered task prioritization**  
- 🧠 **Natural language task creation** (e.g., “Remind me to call client tomorrow at 5”)  
- 📊 **Analytics & insights** on productivity  
- 🔔 **Smart reminders & notifications**  

---

## 🧪 Testing  
Run all tests with:
```bash
./mvnw test
```

Includes:  
- Unit tests (services, repos, controllers)  
- Integration tests with TestContainers  
- Security/auth flow tests  

---

## 🤝 Contribution  
Pull requests are welcome! Please open an issue first for discussion.  

---

## 📜 License  
This project is licensed under the MIT License.  

---

### 👨‍💻 Author  
Built with ❤️ by [Shubham Shelar](https://github.com/wissenshubham)  
