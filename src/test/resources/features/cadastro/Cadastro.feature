# language: pt

Funcionalidade: cadastro
  #Revisão do passo então (inserir uma validação)
  #Email dinâmico (idempotência) para o passo "quando", pois o teste tem que rodar uma ou N vezes com o mesmo resultado
  Cenario: inserir todos os dados válidos de cadastro, DEVE efetuar o cadastro
    Dado estar na página de cadastro de usuários
    Quando inserir todas as credenciais válidas
    E clicar no botão cadastrar
    Então  deve ser redirecionado para a tela inicial

  Cenário: cadastrar com email duplicado
    Dado estar na página de cadastro de usuários
    Quando inserir todas as credenciais válidas
    E inserir um email já cadastrado
    E clicar no botão cadastrar
    Então deve mostrar a mensagem de erro Este email já está sendo usado

  Cenário: cadastrar com campos em branco
    Dado estar na página de cadastro de usuários
    Quando deixar as credenciais em branco
    E clicar no botão cadastrar
    Então deve ver a mensagem de erro "Email não pode ficar em branco"


