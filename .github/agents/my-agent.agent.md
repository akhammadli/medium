# 🤖 AGENT.md

## 📌 Repository Overview
This repository contains the source code for **[Project Name]**.  
The project is responsible for **[brief description – e.g., handling transaction processing, authorization flows, or FAST LAR logic]**.

---

## 🧱 Architecture
- Language: **[Java / Kotlin / etc.]**
- Framework: **[Spring Boot / Micronaut / etc.]**
- Architecture Style: **[Hexagonal / Modular Monolith / Microservices]**
- Build Tool: **[Gradle / Maven]**

### Key Modules
- `domain` → Core business logic
- `process` → Handlers and processing pipeline
- `infrastructure` → External integrations (DB, APIs)
- `config` → Configuration and feature flags

---

## ⚙️ Setup & Run

### Prerequisites
- Java **[version]**
- Docker (if applicable)
- Access to **[internal services / DB]**

### Run Locally
```bash
./gradlew clean build
./gradlew bootRun
