# language: pt

Funcionalidade:: login

  Cenario: login com credenciais válidas, DEVE ser redirecionado para tela inicial
    Dado estar na página de login
    Quando  inserir credenciais válidas, clicar no botão entrar
    Entao deve ser redirecionado para a tela inicial

  Cenario: e-mail correto, senha errada, NÃO DEVE ser redirecionado para tela inicial
    Dado estar na página de login
    Quando inserir login válido e senha inválida, clicar no botão entrar
    Entao não deve ser redirecionado para a tela inicial, deve mostrar a mensagem "Email e/ou senha inválidos"

  Cenario: e-mail errado e senha correta, NÃO DEVE ser redirecionado para tela inicial
    Dado estar na página de login
    Quando inserir login inválido e senha válida, clicar no botão entrar
    Entao não deve ser redirecionado para a tela inicial, deve mostrar a mensagem "Email e/ou senha inválidos"

  Cenario: e-mail errado e senha errada, NÃO DEVE ser redirecionado para tela inicial
    Dado estar na página de login
    Quando inserir login inválido e senha inválida, clicar no botão entrar
    Entao não deve ser redirecionado para a tela inicial, deve mostrar a mensagem "Email e/ou senha inválidos"

  Cenario: campo e-mail vazio e campo senha preenchido, NÃO DEVE ser redirecionado para tela inicial
    Dado estar na página de login
    Quando inserir e-mail vazio e campo senha preenchido, clicar no botão entrar
    Entao não deve ser redirecionado para a tela inicial, deve mostrar a mensagem "Email não pode ficar em branco"

  Esquema do Cenario: campo e-mail preenchido e campo senha vazio, NÃO DEVE ser redirecionado para tela inicial
    Dado estar na página de login
    Quando inserir e-mail e campo senha vazio, clicar no botão entrar
    Entao não deve ser redirecionado para a tela inicial, deve mostrar as seguintes <mensagens>
    Exemplos:
      | mensagens                           |
      | "Password não pode ficar em branco" |

  Esquema do Cenario: campo e-mail vazio e campo senha vazio, NÃO DEVE ser redirecionado para tela inicial
    Dado estar na página de login
    Quando campo e-mail vazio e campo senha vazio, clicar no botão entrar
    Entao não deve ser redirecionado para a tela inicial, deve mostrar a mensagem <email_em_branco> e <password_em_branco>
    Exemplos:
      | email_em_branco                   | password_em_branco                  |
      | "Email não pode ficar em branco"  | "Password não pode ficar em branco" |
