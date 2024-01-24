Feature: cadastro

  Scenario: inserir todos os dados válidos de cadastro, DEVE efetuar o cadastro
    Given que eu esteja na página de cadastro
    When  inserir todos os dados válidos
    Then  devo ser redirecionado para a tela login