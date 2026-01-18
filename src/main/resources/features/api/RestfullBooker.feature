@rest

Feature: Testes de API com Rest Assured usando RestFull Booker como exemplo


  @healthCheck
  Scenario: Health Check
    Given que eu tenho um endpoint para health check
    When envio uma requisicao GET para o endpoint
    Then valido se o status code é 201

  @getBookingID
  Scenario: Booking - GetBooking Ids
    Given que eu tenho um endpoint para get book id
    When envio uma requisicao GET para o endpoint de booking
    Then valido se o status code é 200

  @createBookingID
  Scenario: Booking - Create Booking
    Given que eu tenho um endpoint para get Create Booking
    When envio uma requisicao GET para o endpoint de Create Booking
    Then valido se o status code é 200