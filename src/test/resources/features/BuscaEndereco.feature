# language: pt
Funcionalidade: Buscar Endereço
  Como um usuario do sistema Bookstore
  Desejo consultar um endereco a partir do CEP
  Para que eu possa usar o endereco para fazer um pedido

  Cenário: Consultar um endereço valido
    Dado um CEP valido:
      | cep | 13083970 |
    Quando eu informo o CEP na busca de endereco
    Então o resultado deve ser o endereco:
      | Logradouro       | Cidade   |
      | Rua Carlos Gomes | Campinas |

  Cenário: Consultar um endereco com CEP nao existente
    Dado um CEP nao existente:
      | cep | 99999999 |
    Quando eu informo o CEP na busca de endereco
    Então o retorno deve conter um valor de erro igual a "true"

  Cenário: Consultar um endereco com CEP invalido.
    Dado um CEP invalido:
      | cep | 1234567890 |
    Quando eu informo o CEP na busca de endereco
    Então uma excecao deve ser lancada com a mensagem de erro:
    """
    O CEP informado é invalido
    """

  Cenário: Servico ViaCep nao responde
    Dado um CEP valido:
      | cep | 13083970 |
    E o servico ViaCep nao esta respondendo
    Quando eu informo o CEP na busca de endereco
    Então uma excecao deve ser lancada com a mensagem de erro:
    """
    Serviço indisponivel
    """
    
  Cenário: Campo de busca de CEP vazio
    Dado um CEP vazio:
      | cep | 0 |
    Quando eu informo o CEP vazio
    Então um aviso deve ser lançada:
    """
    O CEP informado está em branco
    """
