# language: pt
Funcionalidade: Consultar Entrega
  Como um usuário do sistema Bookstore
  Desejo consultar um endereço a partir do CEP
  Para que eu possa usar o endereço para fazer um pedido

  Cenário: Consultar uma entrega válida [código do pedido existente]
    Dado um CEP válido:
      | cep | 13083970 |
    Quando eu informo o CEP na busca de endereço
    Então o resultado deve ser o endereço:
      | Logradouro       | Cidade   |
      | Rua Carlos Gomes | Campinas |

  Cenário: Consultar uma entrega não válida [código do pedido inexistente]
    Dado um CEP não existente:
      | cep | 99999999 |
    Quando eu informo o CEP na busca de endereço
    Então o retorno deve conter um valor de erro igual a "true"

  Cenário: Consultar uma entrega com Pedido inválido.
    Dado um CEP inválido:
      | cep | 1234567890 |
    Quando eu informo o CEP na busca de endereço
    Então uma exceção deve ser lançada com a mensagem de erro:
    """
    O CEP informado é invalido
    """

  Cenário: Serviço ConsultaEntrega não responde
    Dado um CEP válido:
      | cep | 13083970 |
    E o serviço ViaCep não esta respondendo
    Quando eu informo o CEP na busca de endereço
    Então uma exceção deve ser lançada com a mensagem de erro:
    """
    Serviço indisponivel
    """
