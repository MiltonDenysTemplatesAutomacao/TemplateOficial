@web
Feature: Login

@login
  Scenario: Login com credenciais válidas
    Given que o usuário acessa a página de login
    When ele realiza login com usuário e senha válidos
    Then o sistema deve exibir a página inicial