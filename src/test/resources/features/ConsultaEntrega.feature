# language: pt
Funcionalidade: Consultar Entrega
  Como um usuário do sistema Bookstore
  Desejo consultar um endereço a partir do CEP
  Para que eu possa usar o endereço para fazer um pedido

  Cenário: Consultar uma entrega válida [código do pedido existente]
    Dado Eu tenho um Código de rastreio válido:
      | codigorastreio | AA123456789BR |
    Quando eu informo o Codigo de rastreio na busca de status de entrega
    Então o resultado deve ser o:
      | Codigo de rastreamento       | Status              | Dados Frete | Tempo Entrega
      | AA123456789BR					       | EntregueComSucesso  |  R$ 22,00   |  3 dias

  Cenário: Consultar uma entrega com Codigo de rastreamento inválido.
    Dado Eu tenho um Código de rastreio inválido:
      | codigorastreio | 123 |
    Quando eu informo o Codigo de rastreio na busca de status de entrega  
    Então uma exceção deve ser lançada com a mensagem de erro:
    """
    Codigo de rastreio invalido
    """

  Cenário: Serviço Consulta Status Entrega não responde
      Dado um Código de rastreio válido:
      | codigorastreio | AA123456789BR |
    Quando eu informo o Codigo de rastreio na busca de status de entrega
    Então uma exceção deve ser lançada com a mensagem de erro:
    """
    Serviço indisponivel
    """
