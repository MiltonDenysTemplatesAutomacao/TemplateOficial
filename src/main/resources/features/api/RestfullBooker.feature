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

  @createBooking
  Scenario: Booking - Create Booking
    Given que eu tenho um endpoint para get Create Booking
    When envio uma requisicao GET para o endpoint de Create Booking
    Then valido se o status code é 200

  @getBooking
  Scenario: Booking - Get Booking
    Given que eu tenho um endpoint com um id para Get Booking
    When envio uma requisicao GET para o endpoint de Get Booking com o id "/5068"
    Then valido se o status code é 200

  @updateBooking
  Scenario: Booking - Update Booking
    Given que eu tenho um endpoint com um id para Update Booking
    When envio uma requisicao PUT para o endpoint de Booking com o id "/2295"
    Then valido se o status code é 200

  @partialUpdateBooking
  Scenario: Booking - Update Booking
    Given que eu tenho um endpoint com um id para Partial Update Booking
    When envio uma requisicao PATCH para o endpoint de Booking com o id "/2295"
    Then valido se o status code é 200

  @deleteBooking
  Scenario: Booking - Delete Booking
    Given que eu tenho um endpoint com um id para Delete Booking
    When envio uma requisicao DELETE para o endpoint de Booking com o id "/2295"
    Then valido se o status code é 200