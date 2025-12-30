# TemplateOficial

Template de projeto para automação em Java com suporte a BDD (Gherkin/Cucumber).  
Este repositório fornece uma estrutura inicial organizada para criar, executar e manter testes automatizados em Java, com exemplos de organização de features, runners e pages/steps.

> Linguagens principais: Java (≈97.6%), Gherkin (≈2.4%)

## Índice
- [Visão Geral](#visão-geral)
- [Principais funcionalidades](#principais-funcionalidades)
- [Pré-requisitos](#pré-requisitos)
- [Estrutura do projeto](#estrutura-do-projeto)
- [Instalação](#instalação)
- [Como executar os testes](#como-executar-os-testes)
- [Executando cenários por tag](#executando-cenários-por-tag)
- [Relatórios](#relatórios)
- [Boas práticas e convenções](#boas-práticas-e-convenções)
- [Contribuição](#contribuição)
- [Licença](#licença)
- [Contato](#contato)

## Visão Geral
Este template foi criado para acelerar o desenvolvimento de suites de automação usando Java com abordagem BDD (Gherkin). Ele já contém convenções de pastas, exemplos de features e hooks básicos que podem ser adaptados ao seu projeto.

## Principais funcionalidades
- Estrutura padrão para testes em Java
- Suporte a cenários Gherkin / Cucumber
- Runner de testes configurado (ex.: JUnit/TestNG)
- Exemplos de organização de steps, pages e utilitários
- Possibilidade fácil de integração com CI (GitHub Actions, Jenkins, etc.)

## Pré-requisitos
- Java 11 ou superior (recomendado: 17 LTS)
- Maven 3.6+ ou Gradle 6+ (dependendo do gerenciador de build do projeto)
- Git
- Navegador/driver (quando aplicável, ex.: chromedriver) — caso os testes façam automação de UI

## Estrutura sugerida do projeto
- src/main/java/...
  - classes utilitárias, drivers, configurações de framework
- src/test/java/...
  - stepdefinitions, runners, testes de integração
- src/test/resources/features/
  - arquivos .feature com cenários Gherkin
- resources/
  - arquivos de configuração (ex.: application.properties, .env.example)
- pom.xml ou build.gradle

> Ajuste os caminhos se seu projeto usar convenções diferentes.

## Instalação
1. Clone o repositório:
```bash
git clone https://github.com/MiltonDenysTemplatesAutomacao/TemplateOficial.git
cd TemplateOficial
```

2. Configure o Java (exemplo com SDKMAN/alternativas):
```bash
export JAVA_HOME=/caminho/para/java
export PATH=$JAVA_HOME/bin:$PATH
java -version
```

3. Se usar Maven, para baixar dependências:
```bash
mvn -q -DskipTests=true clean install
```
ou com Gradle:
```bash
./gradlew assemble
```

## Como executar os testes

- Com Maven (comando padrão):
```bash
mvn test
```

- Com Gradle:
```bash
./gradlew test
```

- Executar uma classe de teste específica (Maven):
```bash
mvn -Dtest=NomeDaClasseTest test
```

- Executar features Cucumber via tag (exemplos abaixo).

## Executando cenários por tag (Cucumber)
Exemplos comuns com Maven:

- Executar cenários marcados com @smoke:
```bash
mvn test -Dcucumber.options="--tags @smoke"
```

- Executar apenas cenários com @regression e excluir @wip:
```bash
mvn test -Dcucumber.options="--tags @regression and not @wip"
```

Se você usa uma configuração de runner em JUnit/TestNG, também é possível usar profiles ou propriedades para controlar as tags.

## Relatórios
- Suporte a relatórios do Maven Surefire/Failsafe.
- Pode integrar Cucumber Reports (json -> plugin de relatório).
- Exemplo de geração básica (Maven):
```bash
mvn test
# em seguida processar os relatórios ou abrir target/surefire-reports
```
Considere adicionar plugins como cucumber-reporting ou extent-reports para relatórios mais ricos.

## Boas práticas e convenções
- Mantenha cenários Gherkin legíveis e focados em comportamento (não em implementação).
- Use Tags para agrupar cenários (smoke, regression, critical, etc.).
- Separe responsabilidade: Page Objects para interação com UI, Step Definitions apenas para orquestrar passos.
- Versione drivers e dependências no CI; não comite binários.
- Providencie um arquivo .env.example com variáveis necessárias (URL do ambiente, credenciais de teste — sempre sensíveis via secrets).

## Contribuição
Contribuições são bem-vindas! Sugestões:
1. Abra uma issue descrevendo a melhoria ou correção.
2. Crie um branch com um nome descritivo: feature/nome, fix/bug-descricao.
3. Abra um Pull Request com descrição clara do que foi alterado e por quê.
4. Adicione testes quando aplicável.

Se desejar, adicione um arquivo CONTRIBUTING.md com regras específicas do time.

## Licença
Este repositório não contém uma licença por padrão. Recomenda-se adicionar uma licença (por exemplo MIT) se quiser permitir uso/colaboração aberta.

Exemplo rápido (MIT):
```
MIT License
Copyright (c) 2025 <Seu Nome ou Organização>
...
```

Atualize de acordo com sua necessidade legal.

## Contato
- Autor / Mantainer: Milton Denys (ou ajuste para o responsável)
- GitHub: https://github.com/MiltonDenysTemplatesAutomacao/TemplateOficial

---

Se quiser, eu posso:
- Gerar um arquivo CONTRIBUTING.md e .gitignore apropriado para Java,
- Adicionar um exemplo de workflow do GitHub Actions para rodar os testes,
- Gerar um template de pom.xml ou build.gradle compatível com este template.

Diga qual desses itens deseja que eu gere em seguida.
