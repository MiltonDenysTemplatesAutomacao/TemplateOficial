> 🇺🇸 This README is in English.  
> 🇧🇷 Para a versão em português, veja [README.md](README.md)

# TemplateOficial

Project template for **Java automation with BDD support (Gherkin/Cucumber)**.  
This repository provides an organized structure to create, execute, and maintain automated tests in Java, including examples of feature, runner, page, and step organization.

> **Main languages:** Java (≈97.6%), Gherkin (≈2.4%)

> **Note:** This README was created with the assistance of artificial intelligence to improve clarity and standardization.

---

## Index

* [Overview](#overview)
* [Main Features](#main-features)
* [API Automation Support with Rest Assured](#api-automation-support-with-rest-assured)
* [Prerequisites](#prerequisites)
* [Project Structure](#project-structure)
* [Installation](#installation)
* [How to Run the Tests](#how-to-run-the-tests)
* [Running Scenarios by Tag](#running-scenarios-by-tag-cucumber)
* [Reports](#reports)
* [Best Practices and Conventions](#best-practices-and-conventions)
* [Contribution](#contribution)
* [License](#license)
* [Contact](#contact)

---

## Overview

This template was created to **accelerate the development of automation test suites** using Java with a BDD (Gherkin) approach.  
It already includes folder conventions, feature examples, and basic hooks that can be easily adapted to your project needs.

---

## Main Features

* Standard structure for Java test automation
* Support for **Gherkin / Cucumber** scenarios
* Test runners configured (**JUnit / TestNG**)
* Examples of **Steps**, **Pages**, and utility classes organization
* Easy integration with **CI/CD** tools (GitHub Actions, Jenkins, etc.)
* Project prepared for growth and reuse in multiple contexts

---

## 🧪 API Automation Support with Rest Assured


With this addition, the project supports **hybrid automation (Web + API)** while maintaining the same standards of organization, readability, and reusability.

### What this support enables

- Creation and execution of automated **REST API tests**
- HTTP request execution:
    - `GET`
    - `POST`
    - `PUT`
    - `DELETE`
- Configuration of:
    - Headers
    - Request body (JSON)
    - Authentication (e.g., token-based)
- Validation of:
    - Status codes
    - Response body
    - Response headers
    - Required fields
  - Field data types
  - Expected values in the response
  - Error messages and business rules
- Integration with **BDD (Cucumber + Gherkin)**

### Benefits

- Standardized API tests
- Code reuse
- Clear separation between **UI** and **API** tests
- Easier maintenance
- Scalability for more complex projects

### Technologies involved

- **Java**
- **Rest Assured**
- **Cucumber (BDD)**
- **JUnit / TestNG**
- **Maven**

---

## Prerequisites

* Java 11 or higher (recommended: **Java 17 LTS**)
* Maven 3.6+ or Gradle 6+ (depending on the build tool)
* Git
* Browser and driver (when applicable, e.g., `chromedriver`)

---

## Project Structure

```text
src/main/java/               # Utility classes, drivers, framework configuration
src/test/java/               # Step Definitions, runners, tests
src/test/resources/features/ # .feature files (BDD / Gherkin)
resources/                   # Configuration files (.properties, .env.example)
pom.xml or build.gradle      # Dependency and build management
