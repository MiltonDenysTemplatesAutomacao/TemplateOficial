# TemplateOficial

Template de projeto para **automação em Java com suporte a BDD (Gherkin/Cucumber)**.
Este repositório fornece uma estrutura organizada para criar, executar e manter testes automatizados em Java, com exemplos de organização de features, runners, pages e steps.

> **Linguagens principais:** Java (≈97,6%), Gherkin (≈2,4%)

> **Observação:** Este README foi criado com auxílio de inteligência artificial para maior clareza e padronização.

## Índice

* [Visão Geral](#visão-geral)
* [Principais Funcionalidades](#principais-funcionalidades)
* [Pré-requisitos](#pré-requisitos)
* [Estrutura do Projeto](#estrutura-do-projeto)
* [Instalação](#instalação)
* [Como Executar os Testes](#como-executar-os-testes)
* [Executando Cenários por Tag](#executando-cenários-por-tag)
* [Relatórios](#relatórios)
* [Boas Práticas e Convenções](#boas-práticas-e-convenções)
* [Contribuição](#contribuição)
* [Licença](#licença)
* [Contato](#contato)

---

## Visão Geral

Este template foi criado para **acelerar o desenvolvimento de suítes de automação** usando Java com abordagem BDD (Gherkin). Ele já contém convenções de pastas, exemplos de features e hooks básicos que podem ser adaptados ao seu projeto.

---

## Principais Funcionalidades

* Estrutura padrão para testes em Java
* Suporte a cenários Gherkin / Cucumber
* Runner de testes configurado (JUnit/TestNG)
* Exemplos de organização de **Steps**, **Pages** e utilitários
* Fácil integração com CI/CD (GitHub Actions, Jenkins, etc.)

---

## Pré-requisitos

* Java 11 ou superior (recomendado: 17 LTS)
* Maven 3.6+ ou Gradle 6+ (dependendo do gerenciador de build)
* Git
* Navegador/driver (quando aplicável, ex.: `chromedriver`)

---

## Estrutura do Projeto

```text
src/main/java/...          # Classes utilitárias, drivers, configurações do framework
src/test/java/...          # Step Definitions, runners, testes de integração
src/test/resources/features/ # Arquivos .feature com cenários Gherkin
resources/                 # Arquivos de configuração (ex.: application.properties, .env.example)
pom.xml ou build.gradle    # Gerenciador de dependências e build
```

> Ajuste os caminhos caso seu projeto utilize convenções diferentes.

---

## Instalação

1. Clone o repositório:

```bash
git clone https://github.com/MiltonDenysTemplatesAutomacao/TemplateOficial.git
cd TemplateOficial
```

2. Configure o Java (exemplo com SDKMAN ou equivalente):

```bash
export JAVA_HOME=/caminho/para/java
export PATH=$JAVA_HOME/bin:$PATH
java -version
```

3. Instale dependências:

* **Maven:**

```bash
mvn -q -DskipTests clean install
```

* **Gradle:**

```bash
./gradlew assemble
```

---

## Como Executar os Testes

* **Maven (comando padrão):**

```bash
mvn test
```

* **Gradle:**

```bash
./gradlew test
```

* **Executar classe de teste específica (Maven):**

```bash
mvn -Dtest=NomeDaClasseTest test
```

---

## Executando Cenários por Tag (Cucumber)

* Executar cenários com `@smoke`:

```bash
mvn test -Dcucumber.options="--tags @smoke"
```

* Executar cenários `@regression` e excluir `@wip`:

```bash
mvn test -Dcucumber.options="--tags @regression and not @wip"
```

> Se usar JUnit/TestNG, é possível controlar tags via profiles ou propriedades.

---

## Relatórios

* Suporte a relatórios do Maven Surefire/Failsafe
* Integração com **Cucumber Reports** (JSON -> plugin de relatório)
* Exemplo básico (Maven):

```bash
mvn test
# Depois abra os relatórios em target/surefire-reports
```

> Para relatórios avançados, considere plugins como `cucumber-reporting` ou `extent-reports`.

---

## Boas Práticas e Convenções

* Cenários Gherkin devem ser **legíveis e focados em comportamento**, não em implementação
* Use **tags** para agrupar cenários (`smoke`, `regression`, `critical`, etc.)
* Separe responsabilidades: **Page Objects** para UI, **Step Definitions** apenas para orquestrar passos
* Versione drivers e dependências via CI; **não comite binários**
* Inclua `.env.example` com variáveis necessárias (URLs, credenciais de teste — sempre via secrets)

---

## Contribuição

Contribuições são bem-vindas!

1. Abra uma issue descrevendo a melhoria ou correção
2. Crie um branch com nome descritivo (`feature/nome`, `fix/bug-descricao`)
3. Abra um Pull Request com descrição clara do que foi alterado e por quê
4. Adicione testes quando aplicável

> Recomenda-se criar um `CONTRIBUTING.md` com regras específicas do time.

---

## Licença

Este repositório **não contém licença** por padrão. Recomenda-se adicionar uma (ex.: MIT) para uso aberto:

```
MIT License
Copyright (c) 2025 Milton Denys
```

---

## Contato

* **Autor / Maintainer:** Milton Denys
* **GitHub:** [TemplateOficial](https://github.com/MiltonDenysTemplatesAutomacao/TemplateOficial)
