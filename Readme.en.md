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
* [Contact](#contact)**

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
src/main/java/               # Utility classes, drivers, framework configurations
src/test/java/               # Step Definitions, runners, tests
src/test/resources/features/ # .feature files (BDD / Gherkin)
resources/                   # Configuration files (.properties, .env.example)
pom.xml or build.gradle      # Dependency management and build tool
```

## ⚙️ Installation

Follow the steps below to set up the project locally.

### 1️⃣ Clone the repository

```bash
git clone https://github.com/MiltonDenysTemplatesAutomacao/TemplateOficial.git
cd TemplateOficial
```

### 2️⃣ Install the dependencies
```bash
mvn clean install
```
### 3️⃣ Important checks

📌 ABefore running the tests, make sure that:

* **Java** is installed correctly:


  ```bash
  java -version
 ```

### 4️⃣ Web Tests (WebDriver)

For Web interface tests:

* It is not necessary to download or configure the **WebDriver** manually
* The browser driver is downloaded automatically during test execution
* You only need to have the browser installed (e.g., **Google Chrome**)


📌 This approach simplifies the environment setup and avoids version compatibility issues.

After these steps, the project will be ready to run the automated tests.

## ▶️ Como Executar os Testes
How to Run the Tests

Automated tests can be executed via the **command line** or directly from the **IDE**.


### Run all tests

To execute all scenarios configured in the project runners:


```bash
mvn test
```
### Run specific tests (Web or REST)

```bash
mvn test -Dtest=RestTestRunner  
mvn test -Dtest=WebTestRunner
```
### Run via the IDE

* Open the runner class
* Right-click
* Select **Run**


## 🏷️ Running Scenarios by Tag (Cucumber)

The project uses **Cucumber tags** to organize, group, and selectively execute scenarios.

Tags are defined in the `.feature` files and allow greater control over which tests will be executed.


---

### Examples of tag usage

```gherkin
@web
Scenario: Validate successful login

```
```gherkin
@rest
Scenario: Create reservation via API
```

### Run scenarios by a tag


```bash
mvn test -Dcucumber.filter.tags="@web"
```
```bash
mvn test -Dcucumber.filter.tags="@rest"
```
```bash
mvn test -Dcucumber.filter.tags="@smoke and @web"
```
```bash
mvn test -Dcucumber.filter.tags="@regression and not @ignore"
```

## 📊 Reports

**TemplateOficial** uses **Extent Reports** to generate detailed reports of automated test executions.

The reports are integrated with the **BDD (Cucumber)** flow and support both **Web tests** and **API tests**.

---

### 📈 Information shown in the report

The reports generated by Extent Reports include:

* Scenario status (**PASS / FAIL**)
* Detailed execution logs
* Organization by feature and scenario
* Execution time
* Visual evidence (when applicable)


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
- Screenshots are captured **only for failing Web scenarios**
- **API scenarios (Rest Assured)** do not generate screenshots
- This approach keeps reports cleaner and more objective

### 📂 Report Location

After test execution, the reports are available in the following directory:

```text
target/extent-report/
```

## 🤖 CI/CD Integration

The project can be easily integrated with CI/CD pipelines such as:
- GitHub Actions
- Jenkins
- GitLab CI

The standard execution uses the command:
```bash
mvn test
```
## 📐 Best Practices and Conventions

- **Features** should contain only business rules
- **Steps** should not contain complex logic
- Centralize technical interactions in **Pages / Actions / Services**
- Do not mix **Web** and **API** tests in the same scenario
- A scenario should validate **only one behavior**
- Avoid dependencies between scenarios


### 🏷️ Tag Usage

- `@web` → Web tests
- `@rest` → API tests
- `@smoke` → Critical tests
- `@regression` → Full test suite
- `@ignore` → Temporarily disabled scenarios

📌 Following these conventions makes test maintenance, reuse, and execution easier.


## 📄 License

This project is licensed under the **MIT License**.

Forks and usage are allowed; however, **changes to the original repository only occur via Pull Request and author approval**.

## 📬 Contact

Created and maintained by **Milton Denys**.

🔗 GitHub:  
https://github.com/MiltonDenysTemplatesAutomacao

For questions, suggestions, or improvements, please use the **issues** section of the repository.

