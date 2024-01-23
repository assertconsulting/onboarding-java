Feature: login

  Scenario: login com credenciais válidas, DEVE ser redirecionado para tela inicial
    Given que eu esteja na página de login
    When  eu inserir credenciais válidas
    And clico no botão entrar
    Then  devo ser redirecionado para a tela inicial

  Scenario: login senha errada, NÃO DEVE ser redirecionado para tela inicial
    Given que eu esteja na página de login
    When eu inserir senha inválida e login válido
    And clico no botão entrar
    Then não devo ser redirecionado para a tela inicial

