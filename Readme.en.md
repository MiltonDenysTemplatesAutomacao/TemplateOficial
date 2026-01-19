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

## Reports

**TemplateOficial** uses **Extent Reports** to generate execution reports for automated tests, providing a clear, organized, and detailed view of the results.

The reports are integrated into the **BDD (Cucumber)** execution flow and work for both **Web tests** and **API tests**.

---

### 📊 Reports with Extent Reports

Extent Reports provides information such as:

- Scenario status (**PASS / FAIL**)
- Detailed execution logs
- Organization by feature and scenario
- Visual evidence (when applicable)
- Integration with automated execution via Maven/Gradle

---

### 📸 Screenshot Capture Policy

Screenshot capture follows the policy below:

| Scenario type | Result | Screenshot |
|---------------|--------|------------|
| `@web`        | FAIL   | ✅ Yes     |
| `@web`        | PASS   | ❌ No      |
| `@rest`       | FAIL   | ❌ No      |
| `@rest`       | PASS   | ❌ No      |

📌 **Important notes:**
- Screenshots are captured **only for failed Web scenarios**
- **API scenarios (Rest Assured)** do not generate screenshots
- This approach avoids cluttered reports and keeps the focus on relevant evidence

---

### 📦 Reporting Dependencies

The project includes specific dependencies to support report generation with **Extent Reports**, already integrated into the test execution flow.

> Dependency details and versions can be found in the `pom.xml` or `build.gradle` file.

---

### ✅ Benefits of using Extent Reports

- Clear and easy-to-read reports
- Improved failure traceability
- Evidence generated only when necessary
- Compatible with **Web and API** automation
- Ready for use in **CI/CD pipelines**
