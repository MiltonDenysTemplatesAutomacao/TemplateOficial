@rest

Feature: Testes de API com Rest Assured usando RestFull Booker como exemplo


  @healthCheck
  Scenario: Health Check
    Given que eu tenho um endpoint para health check
    When envio uma requisicao GET para o endpoint
    Then valido se o status code é 200
