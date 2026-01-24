> 🇧🇷 Este README está em português.  
> 🇺🇸 For an English version, see [README.en.md](README.en.md)

# TemplateOficial

Template de projeto para **automação em Java com suporte a BDD (Gherkin/Cucumber)**.  
Este repositório fornece uma estrutura organizada para criar, executar e manter testes automatizados em Java, com exemplos de organização de features, runners, pages e steps.

> **Linguagens principais:** Java (≈97,6%), Gherkin (≈2,4%)

> **Observação:** Este README foi criado com auxílio de inteligência artificial para maior clareza e padronização.

---

## Índice

* [Visão Geral](#visao-geral)
* [Principais Funcionalidades](#principais-funcionalidades)
* [Suporte à Automação de API com Rest Assured](#suporte-a-automacao-de-api-com-rest-assured)
* [Pré-requisitos](#pre-requisitos)
* [Estrutura do Projeto](#estrutura-do-projeto)
* [Instalação](#instalacao)
* [Como Executar os Testes](#como-executar-os-testes)
* [Executando Cenários por Tag](#executando-cenarios-por-tag-cucumber)
* [Relatórios](#relatorios)
* [Integração com CI/CD](#integracao-com-cicd)
* [Boas Práticas e Convenções](#boas-praticas-e-convencoes)
* [Contribuição](#contribuicao)
* [Licença](#licenca)
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

## Suporte à Automação de API com Rest Assured


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

## ▶️ Como Executar os Testes

Os testes automatizados podem ser executados via **linha de comando** ou diretamente pela **IDE**.

### Executar todos os testes

Para executar todos os cenários configurados nos runners do projeto:

```bash
mvn test
```
### Executar testes específicos(Web ou Rest)

```bash
mvn test -Dtest=RestTestRunner  
mvn test -Dtest=WebTestRunner
```
### Executar pela IDE
- Abra a classe de runner
- Clique com o botão direito
- Selecione Run

## 🏷️ Executando Cenários por Tag (Cucumber)

O projeto utiliza **tags do Cucumber** para organizar, agrupar e executar cenários de forma seletiva.

As tags são definidas nos arquivos `.feature` e permitem maior controle sobre quais testes serão executados.

---

### Exemplos de uso de tags

```gherkin
@web
Cenário: Validar login com sucesso
```
```gherkin
@rest
Cenário: Criar reserva via API
```

### Executar cenários por uma tag

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

## 📊 Relatórios

O **TemplateOficial** utiliza **Extent Reports** para geração de relatórios detalhados da execução dos testes automatizados.

Os relatórios são integrados ao fluxo **BDD (Cucumber)** e suportam tanto **testes Web** quanto **testes de API**.

---

### 📈 Informações apresentadas no relatório

Os relatórios gerados pelo Extent Reports incluem:

- Status do cenário (**PASS / FAIL**)
- Logs detalhados da execução
- Organização por feature e cenário
- Tempo de execução
- Evidências visuais (quando aplicável)

---

### 📸 Política de Captura de Screenshots

A captura de screenshots segue a política abaixo:

| Tipo de cenário | Resultado | Screenshot |
|-----------------|-----------|------------|
| `@web`          | FAIL      | ✅ Sim     |
| `@web`          | PASS      | ❌ Não     |
| `@rest`         | FAIL      | ❌ Não     |
| `@rest`         | PASS      | ❌ Não     |

📌 **Observações importantes:**
- Screenshots são capturados **apenas para cenários Web que falham**
- Cenários de **API (Rest Assured)** não geram screenshots
- Essa abordagem mantém os relatórios mais limpos e objetivos

---

### 📂 Localização dos relatórios

Após a execução dos testes, os relatórios ficam disponíveis no diretório:

```text
target/extent-report/
```

## 🤖 Integração com CI/CD

O projeto pode ser facilmente integrado a pipelines de CI/CD como:
- GitHub Actions
- Jenkins
- GitLab CI

A execução padrão utiliza o comando:
```bash
mvn test
```
## 📐 Boas Práticas e Convenções

- **Features** devem conter apenas regras de negócio
- **Steps** não devem ter lógica complexa
- Centralizar interações técnicas em **Pages / Actions / Services**
- Não misturar testes **Web** e **API** no mesmo cenário
- Um cenário deve validar **apenas um comportamento**
- Evitar dependência entre cenários

### 🏷️ Uso de Tags

- `@web` → Testes Web  
- `@rest` → Testes de API  
- `@smoke` → Testes críticos  
- `@regression` → Testes completos  
- `@ignore` → Cenários temporariamente desativados

📌 Seguir essas convenções facilita a manutenção, reutilização e execução dos testes.

## 📄 Licença

Este projeto está licenciado sob a **MIT License**.

Forks e usos são permitidos, porém **alterações no repositório original só ocorrem via Pull Request e aprovação do autor**.

## 📬 Contato

Criado e mantido por **Milton Denys**.

🔗 GitHub:  
https://github.com/MiltonDenysTemplatesAutomacao

Para dúvidas, sugestões ou melhorias, utilize as **issues** do repositório.
