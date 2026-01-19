> 🇧🇷 Este README está em português.  
> 🇺🇸 For an English version, see [README.en.md](README.en.md)

# TemplateOficial

Template de projeto para **automação em Java com suporte a BDD (Gherkin/Cucumber)**.  
Este repositório fornece uma estrutura organizada para criar, executar e manter testes automatizados em Java, com exemplos de organização de features, runners, pages e steps.

> **Linguagens principais:** Java (≈97,6%), Gherkin (≈2,4%)

> **Observação:** Este README foi criado com auxílio de inteligência artificial para maior clareza e padronização.

---

## Índice

* [Visão Geral](#visão-geral)
* [Principais Funcionalidades](#principais-funcionalidades)
* [Suporte à Automação de API com Rest Assured](#suporte-à-automação-de-api-com-rest-assured)
* [Pré-requisitos](#pré-requisitos)
* [Estrutura do Projeto](#estrutura-do-projeto)
* [Instalação](#instalação)
* [Como Executar os Testes](#como-executar-os-testes)
* [Executando Cenários por Tag](#executando-cenários-por-tag-cucumber)
* [Relatórios](#relatórios)
* [Boas Práticas e Convenções](#boas-práticas-e-convenções)
* [Contribuição](#contribuição)
* [Licença](#licença)
* [Contato](#contato)

---

## Visão Geral

Este template foi criado para **acelerar o desenvolvimento de suítes de automação** usando Java com abordagem BDD (Gherkin).  
Ele já contém convenções de pastas, exemplos de features e hooks básicos que podem ser facilmente adaptados às necessidades do projeto.

---

## Principais Funcionalidades

* Estrutura padrão para testes em Java
* Suporte a cenários **Gherkin / Cucumber**
* Runner de testes configurado (**JUnit / TestNG**)
* Exemplos de organização de **Steps**, **Pages** e utilitários
* Fácil integração com **CI/CD** (GitHub Actions, Jenkins, etc.)
* Projeto preparado para crescimento e reutilização em múltiplos contextos

---

## 🧪 Suporte à Automação de API com Rest Assured


Com essa adição, o projeto passa a suportar **automação híbrida (Web + API)**, mantendo os mesmos padrões de organização, legibilidade e reutilização.

### O que este suporte permite

- Criação e execução de testes automatizados de **APIs REST**
- Envio de requisições HTTP:
    - `GET`
    - `POST`
    - `PUT`
    - `DELETE`
- Configuração de:
    - Headers
    - Body (JSON)
    - Autenticação (ex.: token)
- Validação de:
    - Status Code
    - Body da resposta
    - Headers do response
    -   Campos obrigatórios
    - Tipos de dados dos campos
    - Valores esperados no response
    - Mensagens de erro e regras de negócio
  
- Integração com **BDD (Cucumber + Gherkin)**

### Benefícios

- Padronização de testes de API
- Reutilização de código
- Organização clara entre testes de **UI** e **API**
- Facilidade de manutenção
- Escalabilidade para projetos mais complexos

### Tecnologias envolvidas

- **Java**
- **Rest Assured**
- **Cucumber (BDD)**
- **JUnit / TestNG**
- **Maven**


---

## Pré-requisitos

* Java 11 ou superior (recomendado: **Java 17 LTS**)
* Maven 3.6+ ou Gradle 6+ (dependendo do gerenciador de build)
* Git
* Navegador e driver (quando aplicável, ex.: `chromedriver`)

---

## Estrutura do Projeto

```text
src/main/java/               # Classes utilitárias, drivers, configurações do framework
src/test/java/               # Step Definitions, runners, testes
src/test/resources/features/ # Arquivos .feature (BDD / Gherkin)
resources/                   # Arquivos de configuração (.properties, .env.example)
pom.xml ou build.gradle      # Gerenciador de dependências e build 
```
## ⚙️ Instalação

Siga os passos abaixo para configurar o projeto localmente.

### 1️⃣ Clonar o repositório

```bash
git clone https://github.com/MiltonDenysTemplatesAutomacao/TemplateOficial.git
cd TemplateOficial
```
### 2️⃣ Instalar as dependências
```bash
mvn clean install
```

### 3️⃣ Verificações importantes

📌 Antes de executar os testes, verifique se:

- O **Java** está instalado corretamente:

  ```bash
  java -version

### 4️⃣ Testes Web (WebDriver)

Para testes de interface Web:

- Não é necessário baixar ou configurar o **WebDriver** manualmente
- O driver do navegador é baixado automaticamente durante a execução dos testes
- Basta ter o navegador instalado (ex.: **Google Chrome**)

📌 Essa abordagem simplifica a configuração do ambiente e evita problemas de compatibilidade de versões.

Após esses passos, o projeto estará pronto para a execução dos testes automatizados.
